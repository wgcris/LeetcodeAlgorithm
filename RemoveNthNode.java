package com.wg.leetcode;

import com.wg.leetcode.MergeSortedList.ListNode;

/*
 * 19，从链表末尾开始删除第n个节点，返回链表头部
 */
public class RemoveNthNode {
   /**
    * 思路：定义两个指针，一个先移动n-1 步，另一个指针从头结点开始，两个指针一起移动，当第一个指针移动到末尾时，第二个指针
    * 就移动到了倒数第n个节点处，然后删除节点。
    * @param head
    * @param n
    * @return
    */
	public static  ListNode removeNthFromEnd(ListNode head, int n){
		if(head==null || n<0) return null;
		if(head.next==null && n>=1)return null;
		//定义两个指针
		ListNode pNode1=head;
		 ListNode pNode2=head;
		//第一个指针先移动n 步
		//注意：n不能大于链表长度
		for(int i=0;i<n;i++){		
			pNode1=pNode1.next;			
		}
		//如果pNode1==null说明此时要删除的是头结点，所以head=head.next; 返回头结点
		if(pNode1==null){
			head=head.next;
		
			return head;
		}
	//当pNode1！=null时，移动两个指针指针，
		 while(pNode1.next!=null){
			 pNode1=pNode1.next;
			 pNode2=pNode2.next;
		 }
		//找到待删除的节点得前节点

		 if(pNode2.next.next==null)
			  pNode2.next=null;
		 else{
			 pNode2.next=pNode2.next.next;
		 }
		 
		 return head;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
