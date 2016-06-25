package com.wgcris.LeetcodeAlgorithm;
/*
 * 110 平衡二叉树
 */
public class BalanceBinaryTree {

	/**
	 * 平衡二叉树 思路：递归 
	 * @param root
	 * @return
	 */
	public static boolean isBalance(TreeNode root){
		 if(root==null) return true;
         int left=getHeightOfTree(root.left);
         int right=getHeightOfTree(root.right);
         return  left!=-1 && right!=-1 && Math.abs(left-right)<=1;
	 }
	
	
	//树的高度 
	public static int getHeightOfTree(TreeNode root){
		if(root==null) return 0;
		int left=getHeightOfTree(root.left);	
		int right=getHeightOfTree(root.right);		
		if(left==-1 || right==-1||Math.abs(left-right)>1) return -1;
		
		return Math.max(left,right)+1;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
