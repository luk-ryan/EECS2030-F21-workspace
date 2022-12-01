package model;

public class Bank {
	private Account[] accounts;
	private final int MAX_NUMBER_OF_ACCOUNTS = 5;
	
	/* Constructors */
	public Bank() {
		this.accounts = new Account[0];
	}
	
	public Bank(Bank b) { // copy constructor
		this.accounts = b.accounts;
	}
	
	/* Accessors */
	public int getNumberOfAccounts() {
		return this.accounts.length;
	}
	public Account[] getReferencesOfAccounts() {
		return this.accounts;
	}
	public Account[] getCopiesOfAccounts() {
		Account[] copy = new Account[this.accounts.length];
		for (int i = 0; i < this.accounts.length; i++) {
			copy[i] = new Account(this.accounts[i]);
		}
		return copy;
	}
	
	public boolean equals(Object b) {
		if (this == b) {
			return true;
		}
		Bank other = (Bank) b;
		if (this.accounts.length != other.accounts.length) {
			return false;
		}
		boolean isEqual = true;
		for (int i = 0; i < this.accounts.length; i++) {
			if (!(this.accounts[i].equals(other.accounts[i]))) {
				isEqual = false;
			}
		}
		return isEqual;
	}
	
	/* Mutators */
	public void addAccount(Account a) {
		
		if (this.accounts.length < MAX_NUMBER_OF_ACCOUNTS) {
			Account[] tempArray = new Account[this.accounts.length + 1]; // create temp array for a new index
			int i;

			for (i = 0; i < this.accounts.length; i++) { // put existing items into temp array
				tempArray[i] = this.accounts[i];
			}

			tempArray[tempArray.length - 1] = a; // put the input into last index of temp array
			this.accounts = new Account[tempArray.length]; // make original array length the same as temp array

			for (i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.accounts[i] = tempArray[i];
			}
		}
	}
	
	public void addAccounts(Account[] a) { // overloaded version of add account
		for (int i = 0; i < a.length; i++) {
			addAccount(a[i]);
		}
	}
}
