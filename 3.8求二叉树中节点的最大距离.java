/*
 把二叉树看成一个图，父节点之间的连线看成是双向的，
 姑且定义“距离”为两个节点之间边的个数。
 
 求一颗二叉树中相距最远的两个节点之间的距离。
 
 解：
 记以节点ni为根的二叉树中相距最远的两个节点之间的距离为di。
 
 1.若相距最远的两个节点的路径经过根节点n0：
 显然这两个节点应该属于根节点的两个不同子树，设子树的深度分别为max1和max2，则它们的距离为d0 = max1 + max2 + 2。
 
 2.若相距最远的两个节点的路径不经过根节点n0：
 这两个节点显然属于根节点的子树n1或n2，即求d1和d2的最大值。
 
 3.最终该d0 = max{max1+max2+2，d1，d2}
 
 4.d1和d2同样可以用（3）式递归。
*/

class Node{
	Node left;
	Node right;
	int nMaxLeft;	//到左子树节点最远距离
	int nMaxRiht;	//到右子树节点最远距离
	char chValue;
}

int nMaxLen = 0;

void finMaxLen(Node root){
	if(root == null){
		return;
	}
	
	// 左子树不为空时，递归左子树
	// 为空时，到左子树节点最远距离为0
	if(root.left == null){
		root.nMaxLeft = 0;
	} else{
		finMaxLen(root.left);
	}
	
	// 右子树不为空时，递归右子树
	// 为空时，到右子树节点最远距离为0
	if(root.right == null){
		root.nMaxRiht = 0;
	} else{
		finMaxLen(root.right);
	}
	
	// 计算到左子树节点最远距离
	if(root.left != null){
		int max1 = 0;
		if(root.left.nMaxLeft > root.left.nMaxRiht)
			max1 = root.left.nMaxLeft;
		else
			max1 = root.left.nMaxRiht;
		root.nMaxLeft = max1 + 1;
	}

	// 计算到右子树节点最远距离
	if(root.right != null){
		int max2 = 0;
		if(root.right.nMaxLeft > root.right.nMaxRiht)
			max2 = root.right.nMaxLeft;
		else
			max2 = root.right.nMaxRiht;
		root.nMaxRiht = max2 + 1;
	}
	
	// 更新最长距离
	if(root.nMaxLeft + root.nMaxRiht > nMaxLen){
		nMaxLen = root.nMaxLeft + root.nMaxRiht;
	}
}
