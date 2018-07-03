package wallet;

public class Wallet {

    private String username;
    private int balance;

    public Wallet(String username, int balance) {
    	
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}