/**
 * @author Link Parrish
 * Account class that tracks an account number and balance
 */
package assg3_parrishl21;

public class Account {
	
	private String acctNo;
	private double balance;
	
	/**
	 * 1 parameter constructor 
	 * @param acctNo the account number
	 */
	public Account(String acctNo) {
		this(acctNo, 0.0);
	}
	
	/**
	 * 2 parameter constructor
	 * @param acctNo the account number
	 * @param balance the account balance
	 */
	public Account(String acctNo, double balance) {
		this.acctNo = acctNo;
		if (balance >= 0)
			this.balance = balance;
		else {
			System.out.println("error: balance should be non-negative, setting balance to 0");
			this.balance = 0.0;
		}
	}
	
	/**
	 * get the account number
	 * @return the account number
	 */
	public String getAcctNo() {
		return this.acctNo;
	}
	
	/**
	 * get the account balance
	 * @return the account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * change the account balance
	 * @param balance the new account balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * deposit an amount into the account
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		if (amount > 0) 
			this.balance = this.balance + amount;
		
		else
			System.out.println("error: deposit amount should be positive");
	}
	
	/**
	 * withdraw an amount from the account
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (amount > 0) {
			if (this.balance - amount >= 0)
				this.balance = this.balance - amount;
		
			else
				System.out.println("error: balance not high enough for withdraw of " + amount);
		}
		else
			System.out.println("error: withdraw amount should be positive");
	}
	
	/**
	 * transfer money from one account to another
	 * @param otherAcct the account to transfer to
	 * @param amount the amount to transfer
	 */
	public void transfer(Account otherAcct, double amount) {
		if (amount > 0) {
				if (this.balance - amount >= 0) {
					this.balance = this.balance - amount;
					otherAcct.deposit(amount);
				}
				else
					System.out.println("error: balance not high enough for a transfer of " + amount);
		}
		else
			System.out.println("error: transfer amount should be positive");	
	}
	
	/**
	 * prints the account number and account balance
	 */
	public void displayInfo() {
		System.out.println("Account Number: " + this.acctNo);
		System.out.println("Current Balance: " + this.balance);
	}
	
	/**
	 * returns a string with the account number and account balance
	 */
	@Override
	public String toString() {
		return "Account Number: " + this.acctNo + "\nCurrent Balance: " + this.balance; 
	}
	
	/**
	 * checks if an object is a Account with the same account number
	 * @param obj the object to compare
	 * @return true if object is the same, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Account) {
			Account temp = (Account)obj;
			return (this.acctNo.equals(temp.acctNo));
		}
		else
			return false;
	}
}