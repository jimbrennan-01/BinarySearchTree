package tree;

public class BinarySearchTree {
	Node root;
	int numLeaves;
	int height;
	
	public BinarySearchTree() {
		this.root=null;
		this.numLeaves = 0;
		this.height = 0;
	}
	
	//****** INSERT ***************************
	public void insert(int key) {
		this.root = insert(root,key);
	}

	private Node insert(Node current, int key) {
		if(current==null) {
			current = new Node(key);
			return current;
		}
		if(key<current.key) {
			current.left = insert(current.left,key);
		}else {
			if(key > current.key) {
				current.right = insert(current.right,key);	
			}
		}
		return current;
	}
	
	//****** SEARCH ***************************
	public Node search(int key) {
		Node node = search(this.root, key);
		return node;
	}
	
	private Node search(Node current, int key){
		while(current.left != null && current.right != null) {
			if(current.key == key) {
				return current;
			}else if(current.key > key) {
				current = current.left;
			}else if(current.key < key) {
				current = current.right;
			}
		}
		return current;
	}
	
	//****** DELETE ***************************
	public void delete(int key) {
		this.root = delete(this.root,key);
	}
	
	private Node delete(Node current, int key){
		if(current != null) {
			if(current.left.key == key && current.left.right == null && current.left.left == null) {
				current.left = null;
			}
			if(current.right.key == key && current.right.right == null && current.right.left == null) {
				current.right = null;
			}
			if(current.key > key) {
				return delete(current.left, key);
			}else if(current.key < key) {
				return delete(current.left, key);
			}
			
		}
		return null;
	}
	
	
	//****** Find Minimum Key Value ***************************
	public int findMin(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node.key;
	}
	
	//****** Height (Count in Nodes) ***************************
	public int height(Node root) {
		if(root != null) {
			height(root.left);
			height(root.right);
			if(root.left != null && root.right != null) {
				if(root.left.key < root.key || root.right.key > root.key) {
					this.height++;
				}
			}
		}
		
    	return this.height;
    }
    
    //****** Count Leaves ***************************
	public int countLeaves(Node root) {
		if(root!=null) {
			countLeaves(root.left);
			countLeaves(root.right);
			
			if(root.left == null && root.right == null) {
				this.numLeaves++;
			}
		}
		return this.numLeaves;
	}
	
	//****** isValidBST ***************************
	public boolean isValidBST(Node root) {
		if(root != null) {
			isValidBST(root.left);
			isValidBST(root.right);
			if(root.left != null && root.right != null) {
				if(root.left.key > root.key || root.right.key < root.key) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public void inOrderTraversal(Node root) {
		// Left-Root-Right
		if(root!=null) {
			inOrderTraversal(root.left);
			System.out.printf(" %d ", root.key);
			inOrderTraversal(root.right);
		}
	}
	
	public void preOrderTraversal(Node root) {
		// Root-Left-Right
		if(root!=null) {
			System.out.printf(" %d ", root.key);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public void postOrderTraversal(Node root) {
		// Left-Right-Root
		if(root!=null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.printf(" %d ", root.key);
		}
	}
	
	

}