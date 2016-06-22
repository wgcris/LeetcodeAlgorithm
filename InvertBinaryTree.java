package com.wg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 求对称二叉树(即镜像)
 *    思路： 利用递归                
 */
public class InvertBinaryTree {
        public static TreeNode invertTree(TreeNode root){
        	if(root==null) return null;
        	if(root.left==null && root.right==null) return root;
      
        		//交换
        		TreeNode node=root.left;
        		root.left =root.right;
        		root.right=node;
     
        	invertTree(root.left);
            invertTree(root.right);
        	
        	return root;
        }
        
        // 按层遍历二叉树，从左到右一次打印 利用队列
        public static void levelTraverse(TreeNode root){
        	Queue<TreeNode> queue=new LinkedList<TreeNode>();
        	if(root==null)return;
        	queue.offer(root);
        	while(queue.size()>0){
        		TreeNode tempNode=queue.poll();
        		System.out.print(tempNode.val+" ");
        		if(tempNode.left!=null){
        			queue.offer(tempNode.left);
        		}
        		if(tempNode.right!=null){
        			queue.offer(tempNode.right);
        		}
        	}
        }
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.val=x;
	}
}

