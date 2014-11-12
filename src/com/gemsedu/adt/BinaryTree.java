package com.gemsedu.adt;
import java.util.Random;

/**
 * A generic BinaryTree class
 * @author k.hogg_wso
 * @param <T> the type of the nodes in the tree
 */
public class BinaryTree<R> {
	static BinaryNode<?> root = null;
	
	BinaryTree() {}
	
	public static void main(String[] args) {
		// Creates new Binary Tree of Integers
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		
		// Creates ten random numbers and adds to the tree
		Random randomGenerator = new Random();
	    for (int i = 1; i <= 10; i++){
			Integer randomInt = randomGenerator.nextInt(10);
			BinaryNode<Integer> bNode = new BinaryNode<Integer>(randomInt);
			bTree.insert(root, bNode);
	    }
	    
	    // Prints the binary tree
	    display(root);
	    System.out.println(bTree.search(root, new BinaryNode<Integer>(1)));
	}
	
	/**
	 * Checks is the bTree is empty or not
	 * @return boolean whether or not the bTree is empty
	 */
	boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * Inserts a bNode into the bTree
	 * @param currentNode the current node to add the newnode relative to
	 * @param newNode the new node to be added to the tree
	 */
	void insert(BinaryNode currentNode, BinaryNode newNode) {
		// if there isn't a tree yet, set root to the new node
		if (isEmpty()) {
			root = newNode;
		}
		else {
			// if current is greater than the new data
			if (currentNode.data.compareTo(newNode.data) == 1) {
				// if there's isn't a left node, set newNode to be it
				if (currentNode.left == null) {
					currentNode.left = newNode;
				}
				else {
					// if there is a left node, recurse again using the left node
					insert(currentNode.left, newNode);
				}
			}
			// if current is less than the new data TODO: if it's the same
			else {
				// if there isn't a left node, set newNode to be it
				if (currentNode.right == null) {
					currentNode.right = newNode;
				}
				else {
					// if there is a right node, recurse again using the left node
					insert(currentNode.right, newNode);
				}
			}
		}
	}
	// This could be smarter as we don't need to get to a null leaf to know its
	// not in the tree
	boolean search(BinaryNode<?> root, BinaryNode<?> search) {
		// if the tree (or current branch) is empty, return false
		if (isEmpty() || root == null) {
			return false;
		}
		// if the search node is the same as the root node
		else if (root.data.equals(search.data)) {
			return true;
		}
		// not the root node
		else {
			if (search.data.compareTo(root.data) == 1) {
				return search(root.right, search);
			}
			else {
				return search(root.left, search);
			}
		}
	}
	
	static void display(BinaryNode<?> root){
	    BinaryTreePrinter.printBinaryNode(root);
	}
	
}
