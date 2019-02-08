package StringSet;

/**
 	* Lab2: Collection Class
 	* Assigned by Professor Huiping Cao
 	* Design a data structure StringSet, which can be used to store 
 	* all the authors of a book.
 	*@author Xiana Lara
 	*@version
 	* February 7, 2019
**/

public class StringSet {
	
	// Instance Variables:
	// 1. StringVals is used to represent the amount 
	//    of elements in the string array
	// 2. capacity is used to represent the total 
	//    capacity of the array
	// 3. data is used to represent the array, 
	//    containing all of the elements

	private int StringVals;
	private int capacity; 
	private String[] data = new String[capacity]; 
	
	/**
	   * Initialize an empty StringSet with an initial capacity of 10.  
	   * Note that the add method works efficiently (without 
	   * needing more memory) until this capacity is reached.
	   * @param - none
	   * @postcondition
	   *   This StringSet is empty and has an initial capacity of 2.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for: 
	   *   new int[2].
	**/ 
	
	public StringSet() {
		
		capacity = 2; 
		data = new String[capacity];
	} // no argument constructor
	
	/**
	   * Initialize the StringSet with a capacity. 
	   * Note that the add method works efficiently (without 
	   * needing more memory) until this capacity is reached.
	   * @param _capacity
	   *   the initial capacity of this StringSet
	   * @precondition
	   *   _capacity is non-negative.
	   * @postcondition
	   *   This StringSet is empty and has the given capacity.
	   * @exception IllegalArgumentException
	   *   Indicates that _capacity is negative.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for: new int[_capacity].
	**/ 
	
	public StringSet(int _capacity) {
		
		if (_capacity < 0)
			throw new IllegalArgumentException
	        ("The initialCapacity is negative: " + _capacity);
		
		capacity = _capacity;
		data = new String[capacity];
		
	} // of one argument constructor 
	
	public StringSet(Object obj) {
		
		if( obj != null){
			if(obj instanceof StringSet) {
				// After casting the obj as a StringSet
				// setting all the variables to the ones 
				// set with the object
				StringSet objStringSet = (StringSet)obj;
				StringVals = objStringSet.StringVals;
				capacity = objStringSet.capacity;
				data = objStringSet.data;
				for(int i = 0; i < StringVals; i++) 
						data[i] = objStringSet.data[i]; 
			}// if instance of
		}// if not null
	}// of copy constructor
	
	/**
	   * Determine the number of elements in this StringSet.
	   * @param - none
	   * @return
	   *   the number of elements in this StringSet
	**/
	
	public int size() {
		return StringVals;
	} // of size
	
	/**
	   * Accessor method to get the current capacity of this StringSet. 
	   * The add method works efficiently (without needing
	   * more memory) until this capacity is reached.
	   * @param - none
	   * @return
	   *   the current capacity of this StringSet
	**/
	public int capacity() {
		return capacity;
	} // of capacity
	
	/**
	   * Add a new String to this StringSet. If the new element 
	   * would take this bag beyond its current capacity, then
	   * the capacity is increased before adding the new element.
	   * @param a
	   *   the new String that is being added
	   * @postcondition
	   *   A new String has been added to this StringSet.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for increasing the
	   *   bag's capacity.
	**/
	
	public void add(String a) {
		if(a != null) {
			if(capacity == StringVals) {
				capacity = data.length *2;
				String[] newArr = new String [capacity];
				System.arraycopy(data, 0, newArr, 0, StringVals);
				data = newArr;
				data[StringVals] = a;
				StringVals++;
			}// of if
			else {
				data[StringVals] = a;
				StringVals++;
			}// of else
		}// of if null
	}// of add 
	
	/**
	   * Check the StringSet for a specific String.
	   * @param a
	   *   the String that is being looked for in the StringSet.
	   * @postcondition
	   *   A true or false depending on if the String is located.
	   * @return
	   * 	true or false
	**/
	
	public boolean contains(String a){
		if(a != null) {	
			for(int i = 0; i < StringVals; i++) {
				if(data[i].equals(a)) {
					return true;
				} // of if
			}// of for
		}// of if
		return false;
	} // of contains
	
	/**
	   * Remove one copy of a specified element from this StringSet.
	   * @param a
	   *   the element to remove from the StringSet
	   * @postcondition
	   *   If a was found in the StringSet, then one copy of
	   *   target has been removed and the method returns true. 
	   *   Otherwise the StringSet remains unchanged and the method 
	   *   returns false. 
	   * @return
	   * 	true or false
	**/
	
	public boolean remove(String a) {
		if(a != null) 
			for(int i = 0; i < StringVals; i++) {
				if(data[i].equals(a)) {
					data[i] = data[StringVals - 1];
					StringVals--;
					return true;
				} // of if 
			} // of for 
		return false;
	}// of remove
	
	/**
	   * Change the current capacity of this StringSet.
	   * @param minimumCapacity
	   *   the new capacity for this bag
	   * @postcondition
	   *   StringSet capacity has been changed to at least 
	   *   minimumCapacity. If the capacity was already at 
	   *   or greater than minimumCapacity, then the capacity 
	   *   is left unchanged.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for: new int[minimumCapacity].
	**/
	private void ensureCapacity(int minimumCapacity) {
		if(minimumCapacity > 0) {
			if(capacity < minimumCapacity) {
				capacity = minimumCapacity;
				String[] newArr = new String [capacity];
				System.arraycopy(data, 0, newArr, 0, StringVals);
				data = newArr;
			} // of if 
		} // of if
	} // of ensure capacity
	
	/**
	   * Add a new String to StringSet in ascending order
	   * @param a
	   *   the new String to be added
	   * @postcondition
	   *   StringSet is now alphabetically organized and has
	   *   added a new String.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for increasing the
	   *   StringSet's capacity.
	**/
	public void addOrdered(String a) {
		
		if(a == null) return; 
		
		// setting capacity to hold a new element
		String temp; 
		if(capacity < StringVals + 1) {
			ensureCapacity(StringVals + 1);
		}
		
		data[StringVals] = a;
		StringVals ++;
		
		//  Nested for loops to alphabetize the entire string 
		for(int j = 0; j < StringVals - 1; j++) 
			for(int i = 0; i < StringVals - 1; i++){
				if(data[i].charAt(0) >= data[i + 1].charAt(0)){
					temp = data[i + 1]; 
					data[i + 1] = data[i];
					data[i] = temp; 
				}// of if
			}// of for
	
	}
	
	public static void main(String[] args) {
		
		// initializing two new StringSets
		StringSet s1 = new StringSet(); 
		StringSet s2 = new StringSet(3); 
		
		// adding names to StringSet 1
		s1.add("Joel");
		s1.add("Pimentel");
		s1.add("Christoper");
		s1.add("Velez");
		
		// Size, Capacity, and Contents of StringSet 1
		System.out.println("Size of S1: " + s1.size());
		System.out.println("Capacity of S1: " + s1.capacity());
		System.out.println("Contents of S1: ");
		for(int i = 0; i < s1.StringVals; i++) {
			System.out.println(s1.data[i]);
		}
		
		System.out.println();
		s1.addOrdered("Richard");
		System.out.println("Contents of S1 after addOrdered: ");
		
		for(int i = 0; i < s1.StringVals; i++) {
			System.out.println(s1.data[i]);
		}
		
		System.out.println();
		s1.ensureCapacity(5);
		System.out.println("Capacity of S1 after ensureCapacity: " + s1.capacity());
		
		System.out.println();
		System.out.println("Does S1 contain Joel: " + s1.contains("Joel"));
		System.out.println("Does S1 contain Zabdiel: " + s1.contains("Zabdiel"));
		
		System.out.println();
		
		// adding names to StringSet 2
		s2.add("Erick ");
		s2.add("Brian");
		s2.add("Colon");
		
		// Size, Capacity, and Contents of StringSet 2
		System.out.println("Size of S2: " + s2.size());
		System.out.println("Capacity of S2: " + s2.capacity());
		System.out.println("Contents of S2: ");
		for(int i = 0; i < s2.StringVals; i++) {
			System.out.println(s2.data[i]);
		}
		
		System.out.println();
		System.out.println("If there is Zabdiel in S2 remove: " + s2.remove("Zabdiel"));
		System.out.println("If there is Brian in S2 remove: " + s2.remove("Brian"));
		for(int i = 0; i < s2.StringVals; i++) {
			System.out.println(s2.data[i]);
		}
		
		System.out.println();
		s2.addOrdered("Zabdiel");
		System.out.println("Contents of S2 after addOrdered: ");
		for(int i = 0; i < s2.StringVals; i++) {
			System.out.println(s2.data[i]);
		}
		
		System.out.println();
		StringSet copy_s1 = new StringSet(s1);
		
		System.out.println("Size of copy_s1: " + copy_s1.size());
		System.out.println("Capacity of copy_s1: " + copy_s1.capacity());
		System.out.println("Contents of copy_s1: ");
		for(int i = 0; i < copy_s1.StringVals; i++) {
			System.out.println(copy_s1.data[i]);
		}
		
		
	}
}// of StringSet class