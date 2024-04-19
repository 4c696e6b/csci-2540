/**
 * @author Link Parrish
 * tests the Account, CheckingAccount, and SavingsAccount classes
 */
package assg3_parrishl21;

public class AccountTest {

	public static void main(String[] args) {
		
		// testing Account class
		System.out.println("testing Account class:\n");
		
		// test constructors
		Account a1 = new Account("001");
		Account a2 = new Account("002", 50.0);
		Account a4 = new Account("004", -10);
		
		// test toString and displayInfo
		System.out.println("testing toString and display info:\n");
		System.out.println(a1);
		a2.displayInfo();
		a4.displayInfo();
		System.out.println();
		
		// test getters and setters
		System.out.println("testing getters and setters:\n");
		System.out.println("a1 acctNo: " + a1.getAcctNo() + ", a1 balance: " + a1.getBalance());
		
		a2.setBalance(100);
		System.out.println("a2 set balance 100:");
		a2.displayInfo();
		System.out.println();
		
		// test deposit
		System.out.println("testing deposit:\n");
		
		System.out.println("a1 deposit 200");
		a1.deposit(200);
		a1.displayInfo();
		System.out.println();
		
		System.out.println("a1 deposit -100 (should fail)");
		a1.deposit(-100);
		a1.displayInfo();
		System.out.println();
		
		// test withdraw
		System.out.println("testing withdraw:\n");
		
		System.out.println("a1 withdraw 100");
		a1.withdraw(100);
		a1.displayInfo();
		System.out.println();
		
		System.out.println("a1 withdraw 101 (should fail)");
		a1.withdraw(101);
		a1.displayInfo();
		System.out.println();
		
		System.out.println("a1 withdraw -100 (should fail)");
		a1.withdraw(-100);
		a1.displayInfo();
		System.out.println();
		
		// test transfer
		System.out.println("testing transfer:\n");
		
		System.out.println("a1 transfer 50 to a2");
		a1.transfer(a2, 50);
		a1.displayInfo();
		a2.displayInfo();
		System.out.println();
		
		System.out.println("a1 transfer 51 to a2 (should fail)");
		a1.transfer(a2, 51);
		a1.displayInfo();
		a2.displayInfo();
		System.out.println();
		
		System.out.println("a1 transfer -50 to a2 (should fail)");
		a1.transfer(a2, -50);
		a1.displayInfo();
		a2.displayInfo();
		System.out.println();
		
		// test equals
		System.out.println("testing equals:\n");
		
		Account a3 = new Account("001");
		a3.displayInfo();
		System.out.println();
		
		System.out.println("does a1 = a3: " + a1.equals(a3));
		System.out.println("does a1 = a2: " + a1.equals(a2));
		System.out.println();
		
		
		// testing CheckingAccount class
		System.out.println("testing the CheckingAccount class");
		
		// test constructors
		CheckingAccount ca1 = new CheckingAccount("C001");
		CheckingAccount ca2 = new CheckingAccount("C002", 200.0, -300.0);
		
		// test toString and displayInfo
		System.out.println("testing toString and display info:\n");
		System.out.println(ca1);
		ca2.displayInfo();
		System.out.println();
		
		// test getters and setters
		System.out.println("testing getters and setters:\n");
		System.out.println("ca1 overdraft: " + ca1.getOverdraft() + ", overdraft fee: " + CheckingAccount.getFee());
		System.out.println();
		
		System.out.println("set ca1 overdraft to -100");
		ca1.setOverdraft(-100);
		ca1.displayInfo();
		System.out.println();
		
		System.out.println("set ca1 overdraft to 100 (should fail)");
		ca1.setOverdraft(100);
		ca1.displayInfo();
		System.out.println();
		
		System.out.println("set fee to 10");
		CheckingAccount.setFee(10.0);
		System.out.println("new fee: " + CheckingAccount.getFee());
		System.out.println();
		
		System.out.println("set fee to -10 (should fail)");
		CheckingAccount.setFee(-10.0);
		System.out.println("new fee: " + CheckingAccount.getFee());
		System.out.println();
		
		// test withdraw
		System.out.println("testing withdraw:\n");
		
		System.out.println("ca1 withdraw 100 (should fail)");
		ca1.withdraw(100);
		ca1.displayInfo();
		System.out.println();
		
		System.out.println("ca2 withdraw 100");
		ca2.withdraw(100);
		ca2.displayInfo();
		System.out.println();
		
		System.out.println("ca2 withdraw 200");
		ca2.withdraw(200);
		ca2.displayInfo();
		System.out.println();
		
		System.out.println("ca2 withdraw -200 (should fail)");
		ca2.withdraw(-200);
		ca2.displayInfo();
		System.out.println();
		
		// test transfer
		System.out.println("testing transfer:\n");
		
		System.out.println("reset balances:");
		ca1.setBalance(0.0);
		ca2.setBalance(100.0);
		System.out.println();
		
		System.out.println("ca1 transfer 50 to ca2");
		ca1.transfer(ca2, 50);
		ca1.displayInfo();
		ca2.displayInfo();
		System.out.println();
		
		System.out.println("ca2 transfer 100 to ca1");
		ca2.transfer(ca1, 100);
		ca1.displayInfo();
		ca2.displayInfo();
		System.out.println();
		
		System.out.println("ca1 transfer 50 to ca2 (should fail)");
		ca1.transfer(ca2, 50);
		ca1.displayInfo();
		ca2.displayInfo();
		System.out.println();
		
		System.out.println("ca1 transfer -50 to ca2 (should fail)");
		ca1.transfer(ca2, -50);
		ca1.displayInfo();
		ca2.displayInfo();
		System.out.println();
		
		// testing SavingsAccount class
		System.out.println("testing the SavingsAccout class:\n");
		
		// test constructors
		SavingsAccount sa1 = new SavingsAccount("S001");
		SavingsAccount sa2 = new SavingsAccount("S002", 100, 0.10);
		
		// test toString and displayInfo
		System.out.println("testing toString and display info:\n");
		System.out.println(sa1);
		sa2.displayInfo();
		System.out.println();
		
		// test getters and setters
		System.out.println("testing getters and setters:\n");
		System.out.println("setting sa1 interest rate to 0.10");
		sa1.setInterestRate(0.10);
		System.out.println("sa1 interest rate: " + sa1.getInterestRate());
		
		// test addInterest
		System.out.println("testing addInterest:\n");
		sa2.addInterest();
		sa2.displayInfo();
		System.out.println();
		
		// test transfer between checking and savings accounts
		System.out.println("testing transfer between checking and savings accounts\n");
		
		CheckingAccount tt1 = new CheckingAccount("0001", 100, -100);
		SavingsAccount tt2 = new SavingsAccount("0002", 100, 0.10);
		
		tt1.displayInfo();
		tt2.displayInfo();
		System.out.println();
		
		System.out.println("tt1 transfer 150 to tt2");
		tt1.transfer(tt2, 150);
		tt1.displayInfo();
		tt2.displayInfo();
		System.out.println();
		
		System.out.println("tt2 transfer 150 to tt1");
		tt2.transfer(tt1, 150);
		tt1.displayInfo();
		tt2.displayInfo();
	}
}
