package com.wgcris.LeetcodeAlgorithm;
/*
 * 单链表删除节点
 * 思路：把删除节点的下一个节点的值复制到删除的节点上，然后删除删除节点的下一个节点
 */
public class DeleteNode {

	
	public void deleteNode(List_Node node){
		//头结点为空
		
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
