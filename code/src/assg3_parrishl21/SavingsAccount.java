/**
 * @author Link Parrish
 * Savings Account is an extension of Account, it adds an interest system
 */
package assg3_parrishl21;

public class SavingsAccount extends Account {
	
	private double interestRate;
	
	/**
	 * 1 parameter constructor
	 * @param acctNo the account number
	 */
	public SavingsAccount(String acctNo) {
		this(acctNo, 0.0, 0.0);
	}
	
	/**
	 * 3 parameter constructor
	 * @param acctNo the account number
	 * @param balance the account balance
	 * @param interestRate the interest rate
	 */
	public SavingsAccount(String acctNo, double balance, double interestRate) {
		super(acctNo, balance);
		this.interestRate = interestRate;
	}

	/**
	 * get the interest rate
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * change the interest rate
	 * @param interestRate the new interest rate
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * calculates the interest and adds it to the balance
	 */
	public void addInterest() {
		this.setBalance((1 + this.interestRate) * this.getBalance());
	}
	
	/**
	 * prints the account number, current balance, and the interest rate
	 */
	@Override
	public void displayInfo() {
		System.out.println("Account Number: " + this.getAcctNo());
		System.out.println("Current Balance: " + this.getBalance());
		System.out.println("Interest Rate: " + this.interestRate);
	}
	
	/**
	 * returns a string that contains the account number, account balance, and the interest rate
	 */
	@Override
	public String toString() {
		return "Account Number: " + this.getAcctNo() + "\nCurrent Balance: " + this.getBalance() + "\nInterest Rate: " + this.interestRate; 
	}
}
