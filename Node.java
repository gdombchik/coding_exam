//used by ProblemFour
public class Node {
	Node left;
	Node middle;
	Node right;
	Node parent;
	int value;
	
	public Node(int value){
		this.value = value;
	}
	
	public void insert(Node node, int value) {
		if (value < node.value) { //left node being value < parent
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println(" Inserted " + value + " to left of " + node.value);
				node.left = new Node(value);
				node.left.parent = node;
			}
		} else if (value > node.value) { //right node being value > parent
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println(" Inserted " + value + " to right of " + node.value);
				node.right = new Node(value);
				node.right.parent = node;
			}
		} else if (value == node.value){ //middle node being value == parent
			if (node.middle != null){
				insert(node.middle,value);
			}else {
				System.out.println(" Inserted " + value + " to middle of " + node.value);
				node.middle = new Node(value);
				node.middle.parent = node;
			}
		}
	}
}
