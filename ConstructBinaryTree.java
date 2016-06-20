package com.wgcris.LeetcodeAlgorithm;

public class ConstructBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		
		int startPreorder = 0;
		int endPreorder = preorder.length-1;
		int startInorder = 0;
		int endInorder = inorder.length-1;
		
		Node root=construct(preorder, inorder, startPreorder, endPreorder, startInorder, endInorder);
		System.out.println(root.data);
	}

	private static Node construct(int[] preorder, int[] inorder,
			int startPreorder, int endPreorder, int startInorder, int endInorder) {
		// TODO Auto-generated method stub
		Node root = new Node();
		root.data = preorder[startPreorder];
		if(startPreorder == endPreorder) {
			System.out.println(root.data);
			return root;
		}
		int rootInorder = startInorder;		
		int rootValue = preorder[startPreorder];
		//找到 root在inorder中的位置
		while (rootInorder <= endInorder && inorder[rootInorder] != rootValue) {
			rootInorder++;
		}
		int leftPreorderEnd = startPreorder + (rootInorder-startInorder);
		if (rootInorder-startInorder>0) {//当有左子树的时候，构造左子树
			root.left = construct(preorder, inorder, startPreorder + 1, leftPreorderEnd, startInorder, rootInorder-1);
		}
		if (rootInorder-startInorder<endPreorder-startPreorder) {//当有右子树的时候，构造右子树
			root.right = construct(preorder, inorder, leftPreorderEnd+1, endPreorder, rootInorder+1, endInorder);
		}
		System.out.print(root.data+" ");
		return root;
	}
}
	class Node
	{
		int data;
		Node left;
		Node right;
	}

