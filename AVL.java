/**
* Lab12: AVL Tree
* Assigned by Professor Huiping Cao
* Implement and test recursive algorithms
*@author 
* Huiping Cao / Xiana Lara
*@version
* April 19, 2019
**/

package lab12;

import java.util.Stack;

public class AVL {
	private AVLNode	root; //instance variable to denote the root of the AVL tree
	
	//Constructors for the AVL tree
	public AVL()		{root = null;}
	public AVL(int e)	{root = new AVLNode(e,new AVL(),new AVL());}
	
	//Basic set and get methods
	public AVLNode getRoot() 			{return root;}
	public void setRoot(AVLNode _root) 	{this.root = _root;}
	public boolean isEmpty()			{return (root==null);}
	
	private AVL getLeftSubtree()	{ return root.getLeft();	}
	private AVL getRightSubtree()	{ return root.getRight();	}
	private void setHeight()		{root.setHeight(); }
	
	/**
	 * Check whether the tree (rooted at this node) is right heavy or not
	 * @return
	 */
	private boolean rightHeavy(){
		return (root.getLeftHeight() < root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is left heavy or not
	 * @param node
	 * @return
	 */
	private boolean leftHeavy(){
		return (root.getLeftHeight() > root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is right too heavy or not
	 * @return
	 */
	private boolean rightTooHeavy(){
		return ((root.getLeftHeight()+1)< root.getRightHeight());
	}
	
	/**
	 * Check whether the tree (rooted at this node) is left too heavy or not
	 * @param node
	 * @return
	 */
	private boolean leftTooHeavy(){
		return (root.getLeftHeight() > (root.getRightHeight()+1));
	}
	
	
	/**
	 * Traversal the tree in-order and print it
	 */
	public void inOrderTraversal(){
		inOrderTraversal(0);
	}
	
	/**
	 * Private function to print the tree with in-order traversal
	 * @param indentation: the number of space before the data, to make the printing more beautiful
	 */
	private void inOrderTraversal(int indentation){
		if(root!=null){
			if(root.getRight()!=null)root.getRight().inOrderTraversal(indentation+1);
			for(int i=0;i<indentation*2;i++)
				System.out.print(" ");
			System.out.println(root.getData());
			if(root.getLeft()!=null)root.getLeft().inOrderTraversal(indentation+1);
		}
	}
	
	public String inOrderStr()
	{
		if(root!=null)
			return  (root.getLeft().inOrderStr() + " " + root.getData() + " " + root.getRight().inOrderStr());
		else
			return "";
	}

	/**
	 * Print the tree using pre-order 
	 * traversal strategy. You MUST 
	 * implement this method non-recursively.
	 */
	public void preOrderPrtRecursive(){
		if(root==null) return;
		
		System.out.print(root.getData()+" ");
		this.getLeftSubtree().preOrderPrtRecursive();
		this.getRightSubtree().preOrderPrtRecursive();
	}
	
	/**
	 * Insert a new element e into the binary search tree. 
	 * @param e - new element
	 * @return - boolean value depending on whether the value 
	 * was already in the tree
	 */
	public boolean insert(int e) {
		
		if(root == null) {
			root = new AVLNode(e, new AVL(), new AVL());
			return true;
		} // of if
		
		//if(e == root.getData())
			//return false;
		
		if( e <= root.getData()) {
			this.getLeftSubtree().insert(e);
		} // of of 
		else if( e > root.getData()) {
			this.getRightSubtree().insert(e);
		} // of else 
		
		return false;

	} // of insert
	
	/**
	 * Remove a specified element from the binary search tree. 
	 * When e exists in the tree and one instance is successfully 
	 * removed, return true; Otherwise, return false. 
	 * @param e - element to be removed
	 * @return - boolean value depending on whether the value 
	 * was present and removed 
	 */
	public boolean remove(int e) {
		
		if(root == null)
			return false;
		
		if(e == root.getData()) {
			
			if(getLeftSubtree().root == null && getRightSubtree().root == null) {
				root = null;
				return true;
			} // of if 
			else if(getLeftSubtree().root == null && getRightSubtree().root != null) {
				root = getRightSubtree().root;
				return true;
			} // of else if
			else if(getLeftSubtree().root != null && getRightSubtree().root == null) {
				root = getLeftSubtree().root;
				return true;
			} // of else if 
			else if(getLeftSubtree().root != null && getRightSubtree().root != null) {
				int maxDataleft = getLeftSubtree().removeMax();
				root.setData(maxDataleft);
				return true; 
			} // of else if 
		
		} // of if 
			
		if( e < root.getData()) {
			return getLeftSubtree().remove(e);
		}// of if 
		else {
			return getRightSubtree().remove(e);
		} // of else 
			
	} // of remove 
	
	/**
	 * moves some tree elements around when a max is removed 
	 * so that the tree is still valid
	 * @return - tree element 
	 */
	public int removeMax() {
		
		AVLNode RT = getRightSubtree().root;
		int MaxData;
		
		if(RT == null) {
			MaxData = root.getData();
			root = getLeftSubtree().root;
		} // of if 
		else {
			return getRightSubtree().removeMax();
		} // of else 
		
		return MaxData;
		
	} // of removeMax
	
	 /**
     * Print the tree using pre-order traversal non-recursively
     */
     
   public void preOrderPrtNonRecursive(){
	   
	   Stack<AVLNode> temp = new Stack<AVLNode>();
      
	   while(true){
		   
		   while(root != null){
			   
			   System.out.print(root.getData() + " ");
			   temp.push(root);
			   root = getLeftSubtree().root;
			   
		   } // of while 
         
		   if(temp.isEmpty())
			   return;
		   
		   root = temp.pop();
		   root = getRightSubtree().root;
       
	   } // of while
   
   } // of preOrderPrtNonRecursive

   /**
    * Find the number of times that a given
    * element e exists in the tree.
    * @param e - Given number to remove 
    * @return the amount of times it occurs 
    */
   public int countOccurrences (int e) {
	   
	   int occurs = 0; 
	   
	   while(remove(e) != false)
		   occurs++;
		   
	   
	   return occurs; 
   
   }// of countOccurrences
   
} // of class 