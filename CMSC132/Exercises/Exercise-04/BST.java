public class BST {
	private class Node {
		private int data;
		private Node left, right;

		public Node(int data) {
			this.data= data;
			this.left= this.right= null;
		}
	}

	private Node root;

	public boolean insert(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		} else
			return insertAux(value, root);
	}

	public boolean insertAux(int value, Node root) {
		if (value == root.data)
			return false;
		else
			if (value < root.data) {
				if (root.left == null) {
					root.left = new Node(value);
					return true;
				} else
					return insertAux(value, root.left);
			} else
				if (value > root.data) {
					if (root.right == null) {
						root.right = new Node(value);
						return true;
					} else 
						return insertAux(value, root.right);
				}
				
		return false;
	}  

	private String toString(Node travel) {
		String result= "", left, right;

		if (travel != null) {
			left= toString(travel.left);
			right= toString(travel.right);
			result += left + (left.equals("") ? "" : " ") + travel.data + (right.equals("") ? "" : " ") + right;
		}
		
		return result;
	}

	public String toString() {
		return toString(root);
	}
}