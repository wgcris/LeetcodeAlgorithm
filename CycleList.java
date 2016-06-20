package com.wgcris.LeetcodeAlgorithm;

/*
 * 141：链表是否有环
 * 思路：定义两个指针，index1，index2,第一个指针每次移动一个，第二个指针每次移动两个，如果两个指针相遇则有环，否则无环
 * 
 * 142：判断链表是否有环，返回环的开始节点，如果没有环，返回null
 */
public class CycleList {

	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			// TODO Auto-generated constructor stub
		 this.val=x;
		 this.next=null;
		}
	}
	public static  boolean hasCycle(ListNode head){
		if(head==null) return false;
		if(head.next==null) return false;
		ListNode pSlowListNode=head.next;
		ListNode pFasListNode=pSlowListNode.next;
		while(pSlowListNode!=null && pFasListNode!=null){
			if(pSlowListNode==pFasListNode) return true;
			pSlowListNode=pSlowListNode.next;
			pFasListNode=pFasListNode.next;
			if(pFasListNode!=null)pFasListNode=pFasListNode.next;
		}
		return false;
	}
	/**
	 *上面的解决方案不是很好。采用下面的方式，同样采用两个指针，只需要判断快的指针是否为空即可。
	 * @param head
	 * @return
	 */
	public  static boolean hasCycle1(ListNode head){
		if(head==null ) return false;
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)return true;
		}
		return false;
	}
	/**
	 * 检测链表是否有环，有环返回环的入口节点
	 * 思路：先找到两个指针的相遇点，然后得到环节点个数，
	 * 然后一个指针先从头节点移动步数为环节点总数，然后另一个节点从头结点开始移动，两个节点相遇的点就是环的入口节点
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head){
		//先得到两个指针相遇的节点
		ListNode meetNode=meetNode(head);
		if(meetNode==null) return null;
		//统计环的个数
		int loop=1;
		ListNode temp=meetNode;
		while(temp.next!=temp){
			temp=temp.next;
			loop++;
		}
		//得到环的节点个数后，定义两个指针，开始移动
		ListNode pNode1=head;
		for(int i=0;i<loop;i++){
			pNode1=pNode1.next;
		}
		ListNode pNode2=head;
		while(pNode1!=pNode2){
			pNode1=pNode1.next;
			pNode2=pNode2.next;					
		}
		return pNode1;
	}
	
	public static ListNode meetNode(ListNode head){
		if(head==null) return null;
		ListNode slow= head;
		ListNode fast=head;
		while(fast.next!=null&& fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return slow;
		}
		return null;
	}
	/**
	 * 上面求解方法时间复杂度太高
	 * 思路：先得到相遇点，然后定义两个指针，一个指针从链表起点开始移动，一个从相遇点开始移动，两个指针相遇的地方就是链表环的入口节点。
	 * 这个思路是由公式推导出来的。 (n-1)*r-(r-m)=s
	 * r为环的节点个数，m为入口节点到相遇点的节点个数，s为链表起始点到入口节点的个数。
	 * @param head
	 * @return
	 */
	public static ListNode getEntryOfCycleList(ListNode head){
		//首先得到相遇点
		if(head==null) return null;
		ListNode slow=head;
		ListNode fast=head;
		ListNode meetNode=null;
        while(fast.next!=null && fast.next.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        	if(slow==fast){
        		meetNode=fast;
        		break;
        	}
        }
        if(meetNode==null) return null;
        ListNode pNode=head;
        while(pNode!=meetNode){
        	pNode=pNode.next;
        	meetNode=meetNode.next;
        }
        return meetNode;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
