package com.wgcris.LeetcodeAlgorithm;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * 大数相乘：给定两个字符串，然后返回字符串乘积
 */
public class MultiplyStrings {
  
	public static String multiply(String num1,String num2){
		int n1=num1.length();
		int n2=num2.length();
		int[] pos=new int[n1+n2];
		for(int i=n1-1;i>=0;i--){
			for(int j=n2-1;j>=0;j--){
			   int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
			   int p1=i+j;
			   int p2=i+j+1;
			   int sum=mul+pos[p2];
			   pos[p1]+=sum/10;
			   pos[p2]=sum%10;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int p:pos){
			if(!(sb.length()==0&& p==0))sb.append(p);
		}
		return sb.length()==0?"0":sb.toString();
	}
	
	public static void main(String[] main){
		String num1="123";
		String num2="45";
		System.out.println(multiply(num1,num2));
	}
}
