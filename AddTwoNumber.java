package com.wgcris.LeetcodeAlgorithm;

import java.util.*;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 *  Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ListNode l1 = new ListNode(3);
      ListNode x2 = new ListNode(6);
      ListNode x3 = new ListNode(9);
      l1.next=x2;
      x2.next=x3;
      
      ListNode l2 = new ListNode(2);
      ListNode y2 = new ListNode(5);
      ListNode y3 = new ListNode(8);
      l2.next=y2;
      y2.next=y3;
      
      ListNode ret = addTwoNumber(l1,l2);
      System.out.println(ret.next.val+" "+ret.next.next.val+" "+ret.next.next.next.val+" "+ret.next.next.next.next.val
    		  );
      
      
	}
	
	public static ListNode addTwoNumber(ListNode n1,ListNode n2){
		ListNode result=null;
		ListNode t1 =n1;
		ListNode t2 =n2;
		ListNode t3 =new ListNode(0);
		result =t3;
		//进位符 
		int flag =0;
		//如果两个链表都不为空
		while(t1!=null&&t2!=null){
			t3.next = new ListNode((t1.val+t2.val+flag)%10);
			flag =(t1.val+t2.val+flag)/10;
			t1=t1.next;
			t2=t2.next;
			t3 =t3.next;
		}
		while(t1!=null){
			t3.next =new ListNode((t1.val+flag)%10);
			flag =(t1.val+flag)/10;
			t1=t1.next;
			t3 =t3.next;
		}
		while(t2!=null){
			t3.next =new ListNode((t2.val+flag)%10);
			flag =(t2.val+flag)/10;
			t2=t2.next;
			t3 =t3.next;
		}
		while(flag!=0){
			t3.next =new ListNode((flag%10));
			flag =flag/10;
			t3=t3.next;
		}
		t3.next=null;
	
		return result;
	}
	
	
}

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val =x;
		next=null;
	}
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
}
