package model;

public class Account {
	private String name;
	private int bal;
	
	private String report;
	private boolean vip;
	private int deposit;
	
	/* Constructors */
	public Account(String n, int b) {
		this.name = n;
		this.bal = b;
		this.vip = false;
		this.deposit = 0;
		this.report = String.format("A regular account owned by %s with balance $%d", this.name, this.bal);
	}
	
	public Account(Account a) { // copy constructor
		this.name = a.name;
		this.bal = a.bal;
		this.vip = a.vip;
		this.deposit = a.deposit;
		this.report = a.report;
	}
	
	/* Accessors */
	public String toString() {
		return this.report;
	}
	public boolean equals(Object a) {
		if (this == a) {
			return true;
		}
		Account other = (Account) a;
		return (this.name.equals(other.name)) && (this.bal == other.bal) && (this.vip == other.vip);
	}
	
	/* Mutators */
	public void switchToVIP(int d) throws InvalidStatusToSwitchException, InsufficientBalanceException {
		if (this.vip == true) {
			throw new InvalidStatusToSwitchException("Unexpected exception thrown");
		}
		else if (this.bal < d) {
			throw new InsufficientBalanceException("Unexpected exception thrown");
		}
		else {
			this.deposit = d;
			this.vip = true;
			this.bal -= this.deposit;
			this.report = String.format("A VIP account owned by %s with balance $%d ($%d deposited for maintaining the VIP stauts)", 
												this.name, this.bal, this.deposit);
		}
	}
	public void switchToRegular() throws InvalidStatusToSwitchException {
		if (this.vip == false) {
			throw new InvalidStatusToSwitchException("Unexpected exception thrown");
		}
		else {
			this.vip = false;
			this.bal += this.deposit;
			this.report = String.format("A regular account owned by %s with balance $%d", 
												this.name, this.bal);
		}
	}
}
