package com.wgcris.LeetcodeAlgorithm;



/*
 * 找到树的最大深度
 */
public class MaxDepthOfTree {

	public static int maxDepth(TreeNode root){
		 return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1=new TreeNode();
		TreeNode node1=new TreeNode();
		TreeNode node2=new TreeNode();
		TreeNode node3=new TreeNode();
		TreeNode node4=new TreeNode();
	
		root1.left=node1;
		root1.right=node2;
		node1.left=node3;
		node1.right=node4;
		
		root1.data=10;
		node1.data=5;
		node2.data=12;
		node3.data=4;
		node4.data=7;
	 System.out.println(maxDepth(root1));
	}

}
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
}