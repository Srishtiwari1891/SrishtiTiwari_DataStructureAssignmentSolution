package com.greatlearning.dsa.assignment.bst.skewedlogic;

public class PrepareSkewedBST {
	
	Node root;
	Node prevNode=null;
	Node headNode=null;

	//Insert node in the BST
		public void insertNode(int key) {
			root=insertRec(this.root,key);
		}
	
	public Node insertRec(Node root, int key) {
		// check for empty BST and add new Node
		if (root==null) {
			root = new Node(key);
			//root.data = key;
			return root;
		}

		// if non-empty BST, add Node
		if (key < root.data)
			root.left = insertRec(root.left, key);
		else
			root.right = insertRec(root.right, key);

		// return Node in the end
		return root;
	}
	
	public void createSkewedTree() {
		skewedTreeIncreasingOrder(this.root);
		System.out.println("\n **Right Skewed Binary Search Tree:");
		printSkewedTree(this.headNode);
	}
	
	public void skewedTreeIncreasingOrder(Node root) {
		if(root==null) 
			return;
		skewedTreeIncreasingOrder(root.right);
		Node leftNode = root.left;
		if(headNode==null) {
			this.headNode=root;
			root.left=null;
			prevNode=root;
		}
		else {
			prevNode.right=root;
			root.left=null;
			prevNode=root;
		}
		skewedTreeIncreasingOrder(leftNode);
	}
	
	public void printSkewedTree(Node headNode) {
		if(headNode==null)
			return;
		System.out.println(headNode.data+" ");
		printSkewedTree(headNode.right);
	}
}

class Node {

	int data;
	Node left, right, root;

	// Initialize Node for BST
	Node(int d) {
		this.data = d;
		this.left = this.right = null;
	}

}
