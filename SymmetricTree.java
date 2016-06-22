package com.wg.leetcode;

/*
 * 101���ж�һ���������ǶԳ���
 *  1
   / \
  2   2
 / \ / \
3  4 4  3
 */

public class SymmetricTree {
     /**
      * �ж�һ���������ǶԳƶ�����
      * ˼·���ݹ�,������Ҫ�����������ֱ��ж���������������֮���Ƿ�Գ�
      * @param root
      * @return
      */
	public static boolean  isSymmetric(TreeNode root){

		return root==null?true:isSymmetric(root.left,root.right);
	}
	/**
	 * ���������������ж����������������Ƿ�Գ�
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
