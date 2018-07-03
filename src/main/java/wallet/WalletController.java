package wallet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
	
	// Example users are created for testing the credit, debit, and balance requests, will reset every time server is run
    final Wallet[] wallets = new Wallet[] {new Wallet("_invalid", -1), 
    		new Wallet("Tadeas", 500), 
    		new Wallet("Gustaf", -60), 
    		new Wallet("Neil", 10)};

    // Balance request will return the wallet for the given username which includes the balance
    @RequestMapping("/balance")
    public Wallet balance(@RequestParam(value="username", defaultValue="_invalid") String username) {
    	//finds wallet with matching username
        for(int i = 0; i < wallets.length; i++)
        	if(wallets[i].getUsername().equals(username)) {
        		System.out.println(username + "'s balance is: " + wallets[i].getBalance());
        		return(wallets[i]);
        	}
    	System.out.println("Invalid user");
		return(wallets[0]);
    }
    
    // Credit request will credit the given username for the amount in the parameter, returns the wallet so changes can be seen
    @RequestMapping("/credit")
    public Wallet credit(@RequestParam(value="username", defaultValue="_invalid") String username,
    			@RequestParam(value="amount", defaultValue="0") int amount) {
    	//finds wallet with matching username
        for(int i = 0; i < wallets.length; i++)
        	if(wallets[i].getUsername().equals(username))
        	{
        		System.out.println("Credit Completed");
        		wallets[i].setBalance(wallets[i].getBalance() + amount);
        		return wallets[i];
        	}
    	System.out.println("Invalid user");
        return wallets[0];
    }

    // Debit request will deduct the amount given from the user chosen in the parameter, returns the wallet so changes can be seen
    @RequestMapping("/debit")
    public Wallet debit(@RequestParam(value="username", defaultValue="_invalid") String username,
    			@RequestParam(value="amount", defaultValue="0") int amount) {
    	//finds wallet with matching username
        for(int i = 0; i < wallets.length; i++)
        	if(wallets[i].getUsername().equals(username))
        		//Ensures that balance is greater than amount to be deducted, otherwise return wallet with no change
            	if(wallets[i].getBalance() >= amount)
	        	{
            		System.out.println("Debit Completed");
	        		wallets[i].setBalance(wallets[i].getBalance() - amount);
	        		return wallets[i];
	        	}
            	else
            	{
            		System.out.println("Insufficient Credits");
	        		return wallets[i];
            	}
    	System.out.println("Invalid user");
        return wallets[0];
    }
}