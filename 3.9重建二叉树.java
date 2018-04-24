/*
using preorder and inorder results to rebuild a tree
*/

class Node{
	char value;
	Node left;
	Node right;
}

public static Node reBuild(char[] preOrder, char[] inOrder, int treeLen) {
	return reBuild(preOrder, inOrder, 0, 0, treeLen);
}

private static Node reBuild(char[] preOrder, char[] inOrder, int startPreOrder, int startInOrder, int treeLen) {

	// Boundary
	if (startPreOrder >= preOrder.length || startInOrder >= inOrder.length) {
		return null;
	}

	Node root = new Node();
	root.value = preOrder[startPreOrder];
	root.left = null;
	root.right = null;

	// Only one node
	if (treeLen == 1) {
		return root;
	}

	// Find left tree end index (excluded)
	int endLeftTree = startInOrder;
	while (inOrder[endLeftTree] != preOrder[startPreOrder]) {
		if (endLeftTree >= inOrder.length) {
			return root;
		}

		// avoiding IndexOutOfBoundsException
		if (endLeftTree == inOrder.length - 1) {
			break;
		}

		endLeftTree++;
	}

	int leftTreeLen = endLeftTree - startInOrder;

	int rightTreeLen = treeLen - leftTreeLen - 1;

	if (leftTreeLen > 0) {
		root.left = reBuild(preOrder, inOrder, startPreOrder + 1, startInOrder, leftTreeLen);
	}

	if (rightTreeLen > 0) {
		root.right = reBuild(preOrder, inOrder, startPreOrder + 1 + leftTreeLen, startInOrder + 1 + leftTreeLen,
				rightTreeLen);
	}

	return root;
}

// test
public static void main(String[] args) {
	char[] preOrder = { 'a', 'b', 'd', 'c', 'e', 'f' };
	char[] inOrder = { 'd', 'b', 'a', 'e', 'c', 'f' };
	int treeLen = preOrder.length;
	Node root = reBuild(preOrder, inOrder, treeLen);
	printNodeByLevel(root);
}