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

/**
 * Tree Node for AVL tree
 * 
 * @author Huiping Cao
 *
 */
class AVLNode{
	private int data; 	//the element value for this node
	private AVL left;	//the left child of this node
	private AVL right;	//the right child of this node
	private int height; //height of the tree rooted at this node 
		
	public AVLNode()				{	data = 0; left = new AVL(); right = new AVL(); height = 0;}
	public AVLNode(int initData)	{	data = initData; left = new AVL();	right = new AVL();	height = 0;}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public AVLNode(int initData, AVL initLeft, AVL initRight){
		data = initData;
		left = initLeft;
		right = initRight;
		height = 1;
	}

	
	
	public int getData()	{ return data; }
	public AVL getLeft() 	{ return left; }
	public AVL getRight() 	{ return right; }
	public int getHeight()	{ return height;}
	public void setData(int data)	{this.data = data;}
	public void setLeft(AVL left)	{ this.left = left;}
	public void setRight(AVL right)	{ this.right = right;}

	/**
	 * Set the height of the tree rooted at this node
	 */
	public void setHeight()
	{
		this.height = 1+Math.max(getLeftHeight(), getRightHeight());
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		if(left==null) str +="(null)";
		else str +="("+left.getRoot().getData()+")";
		
		str += data;
		
		if(right==null) str +="(null)";
		else str +="("+right.getRoot().getData()+")";
		
		return str;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	//Rebalancing related methods
	
	/**
	 * Get the height of the left subtree
	 */
	public int getLeftHeight(){
		if(left==null||left.getRoot()==null) 	return 0;
		else return left.getRoot().getHeight();
	}
	
	/**
	 * Get the height of the right subtree
	 * @return: the height of the right sub-tree
	 */
	public int getRightHeight(){
		if(right==null||right.getRoot()==null) 	return 0;
		else return right.getRoot().getHeight();
	}
	
}


