/**
* Lab9: RecursiveQuestion 
* Assigned by Professor Huiping Cao
* Implement and test recursive algorithms
*@author 
* Xiana Lara
*@version
* March 26, 2019
**/

package recursiveQuestion;

public class RecursiveQuestion {
	
	/**
	 *  an algorithm to calculate the kth 
	 *  Fibonacci number F_k using binary recursion
	 * @param k 
	 * 	how many times to go through the fibonacci 
	 * 	sequence
	 * @return
	 * 	the number at the kth point of the sequence
	 */
	public static int FibBinaryRecursive(int k) {
	   	 
		if(k == 0 || k == 1) 
	   		 return k; 
	   	 
		// recursive call
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);

	} // of FibBinaryRecursive
	
	/**
	 * an algorithm to solve the Towers of Hanoi problem
	 * @param x
	 * 	number of disks
	 * @param s
	 * 	location of the source post
	 * @param d
	 * 	location of the destination post 
	 * @param t
	 * 	location of the temporary 
	 */
	public static void HanoiTower(int x, int s, int d, int t) {
	
		if(x <= 0)
	   		 return;
	   	 
		// recursive call
		HanoiTower(x-1,s,t,d);
	   	
		System.out.println("Move disk " + x + " from post " + s + " to post " + d);
	   	
		// recursive call
		HanoiTower(x-1,t,d,s);
	    
	} // of HanoiTower
	
	/**
	 * prints and counts up and down from the 
	 * call numbers
	 * @param L
	 * 	the levels requested by the user
	 * @param curl
	 * 	the beginning number
	 * @return
	 * 	the final string that the call levels are
	 *  stored in 
	 */
	public static String showCallLevel(int L, int curl) {
	    
		String str1 = "";
	   	String str2 = "";
	   	 
	   	for(int x = 0; x < curl; x++) 
	   		str1 += "  ";
	   	 
	   	 if(L <= 0 || curl <= 0) 
	   		 return "";
	   	 
	   	 // recursive call
	   	 if(curl <= L)
	   		str2 += str1 + "This is written by call number " + curl + "x" + "\n"
	   					 + showCallLevel(L, curl+1);
	   	 
	   	 if(L >= curl) 
	   		str2 += str1 + "This is written by call number " + curl + "y" + "\n";
	   	 
	   	 return str2;
	   
	} // of showCallLevel
	
	/**
	 * this method prints the value of n as a 
	 * binary number. If n is zero, then a single 
	 * zero is printed else, no leading zeros 
	 * are printed in that output.
	 * @param n
	 * 	number to be converted into binary
	 */
	public static void BinaryPrint(int n) {
	    
		if(n < 0) 
			throw new IllegalArgumentException("No negative numbers allowed.");
	    
	    if(n == 0 || n == 1)
	    	System.out.print(n);
	    
	    if(n >= 2) {
	    	// recursive call 
	    	BinaryPrint((n/2));
	    	System.out.print(n%2);
	   	}// of if 
	
	} // of BinaryPrint
	
	/**
	 * print the pattern of asterisks and
	 * blanks using recursion 
	 * @param longestLine
	 * 	number of stars in the longest line
	 * @param indent
	 * 	indentation of the leftmost line in the pattern
	 */
	public static void Pattern(int longestLine, int indent) {
	    
		if(longestLine == 0) 
	    	return;
	    
		// recursive call 
		Pattern(longestLine/2, indent);
	    
		for(int x = 1; x < indent; x++) 
	    	System.out.print(" ");
		
		for(int x = 0; x < longestLine; x++) 
	    	System.out.print("*");
	    
		System.out.println();
	    
		// decrement recursive call
		Pattern(longestLine/2, indent + longestLine/2);
	    
	} // of pattern

	/**
	 *  a recursive method that prints the 
	 *  permutations of the integers in this array
	 * @param A
	 * 	The given integer array
	 * @param x
	 * 	the amount of integers in the array
	 */
	public static void Permutation(int A[], int x) {
	   
		if (x == 1) {
			for (int i = 0; i <A.length; i++)
	            System.out.print(A[i] + " ");
			
	        System.out.println();
		} // of if 
	        
	    for(int i = 0; i < x; i++){
	    	
	    	// recursive call 
	    	Permutation(A, x - 1);
	    	 
	    	if (x % 2 == 1) {
	    		int temp = A[0];
	    		A[0] = A[x - 1];
	    		A[x - 1] = temp;
	    	} // of if 
	    	
	    	else {
	    		int temp = A[i];
	    		A[i] = A[x - 1];
	    		A[x - 1] = temp;
	        }// of else 

	    } // of for 
		
	} // of permutation 
	
	public static void main(String args[]) {
	
		// test fibonacci sequence 
		System.out.println("Fibonacci number for 0: " + FibBinaryRecursive(0));
		System.out.println("Fibonacci number for 2: " + FibBinaryRecursive(2));
		System.out.println("Fibonacci number for 8: " + FibBinaryRecursive(8));
		System.out.println("Fibonacci number for 15: " + FibBinaryRecursive(15));
		
		// test towers of hanoi 
		System.out.println("\nMoves four disks with s = 0, d = 2, and t = 1");
		HanoiTower(4, 0, 2, 1);
		System.out.println("\nMoves two disks with s = 1, d = 2, and t = 0");
		HanoiTower(2, 1, 2, 0);
		
		// test show call level
		System.out.print("\nCall level with 4 and 1 \n" + showCallLevel(4, 1));
		System.out.print("\nCall level with 8 and 2\n" + showCallLevel(8, 2));
		
		// test binary print
		System.out.print("\n0 in binary is: ");
		BinaryPrint(0);
		System.out.print("\n4 in binary is: ");
		BinaryPrint(4);
		System.out.print("\n27 in binary is: ");
		BinaryPrint(27);
		
		// test pattern
		System.out.println("\n\nThe pattern with 8 and 2");
		Pattern(8, 2);
		System.out.println("The pattern with 4 and 2");
		Pattern(4, 2);
		
		// test permutation
		System.out.println("\nThe permutations for 1, 2, 5, and 10 are: ");
		int[] arr = {1, 2, 5, 10};
		Permutation(arr, 4);
		System.out.println("\nThe permutations for 22, 61, 49, and 32 are: ");
		int[] arr2 = {22, 61, 49, 32};
		Permutation(arr2, 4);
		
	
	}// of main 

} // of class
