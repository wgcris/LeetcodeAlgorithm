package com.wgcris.LeetcodeAlgorithm;
/*
 * ������ɾ���ڵ�
 * ˼·����ɾ���ڵ����һ���ڵ��ֵ���Ƶ�ɾ���Ľڵ��ϣ�Ȼ��ɾ��ɾ���ڵ����һ���ڵ�
 */
public class DeleteNode {

	
	public void deleteNode(List_Node node){
		//ͷ���Ϊ��
		
		node.data=node.next.data;
		node.next=node.next.next;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class List_Node{
	int data;
	List_Node next;
}
