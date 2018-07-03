Wallet Microserver
Neil St. Amour	
2018-07-03

The Wallet Microserver runs on the localhost and manages the funds of a user allowing the server to 
credit, debit, and check balance. For large scale use an appropriate database should be used and 
connected with this module, currently this code uses several example users with an already existing 
credit balance that will be reset whenever the server is restarted. All changes to balances should 
persist until the server has been stopped.

The valid users are: 
Tadeas
Gustaf
Neil

The accepted requests for the server are:
/balance
	This will return the wallet object for the chosen user in JSON where you can see the username and 
	current balance. Balance can also be seen in System.out
	
/credit
	This will give the amount of credits to the chosen user
	
/debit
	This will subtract the amount of credits from the chosen user
	
The valid parameters are as followed:
username
	This indicates the user to be managed by the given request. This parameter is required for all requests.
	
amount
	This determines the amount of "currency" to be added or subtracted from the given users balance. This
	parameter is required for all debit and credit requests
	
Some example requests below:
	http://localhost:8080/balance?username=Tadeas
	http://localhost:8080/credit?username=Neil&amount=30
	http://localhost:8080/debit?username=Gustaf&amount=10 (this request will bounce until credit brings
	balance in to the positives)
	
To run the server simply run the jar file that can be found at the top of the directory
	java -jar ./wallet-microserver_NeilStAmour-1.0.jar
	
All java source code can be found in src/main/java/wallet

I was uncertain what was meant by a transaction ID and figured that would be the username associated with the 
wallet which is why it needs to be globally unique. In the case where it was meant to be an ID to identify 
and keep track of transactions then I would have used a number created from the time of transaction to ensure 
the number can't occur again.