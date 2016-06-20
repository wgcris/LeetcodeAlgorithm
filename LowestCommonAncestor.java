package com.wgcris.LeetcodeAlgorithm;
/*
 * 找到最小的共同祖先。
 */
public class LowestCommonAncestor {

	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	public static TreeNode lowetCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
		while ((root.val - p.val) * (root.val - q.val) > 0)
	        root = p.val < root.val ? root.left : root.right;
	    return root;
	}
	
	public static TreeNode lowetCommonAncestor_(TreeNode root, TreeNode p,TreeNode q){
		while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


