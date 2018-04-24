class Node{
	int data;
	Node left;
	Node right;
}

// 0.print from level 0 to last level
void printNodeByLevel(Node root){
	for(int level = 0; ;level++){
		if(printNodeAtLevel(root, level) == 0)
			break;
		System.out.println();
	}
}

// 1.print all the data at a level
int printNodeAtLevel(Node root, int level){
	if(root == null || level < 0){
		return 0;
	}
	if(level == 0){
		System.out.print(root.data + " ");
		return 1;
	}
		return printNodeAtLevel(root.left, level - 1) + printNodeAtLevel(root.right, level - 1);
}

/****************** A better method, but use N space *****************/
void printNodeByLevel(Node root){
	if(root == null)
		return;
	List<Node> list = new ArrayList();
	list.add(root);
	int cur = 0,last;
	while(cur < list.size()){
		last = list.size();
		while(cur < last){
			System.out.print(list[cur].data + " ");
			if(list[cur].left != null){
				list.add[list[cur].left);
			}
			if(list[cur].right != null){
				list.add[list[cur].right;
			}
			cur++;
		}
		System.out.println();
	}
}

/***************** using queue *****************/
void printNodeByLevel(Node root){
	if(root == null)
		return;
	
	Queue<Node> queue = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            int size = list.size();
            while(size -- > 0) {
                root = list.remove();
                System.out.print(root.data + " ");
                if (root.left != null)
                    list.add(root.left);
                if (root.right != null)
                    list.add(root.right);
            }
            System.out.println();
        }
}

