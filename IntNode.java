/**
	* Lab3: IntNode 
	* Assigned by Professor Huiping Cao
	* Design integer nodes to be aligned in order
	* of heads and tails
	*@author 
	* Xiana Lara
	*@version
	* February 12, 2019
**/

package IntNode;

public class IntNode {
	
	// Instance Variables
	// 1. data represents the value of the IntNode
	// 2. link represents the next IntNode
	
	private int data;
	IntNode link; 
	
/**
	 * Initialize a new node with data 0 
	 * and link null. 
	 * @param - none
	 * @postcondition
	 * 	Sets data to 0 and link to null
**/
	
	public IntNode() {
		
		data = 0;
		link = null; 
		
	} // of IntNode constructor
	
/**
	 * Initialize a new node with the given variables
	 * @param - _data 
	 * 	the initial data for this IntNode
	 * @param - _node
	 *  the initial IntNode for this node
	 * @postcondition
	 * 	sets data and link to the given parameters
**/
	
	public IntNode(int _data, IntNode _node) {
		
		data = _data;
		link = _node;
		
	} // of IntNode argument constructor
	
/**
	 * Accessor to return data
	 * @return - data
**/
	
	public int getData() {
		
		return data;
		
	} // of getData
	
/**
	 * Accessor to return link
	 * @return - link
**/
	public IntNode getLink() {
		
		return link; 
		
	} // of getLink
	
/**
	 * Mutator to set data
	 * @param - _newData
	 *  the given data
	 * @precondition
	 *  current data
	 * @postcondtion
	 *  data is equal to _newData
**/
	public void setData(int _newData) {
		
		data = _newData; 
		
	} // of setData
	
/**
	 * Mutator to set Link
	 * @param - _newLink
	 *  the given link
	 * @precondition
	 *  current link
	 * @postcondtion
	 *  link is equal to _newLink
**/
	public void setLink(IntNode _newLink) {
		
		link = _newLink; 
		
	} // of setLink
	
/**
 	* Checks how many nodes are present
 	* @param head
 	*  first node is node set
 	* @return - answer
 	*  answer is the amount of nodes
**/
	public static int listLength(IntNode head){
		
		int answer = 0; 
		for(IntNode cursor = head; cursor != null; cursor = cursor.link){
			answer++;
		} // of for 
		return answer;
		
	} // of listLength

/**
 	* toString shows all nodes together 
 	* @param - none 
 	* @returns - list 
 	*  a list of all of the nodes with arrows in 
 	*  between them
**/
	public String toString() {
		
		IntNode cursor;
		
		String list = "";
		//+ cursor.data; 
		//if(cursor != null)
		//	cursor = cursor.link;
		
		for(cursor = link; cursor != null; cursor = cursor.link){
			list = list + cursor.data;
			if(cursor.link != null)
				list = list + "->";
		} // of for 
		return list; 
		
	} // of toString
	
/**
 	* Adds new node after the previous one with the
 	* newdata as its data
 	* @param - newdata
 	* 	given data for new node
 	* @postcondition
 	* 	a new node has been added
**/
	public void addNodeAfterThis(int newdata) {
		
		link = new IntNode(newdata, link); 
		
	} // of addNodeAfterThis
	
/**
 	* Checks through all nodes for the data
 	* @param - head
 	* 	to find the beginning of the nodes
 	* @param - data
 	* 	the data is being searched for 
 	* @return true or false 
 	* 	depends on whether element was found
**/
	public static boolean search(IntNode head, int data) {
		
		for(IntNode cursor = head; cursor != null; cursor = cursor.link){
			if(cursor.data == data)
				return true; 
		} // of for 
		return false; 
		
	} // of search
	
/**
 	* to take a node out of the node set
 	* @precondition
 	* 	there is the existing amount of nodes
 	* @postcondition
 	* 	there is one less node than there was previously 
**/
	public void removeNodeAfterThis() {
		
		link = link.link; 
		
	} // of removeNodeAfterThis
} // of class
