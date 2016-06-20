package com.wgcris.LeetcodeAlgorithm;

import com.wgcris.LeetcodeAlgorithm.OddEvenList.ListNode;

/*
 *给定有序链表，删除掉重复的节点。
 */
public class DeleteDuplicates {
   
	class ListNode{
		int data;
		ListNode next;
		public ListNode(int data){
			this.data=data;
		}
	}
	public static ListNode deleteDuplicate(ListNode head){
		if(head==null||head.next==null)
			return head;
		else{
			ListNode cur = head;
			while(cur!=null){
				if(cur.data==cur.next.data){
					cur.next=cur.next.next;
				}
				cur=cur.next;
			}
			
		}
		return head;
	}	
	/**
	 * 利用递归
	 * @param head
	 * @return
	 */
	
	public ListNode deleteListNode(ListNode head){
		if(head==null||head.next==null)
			return head;
		head.next=deleteListNode(head.next);
		return head.data==head.next.data?head.next:head;
				
	}
	
	public static void main(String[] args){
		DeleteDuplicates oddeven=new DeleteDuplicates();
		  ListNode node1=oddeven.new ListNode(1);
		  ListNode node2=oddeven.new ListNode(1);
		  ListNode node3=oddeven.new ListNode(2);
		  ListNode node4=oddeven.new ListNode(3);
		  ListNode node5=oddeven.new ListNode(3);
		  node1.next=node2;
		  node2.next=node3;
		  node3.next=node4;
		  node4.next=node5;
		  node5.next=null;
		  ListNode node=deleteDuplicate(node1);
		  if(node==null){
			  System.out.println("为空！");
		  }
		  while(node!=null){
			  System.out.print(node.data+" ");
			  node=node.next;
		  }
	}
}
