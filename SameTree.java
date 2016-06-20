package com.wgcris.LeetcodeAlgorithm;
/*
 * 验证两个二叉树是否相等
 */
public class SameTree {

	public boolean isSameTree(BinaryTreeNode root1,BinaryTreeNode root2){
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.data==root2.data)
			return isSameTree(root1.left,root2.left)&&isSameTree(root1.right,root2.right);
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class BinaryTreeNode{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
}