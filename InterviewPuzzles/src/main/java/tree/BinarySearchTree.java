package tree;

public class BinarySearchTree {

	Node root;
	
	public BinarySearchTree(int []array){
		for(int i : array){
			Node node = insert(root , i);
			if(root == null){
				root = node;
			}
		}
	}
	
	public Node insert(Node<Integer> head , int data){
		if(head == null){
			return new Node(data);
		}
		
		if(head.data < data){
			head.right = insert(head.right , data);
		}else{
			head.left = insert(head.left , data);
		}
		return head;
	}
	
	public boolean search(Node<Integer> root , int data){
		if(root == null){
			return false;
		}
		if(root.data == data){
			return true;
		}
		
		if(root.data < data){
			return search(root.right , data);
		}
		return search(root.left , data);
	}
	public void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	public int minValue(Node<Integer> root){
		if(root == null){
			return -1;
		}
		if(root.left == null){
			return root.data;
		}
		return minValue(root.left);
		
	}
	
	private static boolean flag = false;
	public static int inorderSuccessor(Node<Integer> root , int target){
		if(root == null){
			return -1;
		}

		int value = inorderSuccessor(root.left , target );
		if(value != -1){
			return value;
		}
		if(flag){
			return root.data;
		}
		
		if(root.data == target){
			flag = true;
			
		}
		return inorderSuccessor(root.right , target );
		
	}
	public static void main(String[] args) {
		int []array = {10,5,15,6,20,1};
		BinarySearchTree tree = new BinarySearchTree(array);
//		tree.inorder(tree.root);
		
//		System.out.println(tree.search(tree.root , 10));
//		System.out.println(tree.search(tree.root , 100));
//		
//		System.out.println(tree.minValue(tree.root));
		System.out.println(tree.inorderSuccessor(tree.root , 20));
	}
}
