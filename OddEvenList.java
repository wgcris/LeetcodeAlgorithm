package com.wgcris.LeetcodeAlgorithm;
/*
 * ��ż����  ������1-2-3-4-5-null;���1-3-5-2-4-null;ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
 * �Ƚ�ż���������ֿ���Ȼ��ż�����뵽��������
 */
public class OddEvenList {
  class ListNode{
	  int data;
	  ListNode next;
	  public ListNode(int data){
		  this.data=data;
	  }
  }
	  public static ListNode oddEvenList(ListNode head){
		  if (head != null) {

		        ListNode odd = head, even = head.next, evenHead = even; 

		        while (even != null && even.next != null) {
		            odd.next = odd.next.next; 
		            even.next = even.next.next; 
		            odd = odd.next;
		            even = even.next;
		        }
		        odd.next = evenHead; 
		    }
		    return head; 
	  }
  
	  
	  public static void main(String[] args){
		  OddEvenList oddeven=new OddEvenList();
		  ListNode node1=oddeven.new ListNode(1);
		  ListNode node2=oddeven.new ListNode(2);
		  ListNode node3=oddeven.new ListNode(3);
		  ListNode node4=oddeven.new ListNode(4);
		  ListNode node5=oddeven.new ListNode(5);
		  node1.next=node2;
		  node2.next=node3;
		  node3.next=node4;
		  node4.next=node5;
		  node5.next=null;
		  ListNode node=oddEvenList(node1);
		  while(node!=null){
			  System.out.print(node.data+" ");
			  node=node.next;
		  }
	  }
}
