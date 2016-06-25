package com.wgcris.LeetcodeAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * 113 ����������������һ����ֵ���������������ڵ�֮�͵��ڸö�ֵ������·����
 */
public class PathSum {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			this.val=x;
		}
	}

	/**
	 * ����ջ���л���
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		
		if(root==null) return new ArrayList<List<Integer>>();
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> path=new ArrayList<Integer>();
		
		DFS(res,path,root,sum);
		return res;
		
		
	}
	
	public void DFS(List<List<Integer>>res, List<Integer>path, TreeNode root, int sum){
		if(root.left==null && root.right==null && root.val==sum){
			path.add(root.val);
			res.add(new ArrayList<Integer>(path));
			//���� ɾ����һ���ڵ�
			path.remove(path.size()-1);
			return ;
			
		}
		if(root.left!=null){
			path.add(root.val);
			DFS(res,path,root.left,sum-root.val);
			path.remove(path.size()-1);
		}
		if(root.right!=null){
			path.add(root.val);
			DFS(res,path, root.right,sum-root.val);
			path.remove(path.size()-1);
		}
	}
	public boolean pathSumI(TreeNode root, int sum){
		if(root==null) return false;
		return DFS(root, sum);
	}
	
	//�������
	public boolean DFS(TreeNode root, int sum){
		if(root.left==null && root.right==null) return root.val==sum;
		if(root.left==null) return DFS(root.right,sum-root.val);
		if(root.right==null) return DFS(root.left,sum-root.val);
		else return DFS(root.left, sum-root.val)||DFS(root.right, sum-root.val); 
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
