package model;

/*
 * Template of a collection of entries
 */
public class RefurbishedStore {
	private Entry[] entries; // an array of Entry object references
	/*
	 * number of entries (2 purposes):
	 * 1. Records how many (non-null) entries that have been stored in the array
	 * 2. Indicates the index of the 'entries' array that will store the next entry reference
	 */
	private int noe;
	private final int MAX_CAPACITY = 5; // constant (must have key word 'final')
	
	/* constructors */
	public RefurbishedStore() {
		this.entries = new Entry[MAX_CAPACITY];
		this.noe = 0;
	}
	
	/* accessors */
	public int getNumberOfEntries() {
		return this.noe;
	}
	
	public Entry[] getPrivateEntriesArray() {
		return this.entries;
	}
	/*
	 * Retrieve the array of entries, arranged in the chronological order
	 * in which they were inserted
	 */
	public Entry[] getEntries() {
		Entry[] es = new Entry[this.noe];
		
		for (int i = 0; i < this.noe; i++) {
			es[i] = this.entries[i];
		}
		return es;
	}
	
	public Product getProduct(String sn) {
		int index = -1; // expected to be re-assigned to a valid index if the 'sn' exists in the store
		// Problematic exit condition: i < this.entries.length
		for (int i = 0; i < this.noe; i++) {
			Entry e = this.entries[i];
			if (e.getSerialNumber().equals(sn)) {
				index = i;
			}
		}
		
		if(index < 0) {
			return null;
		}
		else {
			return this.entries[index].getProduct();
		}
	}
	/*
	 * Return the serial number of all products that are 
	 * either with Space Grey finish or is a Pro
	 */
	public String[] getSpaceGreyOrPro() {
		int count = 0; // number of products satisfying search criteria
		int[] indices = new int[this.noe]; // indices of entry objects, in entry array, that satisfy search criteria
		
		// Step 1: collect all products satisfying search criteria
		for (int i = 0; i < noe; i++) {
			Product p = this.entries[i].getProduct();
			
			if (p.getModel().contains("Pro") || (p.getFinish() != null && p.getFinish().equals("Space Grey"))) {
				indices[count] = i;
				count++;
			}
		}
		
		// Step 2: Create an array of strings (for serial numbers) whose size is 'count'
		String[] sns = new String[count];
		
		for (int i = 0; i < count; i++) {
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
	
	/*
	 * Return the serial number of all products that are 
	 * either with Space Grey finish AND is a Pro
	 */
	public String[] getSpaceGreyPro() {
		int count = 0; // number of products satisfying search criteria
		int[] indices = new int[this.noe]; // indices of entry objects, in entry array, that satisfy search criteria
		
		// Step 1: collect all products satisfying search criteria
		for (int i = 0; i < noe; i++) {
			Product p = this.entries[i].getProduct();
			
			if (p.getModel().contains("Pro") && p.getFinish() != null && p.getFinish().equals("Space Grey")) {
				indices[count] = i;
				count++;
			}
		}
		
		// Step 2: Create an array of strings (for serial numbers) whose size is 'count'
		String[] sns = new String[count];
		
		for (int i = 0; i < count; i++) {
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		return sns;
	}
	
	/* Mutators*/
	// for now, assume that serial number of input 'e' does not exist in collection
	public void addEntry(Entry e) {
		this.entries[this.noe] = e;
		this.noe ++;
	}
	
	public void addEntry(String sn, Product p) {
//		Entry ne = new Entry(sn, p);
//		this.entries[this.noe] = ne;
//		this.noe ++;
		this.addEntry(new Entry(sn, p));
	}
	
	public void addEntry(String sn, String model, double originalPrice) {
//		Product p = new Product(model, originalPrice);
//		Entry ne = new Entry(sn, p);
//		this.entries[this.noe] = ne;
//		this.noe ++;
		this.addEntry(new Entry(sn,new Product(model, originalPrice)));
	}

}








