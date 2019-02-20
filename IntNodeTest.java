package IntNode;

public class IntNodeTest {

	public static void main(String args[]) {
		
		// creating a new IntNode
		IntNode node1 = new IntNode(); 
		// setting data 
		node1.setData(4);
		// setting link
		node1.setLink(null);
		// data at node1
		System.out.println(node1.getData()); 
		
		// adding new nodes
		node1.addNodeAfterThis(23);
		node1.link.addNodeAfterThis(55);
		
		// printing node link
		System.out.println(node1.getLink());
		
		// adding new nodes
		node1.addNodeAfterThis(15);
		node1.link.link.addNodeAfterThis(44);
			
		
		// all of the nodes with toString
		System.out.println(node1.toString()); 
		
		// removing one node
		node1.removeNodeAfterThis();
		
		// nodes after removing 
		System.out.println(node1.toString()); 
		
		// test search 
		System.out.println(IntNode.search(node1, 55));
		System.out.println(IntNode.search(node1, 100));
		
		System.out.println();
		
		// new node 
		IntNode node2 = new IntNode(); 
		node2 = new IntNode(12, node1.link); 
		node2.setData(3);

		// getting data and link
		System.out.println(node2.getData()); 
		System.out.println(node2.getLink());
		
		// add a new node
		node2.addNodeAfterThis(32);
		
		// remove node
		node2.link.link.removeNodeAfterThis();
		
		// nodes after adding and removing 
		System.out.println(node2.toString());
		
		// listLength test)
		System.out.println(IntNode.listLength(node1));
					
		
	} // of main 

	
} // of class
