package com.wg.leetcode;

import com.wg.leetcode.MergeSortedList.ListNode;

/*
 * 19��������ĩβ��ʼɾ����n���ڵ㣬��������ͷ��
 */
public class RemoveNthNode {
   /**
    * ˼·����������ָ�룬һ�����ƶ�n-1 ������һ��ָ���ͷ��㿪ʼ������ָ��һ���ƶ�������һ��ָ���ƶ���ĩβʱ���ڶ���ָ��
    * ���ƶ����˵�����n���ڵ㴦��Ȼ��ɾ���ڵ㡣
    * @param head
    * @param n
    * @return
    */
	public static  ListNode removeNthFromEnd(ListNode head, int n){
		if(head==null || n<0) return null;
		if(head.next==null && n>=1)return null;
		//��������ָ��
		ListNode pNode1=head;
		 ListNode pNode2=head;
		//��һ��ָ�����ƶ�n ��
		//ע�⣺n���ܴ���������
		for(int i=0;i<n;i++){		
			pNode1=pNode1.next;			
		}
		//���pNode1==null˵����ʱҪɾ������ͷ��㣬����head=head.next; ����ͷ���
		if(pNode1==null){
			head=head.next;
		
			return head;
		}
	//��pNode1��=nullʱ���ƶ�����ָ��ָ�룬
		 while(pNode1.next!=null){
			 pNode1=pNode1.next;
			 pNode2=pNode2.next;
		 }
		//�ҵ���ɾ���Ľڵ��ǰ�ڵ�

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
