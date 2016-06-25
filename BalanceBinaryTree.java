package com.wgcris.LeetcodeAlgorithm;
/*
 * 110 ƽ�������
 */
public class BalanceBinaryTree {

	/**
	 * ƽ������� ˼·���ݹ� 
	 * @param root
	 * @return
	 */
	public static boolean isBalance(TreeNode root){
		 if(root==null) return true;
         int left=getHeightOfTree(root.left);
         int right=getHeightOfTree(root.right);
         return  left!=-1 && right!=-1 && Math.abs(left-right)<=1;
	 }
	
	
	//���ĸ߶� 
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
