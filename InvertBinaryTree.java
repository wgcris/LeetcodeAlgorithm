

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Գƶ�����(������)
 *    ˼·�� ���õݹ�                
 */
public class InvertBinaryTree {
        
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			this.val=x;
		}
	}

	public static TreeNode invertTree(TreeNode root){
        	if(root==null) return null;
        	if(root.left==null && root.right==null) return root;
      
        		//����
        		TreeNode node=root.left;
        		root.left =root.right;
        		root.right=node;
     
        	invertTree(root.left);
            invertTree(root.right);
        	
        	return root;
        }
        
        // ���������������������һ�δ�ӡ ���ö���
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


