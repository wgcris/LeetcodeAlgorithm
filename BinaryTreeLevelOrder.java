package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



/*
 * 107.二叉树层遍历，按层打印，由低部到顶部
 */

public class BinaryTreeLevelOrder {

	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
	}
	public static  List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null) return list;
		LinkedList<TreeNode> queue =new LinkedList<TreeNode>();
		
		List<Integer> lists=new ArrayList<Integer>();
	    queue.add(root);
	    int curLevelNodes=1; //记录当前层节点数
	    int nextLevelNodes=0;//记录下一层节点数
	    
		while(!queue.isEmpty()){
			TreeNode tempNode=queue.remove();
			lists.add(tempNode.data);
			curLevelNodes--;
			if(tempNode.left!=null){
				queue.add(tempNode.left);
				nextLevelNodes++;
			}
			if(tempNode.right!=null){
				queue.add(tempNode.right);
				nextLevelNodes++;
			}
			
			if(curLevelNodes==0){
				curLevelNodes=nextLevelNodes;
				nextLevelNodes=0;
				list.add(lists);
				lists=new ArrayList<Integer>();
			}
		}
		
		//倒序输出
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=list.size()-1;i>=0;i--){
		   result.add(list.get(i));
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //list数组输出
		List<Integer> list =new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);
         
	}

}


