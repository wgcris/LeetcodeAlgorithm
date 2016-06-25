package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



/*
 * 107.������������������ӡ���ɵͲ�������
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
	    int curLevelNodes=1; //��¼��ǰ��ڵ���
	    int nextLevelNodes=0;//��¼��һ��ڵ���
	    
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
		
		//�������
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
          //list�������
		List<Integer> list =new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);
         
	}

}


