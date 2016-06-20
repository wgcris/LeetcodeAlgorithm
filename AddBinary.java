package com.wgcris.LeetcodeAlgorithm;

import java.util.Stack;

/*
 * �������������ַ������������������Ƶĺͣ����Ҳ���ַ���
 */
public class AddBinary {
 

	//����ջ
	public static String addBinary(String a,String b){
		Stack<Character> stack_a=new Stack<Character>();
		Stack<Character> stack_b =new Stack<Character>();
		Stack<Integer> stack=new Stack<Integer>();
		StringBuffer result=new StringBuffer();
		
		//���ַ�������ջ��
		for(int i=0;i<a.length();i++){
			stack_a.add(a.charAt(i));
		}
		for(int i=0;i<b.length();i++){
			stack_b.add(b.charAt(i));
		}
		
		int flag=0;
		while(!stack_a.empty() && !stack_b.empty()){
			int a1=stack_a.pop()-'0';
			
			int a2=stack_b.pop()-'0';
			stack.push(((a1+a2+flag)%2));
			flag=(a1+a2+flag)/2;
		}
		while(!stack_a.empty() && stack_b.empty()){
			int a1=stack_a.pop()-'0';
			stack.push((a1+flag)%2);
			flag=(a1+flag)/2;
			
		}
		while(stack_a.empty() && !stack_b.empty()){
			int a2=stack_b.pop()-'0';
			stack.push( (a2+flag)%2);
			flag=(a2+flag)/2;
		}
		
		while(flag!=0){
			stack.push(flag%2);
			flag/=2;
		}
		
		while(!stack.empty()){
			result.append(stack.pop());
			
		}
		return result.toString();
	}
	/**
	 * ����ķ���̫�鷳��
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary1(String a,String b){
		int aLength=a.length();
		int bLength=b.length();
		StringBuffer sBuffer=new StringBuffer();
		int flag=0;
		while(Math.max(aLength, bLength)>0){
			int aNum=aLength>0?a.charAt(aLength---1)-'0':0;
			int bNum=bLength>0?b.charAt(bLength---1)-'0':0;
			int sum=aNum+bNum+flag;
			flag=sum/2;
			sBuffer.append(sum%2);
		}
		
		return (flag==1)?sBuffer.append(1).reverse().toString():sBuffer.reverse().toString();
	} 
	public static void main(String[] args){
//		StringBuffer s=new StringBuffer();
//		System.out.println(s.append("abc"));
//		System.out.println(s.append("ef"));
		
//		String a="111";
//		String b="1";
	//	System.out.println(addBinary1(a, b));
		
//		Stack<Character> stack=new Stack<Character>();
//		stack.push('a');
//		stack.push('b');
//		while(!stack.empty()){
//			System.out.println(stack.pop());
//		}
	}
}
