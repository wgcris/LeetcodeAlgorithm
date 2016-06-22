package com.wg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * ����ȫ�������Ľڵ����
 * ˼·��1������ȫ�����������нڵ���ڼ����У�ͳ�Ƽ��ϵĴ�С����ȫ�������ڵ����
 */
public class CountBinaryTree {
  
	//��������������
	public static int treeHeight(TreeNode root){

		return root==null?0:Math.max(treeHeight(root.left), treeHeight(root.right))+1;
	}
	
	//��ȫ�������ڵ����
	//�������ڵ�洢��list������;
	//���ַ�����ʱ��
	public static int countNodes(TreeNode root){
		Queue<TreeNode>queue=new LinkedList<TreeNode>();
	    int count=1;
		if(root==null) return 0;
		queue.offer(root);
		while(queue.size()>0){
			TreeNode tempNode=queue.poll();
			
			if(tempNode.left!=null){
				queue.offer(tempNode.left);		
				count++;
			}
			if(tempNode.right!=null){
				queue.offer(tempNode.right);
				count++;
			}
		}
		return count;
		
	}
	/**
	 * ���õݹ鷨���ֱ�ͳ���������ڵ���������ڵ�
	 * @param root
	 * @return
	 */
	public static int countNodes1(TreeNode root){
		if(root==null) return 0;
		return countNodes1(root.left)+countNodes1(root.right)+1;
	}
	//ǰ�����
	public static void preOrder(TreeNode root){
		if(root==null) return ;
		int count=0;
		preOrder(root.left);
	
		System.out.println(root.val);
		preOrder(root.right);
		
	
	}
	public static void main(String[] args){
	    TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(5);
		TreeNode node5=new TreeNode(6);
		TreeNode node6=new TreeNode(7);
		TreeNode node7=new TreeNode(8);
  		root.left=node1;
 		root.right=node2;
		node1.left=node3;
		node3.left=node4;
		node3.right=node5;
		node2.left=node6;
		node2.right=node7;
	//	System.out.println(treeHeight(root));
		preOrder(root);
	}
}
