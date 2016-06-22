package com.wg.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




	public class BinaryTreeSeries {

		private static class TreeNode {  
	        int val;  
	        TreeNode left;  
	        TreeNode right;  
	   
	        public TreeNode(int val) {  
	            this.val = val;  
	        }  
	    } 
		
		 /**
	     * 二叉树层序遍历：利用队列数据结构
	     * @param root
	     */
	    public static void levelOrder(TreeNode root){
	    	Queue<TreeNode>queue=new LinkedList<TreeNode>();
	    	if(root==null)return;
	    	queue.add(root);
	    	while(!queue.isEmpty()){
	    		TreeNode tempNode=queue.remove();
	    		System.out.print(tempNode.val+" ");
	    		if(tempNode.left!=null){
	    			queue.add(tempNode.left);
	    		}
	    		if(tempNode.right!=null){
	    			queue.add(tempNode.right);
	    		}
	    	}
	    }
	    
	    /**
	     * 二叉树深度，利用层序遍历思想去解决。使用queue数据结构
	     * @param root
	     * @return
	     */
	    public static int depthOfTree(TreeNode root){
	    	if(root==null)return 0;
	    	int depth=0;
	    	int curLevelNodes=1;//当前层节点数
	    	int nextLevelNodes=0;//下层节点数
	    	Queue<TreeNode>queue=new LinkedList<TreeNode>();
	    	queue.add(root);
	    	while(!queue.isEmpty()){
	    		TreeNode curNode=queue.remove();
	    		curLevelNodes--;
	    		if(curNode.left!=null){
	    			queue.add(curNode.left);
	    			nextLevelNodes++;
	    		}
	    		if(curNode.right!=null){
	    			queue.add(curNode.right);
	    			nextLevelNodes++;
	    		}
	    		if(curLevelNodes==0){
	    			depth++;
	        		curLevelNodes=nextLevelNodes;
	        		nextLevelNodes=0;
	    		}
	    	}
	    	return depth;
	    	
	    }  
	    /**
	     * 二叉树深度：利用递归
	     * @param root
	     * @return
	     */
	    public static int depthOfTree1(TreeNode root){
	    	if(root==null) return 0;
	    	return Math.max(depthOfTree(root.left), depthOfTree(root.right))+1;
	    }
	    
	    /***************************************************************************/   
	    /**
	     * 非递归二叉树前序遍历
	     * @param root
	     */
	     public static void preOrder(TreeNode root){
	     	Stack<TreeNode> stack=new Stack<TreeNode>();
	     	if(root==null) return ;
	     	stack.push(root);
	     	while(!stack.isEmpty()){
	     		TreeNode temp=stack.pop();
	     		System.out.print(temp.val+" ");
	     		
	     		if(temp.left!=null){
	     			stack.push(temp.left);
	     		}
	     		if(temp.right!=null){
	     			stack.push(temp.right);
	     		}
	     	}
	     }
	     /**
	      * 非递归二叉树中序遍历
	      * @param root
	      */
	     public static void inOrder(TreeNode root){
	     	Stack<TreeNode> stack=new Stack<TreeNode>();
	     	if(root==null)return;
	     	TreeNode cur=root;
	     	while(true){
	     		//先将左子树全部压站
	     		while(cur!=null){
	     			stack.push(cur);
	     			cur=cur.left;
	     		}
	     	       
	     		   if(stack.isEmpty())break;
	     			cur=stack.pop();
	     			System.out.print(cur.val+" ");
	     			cur=cur.right;
	     			
	     	}
	     	
	     }
	     /**
	      * 非递归后续遍历 利用两个栈，一个栈存储根节点和左右子节点，另一个栈用于输出
	      * @param root
	      */
	     public static void postOrder(TreeNode root){
	     	Stack<TreeNode>stack=new Stack<TreeNode>();
	     	Stack<TreeNode>output=new Stack<TreeNode>();
	     	if(root==null)return;
	     	stack.push(root);
	     	while(!stack.isEmpty()){
	     		TreeNode temp= stack.pop();
	     		output.push(temp);
	     		
	     		if(temp.left!=null){
	     			stack.push(temp.left);
	     		}
	     		if(temp.right!=null){
	     			stack.push(temp.right);
	     		}
	     	}
	     	while(!output.isEmpty()){
	     		
	     		System.out.print(output.pop().val+" ");
	     	}
	     	
	     }
	       
	/*************************************************************************/   
	  
	     /**
	      * 将二叉查找树变为有序的双向链表，利用中序遍历
	      * @param root
	      * @return
	      */
	      public static TreeNode invertBSTto2DLink(TreeNode root){
	     	 if(root==null)return null;
	     	 Stack<TreeNode>stack=new Stack<TreeNode>();
	     	 TreeNode cur=root;
	     	 TreeNode preNode=null;
	     	 TreeNode head=null;
	     	 while(true){
	     		 while(cur!=null){
	     			 stack.push(cur);
	     			 cur=cur.left;
	     		 }
	     		 if(stack.isEmpty())break;
	     		 cur=stack.pop();
	     		 if(preNode!=null){
	     			 preNode.right=cur;
	     		 }
	     		 if(head==null){
	     			 head=cur;
	     		 }
	     		 preNode=cur;
	     		 cur=cur.right;   		 
	     	 }
	     	 return head;
	      }  
	      /**
	       * 求二叉树第K层的节点个数   递归解法：  
	       * （1）如果二叉树为空或者k<1返回0 
	       * （2）如果二叉树不为空并且k==1，返回1 
	       * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和  
     		* 求以root为根的k层节点数目 等价于 求以root左孩子为根的k-1层（因为少了root那一层）节点数目 加上 
     		* 以root右孩子为根的k-1层（因为少了root那一层）节点数目   
     		* 所以遇到树，先把它拆成左子树和右子树，把问题降解 
	       * @param root
	       * @param k
	       * @return
	       */
	      public static int numOfKthLevel(TreeNode root,int k){
	      	if(root==null || k<1) return 0;
	      	if(root!=null && k==1)return 1;	      	
	      	return numOfKthLevel(root.left, k-1)+numOfKthLevel(root.right, k-1);
	      } 
	      
	      /**
	       * 计算二叉树节点个数
	       * 思路：1)递归
	       * 2)迭代法，在层遍历的基础上，加一个计数器count,统计队列大小即可
	       * @param root
	       * @return
	       */
	      public static int numsOfTree(TreeNode root){
	    	  if(root==null)return 0;
	    	  return numsOfLeafNode(root.left)+numsOfLeafNode(root.right)+1;
	      }
	      /**
	       * 二叉树叶子节点个数 
	       * 思路： 递归方法
	       * @param root
	       * @return
	       */
	      public static int numsOfLeafNode(TreeNode root){
	    	  if(root==null)return 0;
	    	  if(root.left==null && root.right==null) return 1;
	    	  return numsOfLeafNode(root.left)+numsOfLeafNode(root.right);
	      }
	      /**
	       * 计算二叉树叶子节点个数
	       * 思路：迭代，基于层遍历思想，加上一个判断条件
	       * @param root
	       * @return
	       */
	      public static int numsOfLeafNode1(TreeNode root){
	    	  if(root==null) return 0;
	    	  Queue<TreeNode>queue=new LinkedList<BinaryTreeSeries.TreeNode>();
	    	  int count=0;
	    	  queue.add(root);
	    	  while(!queue.isEmpty()){
	    		  TreeNode cur=queue.remove();
	    		  if(cur.left!=null){
	    			  queue.add(cur.left);
	    		  }
	    		  if(cur.right!=null){
	    			  queue.add(cur.right);
	    		  }
	    		  if(cur.left==null&& cur.right==null){
	    			  count++;
	    		  }	    		  
	    	  }
	    	  return count;	    	  
	      }
	     /**
	      * 两个二叉树是不是相等
	      * 思路：递归
	      * @param root1
	      * @param root2
	      * @return
	      */
	      public static boolean sameOfTree(TreeNode root1,TreeNode root2){
	    	  if(root1==null && root2==null) return true;
	    	  else if(root1==null || root2==null) return false;
	    	  if(root1.val!=root2.val)return false;	    	  
	    	  return sameOfTree(root1.left, root2.left)&& sameOfTree(root1.right, root2.right);
	      }
	      
	      
}
