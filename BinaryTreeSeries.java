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
	     * ������������������ö������ݽṹ
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
	     * ��������ȣ����ò������˼��ȥ�����ʹ��queue���ݽṹ
	     * @param root
	     * @return
	     */
	    public static int depthOfTree(TreeNode root){
	    	if(root==null)return 0;
	    	int depth=0;
	    	int curLevelNodes=1;//��ǰ��ڵ���
	    	int nextLevelNodes=0;//�²�ڵ���
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
	     * ��������ȣ����õݹ�
	     * @param root
	     * @return
	     */
	    public static int depthOfTree1(TreeNode root){
	    	if(root==null) return 0;
	    	return Math.max(depthOfTree(root.left), depthOfTree(root.right))+1;
	    }
	    
	    /***************************************************************************/   
	    /**
	     * �ǵݹ������ǰ�����
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
	      * �ǵݹ�������������
	      * @param root
	      */
	     public static void inOrder(TreeNode root){
	     	Stack<TreeNode> stack=new Stack<TreeNode>();
	     	if(root==null)return;
	     	TreeNode cur=root;
	     	while(true){
	     		//�Ƚ�������ȫ��ѹվ
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
	      * �ǵݹ�������� ��������ջ��һ��ջ�洢���ڵ�������ӽڵ㣬��һ��ջ�������
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
	      * �������������Ϊ�����˫�����������������
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
	       * ���������K��Ľڵ����   �ݹ�ⷨ��  
	       * ��1�����������Ϊ�ջ���k<1����0 
	       * ��2�������������Ϊ�ղ���k==1������1 
	       * ��3�������������Ϊ����k>1������root��������k-1��Ľڵ������root������k-1��ڵ����֮��  
     		* ����rootΪ����k��ڵ���Ŀ �ȼ��� ����root����Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ ���� 
     		* ��root�Һ���Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ   
     		* �������������Ȱ���������������������������⽵�� 
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
	       * ����������ڵ����
	       * ˼·��1)�ݹ�
	       * 2)���������ڲ�����Ļ����ϣ���һ��������count,ͳ�ƶ��д�С����
	       * @param root
	       * @return
	       */
	      public static int numsOfTree(TreeNode root){
	    	  if(root==null)return 0;
	    	  return numsOfLeafNode(root.left)+numsOfLeafNode(root.right)+1;
	      }
	      /**
	       * ������Ҷ�ӽڵ���� 
	       * ˼·�� �ݹ鷽��
	       * @param root
	       * @return
	       */
	      public static int numsOfLeafNode(TreeNode root){
	    	  if(root==null)return 0;
	    	  if(root.left==null && root.right==null) return 1;
	    	  return numsOfLeafNode(root.left)+numsOfLeafNode(root.right);
	      }
	      /**
	       * ���������Ҷ�ӽڵ����
	       * ˼·�����������ڲ����˼�룬����һ���ж�����
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
	      * �����������ǲ������
	      * ˼·���ݹ�
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
