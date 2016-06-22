package com.wg.leetcode;
/*
 * 21.合并两个有序链表。
 */
public class MergeSortedList {
  
	 static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			// TODO Auto-generated constructor stub
		 this.val=x;
		 next=null;
		}
	}
	 
	 public ListNode mergeList(ListNode l1,ListNode l2){
		 ListNode flag = new ListNode(0);  
	        ListNode firstflag = flag;//标记第一个节点位置。  
	        while (l1 != null && l2 != null) {//★  
	            if(l1.val < l2.val){  
	                flag.next = l1;  
	                l1 = l1.next;  
	            }else {  
	                flag.next = l2;  
	                l2 = l2.next;  
	            }  
	            flag = flag.next;  
	        }  
	        flag.next = l1 != null ? l1 : l2;   
	        return firstflag.next;
	 }
	/**
	 * 思路：以一个链表作为基础，两个链表逐次进行比较，将小的插入到第一个链表中
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null) return l2;
		if(l2==null) return l1;

		ListNode newListNode=new ListNode(0);
		ListNode newList=newListNode;
		while(l1!=null && l2!=null){		 	
			if( l1.val<l2.val) {
				newListNode.next=l1;
				l1=l1.next;
				newListNode=newListNode.next;
			}
			else{
				newListNode.next=l2;
				l2=l2.next;
	     		newListNode=newListNode.next;
			}
		}
		newListNode.next=l1==null?l1:l2;

		return newList.next;
	}
	/**
	 * 采用递归的方法
	 * @param l1
	 * @param l2
	 * @return
	 */
	public  static ListNode mergeTwoLists1(ListNode l1,ListNode l2){
		if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

}
