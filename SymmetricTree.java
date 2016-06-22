package com.wg.leetcode;

/*
 * 101：判断一个二叉树是对称树
 *  1
   / \
  2   2
 / \ / \
3  4 4  3
 */

public class SymmetricTree {
     /**
      * 判断一个二叉树是对称二叉树
      * 思路：递归,这里需要辅助函数，分别判断左子数和右子数之间是否对称
      * @param root
      * @return
      */
	public static boolean  isSymmetric(TreeNode root){

		return root==null?true:isSymmetric(root.left,root.right);
	}
	/**
	 * 辅助函数：用于判断左子数和右子数是否对称
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean isSymmetric(TreeNode left,TreeNode right){
		if(left==null&&right==null)return true;
		if(left==null||right==null) return false;
		if(left.val!=right.val)return false;
		
		return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
	}
}
