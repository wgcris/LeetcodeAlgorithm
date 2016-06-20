package com.wgcris.LeetcodeAlgorithm;
/*
 * 两个数相加，两个数逆序存储在链表中
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
  
	public static  ListNode addTwoNumbers(ListNode node1, ListNode node2){
		if(node1==null) return node2;
		if(node2==null) return node1;
		ListNode result=null;
		ListNode node=new ListNode(0);		
		result=node;		
		int flag=0;
	
		while(node1!=null && node2!=null){	
			node.next=new ListNode((node1.val+node2.val+flag)%10);	
			flag=(node1.val+node2.val+flag)/10;
			node1=node1.next;
			node2=node2.next;
			node=node.next;
		}
		
		while(node1!=null && node2==null){
			node.next=new ListNode((node1.val+flag)%10);
			flag=(flag+node1.val)/10;
			node1=node1.next;
			node=node.next;
		}
		while(node1==null && node2!=null){
			node.next= new ListNode((node2.val+flag)%10);
			flag=(flag+node2.val)/10;
			node2=node2.next;
			node=node.next;
		}
		while(flag!=0){
			node.next=new ListNode(flag%10);
			flag=flag/10;
			node=node.next;
		}
	
		return result;
	}
	
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
      
 //     ListNode ret = addTwoNumbers(l1,l2);
 //     System.out.println(ret.val+" "+ret.next.val+" ");
    
     
      
      
	}
}
