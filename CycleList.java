package com.wgcris.LeetcodeAlgorithm;

/*
 * 141�������Ƿ��л�
 * ˼·����������ָ�룬index1��index2,��һ��ָ��ÿ���ƶ�һ�����ڶ���ָ��ÿ���ƶ��������������ָ���������л��������޻�
 * 
 * 142���ж������Ƿ��л������ػ��Ŀ�ʼ�ڵ㣬���û�л�������null
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
	 *����Ľ���������Ǻܺá���������ķ�ʽ��ͬ����������ָ�룬ֻ��Ҫ�жϿ��ָ���Ƿ�Ϊ�ռ��ɡ�
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
	 * ��������Ƿ��л����л����ػ�����ڽڵ�
	 * ˼·�����ҵ�����ָ��������㣬Ȼ��õ����ڵ������
	 * Ȼ��һ��ָ���ȴ�ͷ�ڵ��ƶ�����Ϊ���ڵ�������Ȼ����һ���ڵ��ͷ��㿪ʼ�ƶ��������ڵ������ĵ���ǻ�����ڽڵ�
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head){
		//�ȵõ�����ָ�������Ľڵ�
		ListNode meetNode=meetNode(head);
		if(meetNode==null) return null;
		//ͳ�ƻ��ĸ���
		int loop=1;
		ListNode temp=meetNode;
		while(temp.next!=temp){
			temp=temp.next;
			loop++;
		}
		//�õ����Ľڵ�����󣬶�������ָ�룬��ʼ�ƶ�
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
	 * ������ⷽ��ʱ�临�Ӷ�̫��
	 * ˼·���ȵõ������㣬Ȼ��������ָ�룬һ��ָ���������㿪ʼ�ƶ���һ���������㿪ʼ�ƶ�������ָ�������ĵط�������������ڽڵ㡣
	 * ���˼·���ɹ�ʽ�Ƶ������ġ� (n-1)*r-(r-m)=s
	 * rΪ���Ľڵ������mΪ��ڽڵ㵽������Ľڵ������sΪ������ʼ�㵽��ڽڵ�ĸ�����
	 * @param head
	 * @return
	 */
	public static ListNode getEntryOfCycleList(ListNode head){
		//���ȵõ�������
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
