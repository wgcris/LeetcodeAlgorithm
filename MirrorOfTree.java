package com.wgcris.LeetcodeAlgorithm;

public class MirrorOfTree {

	public void invertTree(TreeNode root){
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
			return;
		//½»»»
		TreeNode temp=root.left;
		root.left=root.right;
		root.left=temp;
		if(root.left!=null)
			invertTree(root.left);
		if(root.right!=null)
			invertTree(root.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
