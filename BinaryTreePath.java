package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.List;



/*
 * 257 二叉树的路径：从根节点到叶节点
 * 
 * For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePath {

	/**
	 * 深度优先算法
	 * @param root
	 * @return
	 */
	
	public static List<String> res=new ArrayList<>();
	public static List<String> binaryTreePaths(TreeNode root){
		if(root!=null) findpath(root, String.valueOf(root.data));
		return res;
        	
	} 
	
	public static void findpath(TreeNode node,String path){
		if(node.left==null && node.right==null) res.add(path);
		if(node.left!=null) findpath(node.left, path+"->"+node.left.data);
		if(node.right!=null)findpath(node.right, path+"->"+node.right.data);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
