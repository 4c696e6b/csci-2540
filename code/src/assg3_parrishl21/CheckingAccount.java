/**
 * @author Link Parrish
 * CheckingAccount is an extension of Account, it adds an overdraft system 
 */
package assg3_parrishl21;

public class CheckingAccount extends Account {
	private double overdraft;
	private static double overdraftFee = 5.0;
	
	/**
	 * 1 parameter constructor
	 * @param acctNo the account number
	 */
	public CheckingAccount (String acctNo) {
		this(acctNo, 0.0, 0.0);
	}
	
	/**
	 * 3 parameter constructor
	 * @param acctNo the account number
	 * @param balance the account balance
	 * @param overdraft the overdraft limit
	 */
	public CheckingAccount(String acctNo, double balance, double overdraft) {
		super(acctNo, balance);
		this.overdraft = overdraft;
	}
	
	/**
	 * get the overdraft limit
	 * @return the overdraft limit
	 */
	public double getOverdraft() {
		return this.overdraft;
	}
	
	/**
	 * change the overdraft limit
	 * @param overdraft the new overdraft limit
	 */
	public void setOverdraft(double overdraft) {
		if (overdraft <= 0)
			this.overdraft = overdraft;
		else
			System.out.println("error: overdraft should be <= to 0");
	}
	
	/**
	 * get the overdraft fee
	 * @return the overdraft fee
	 */
	public static double getFee() {
		return overdraftFee;
	}
	
	/**
	 * change the overdraft fee
	 * @param fee the new overdraft fee
	 */
	public static void setFee(double fee) {
		if (fee >= 0)
			overdraftFee = fee;
		else
			System.out.println("error: fee should be >= 0");
	}
	
	/**
	 * withdraw an amount from the account
	 * @param amount the amount to withdraw
	 */
	@Override
	public void withdraw(double amount) {
		if (amount > 0) {
			if (this.getBalance() - amount >= 0.0)
				this.setBalance(this.getBalance() - amount);
			
			else if (this.getBalance() - amount - overdraftFee >= overdraft)
				this.setBalance(this.getBalance() - amount - overdraftFee);
			
			else
				System.out.println("error: balance not high enough for withdraw of " + amount);
		}
		else
			System.out.println("error: withdraw amount should be positive");
	}
	
	/**
	 * transfer an amount to another account
	 * @param otherAcct the account to transfer to
	 * @param the amount to transfer
	 */
	@Override
	public void transfer(Account otherAcct, double amount) {
		if (amount > 0) {
			
				if (this.getBalance() - amount >= 0.0) {
					this.setBalance(this.getBalance() - amount);
					otherAcct.deposit(amount);
				}
			
				else if (this.getBalance() - amount - overdraftFee >= overdraft) {
					this.setBalance(this.getBalance() - amount - overdraftFee);
					otherAcct.deposit(amount);
				}
				else
					System.out.println("error: balance not high enough for a transfer of " + amount);
		}
		else
			System.out.println("error: transfer amount should be positive");	
	}
	/**
	 * prints the account number, account balance, and the overdraft amount
	 */
	@Override
	public void displayInfo() {
		System.out.println("Account Number: " + this.getAcctNo());
		System.out.println("Current Balance: " + this.getBalance());
		System.out.println("Overdraft Amount: " + this.overdraft);
	}
	
	/**
	 * returns a string with the account number, account balance, and overdraft amount
	 */
	@Override
	public String toString() {
		return "Account Number: " + this.getAcctNo() + "\nCurrent Balance: " + this.getBalance() + "\nOverdraft Amount: " + this.overdraft;
	}
}