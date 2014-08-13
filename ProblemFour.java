public class ProblemFour {
	
	public static void main(String[] args) {
		Node root = new Node(5); //root is 5
		
		System.out.println("Building tree with root value " + root.value);		
		root.insert(root, 5);
		root.insert(root, 4);
		root.insert(root, 9);
		root.insert(root, 5);
		root.insert(root, 7);
		root.insert(root, 2);
		root.insert(root, 2);
		System.out.println("Inserted 5, 4, 9, 5, 7, 2, 2.");
	}
}
