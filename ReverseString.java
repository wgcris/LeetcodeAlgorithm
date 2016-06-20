package com.wgcris.LeetcodeAlgorithm;
/*
 * ×Ö·û´®·´×ª
 */
public class ReverseString {
  
	public static  String reverseString(String s){
		
		char[] chars=s.toCharArray();
		int n=chars.length;
		for(int i=0;i<n/2;i++){
			char temp=chars[i];
			chars[i]=chars[n-i-1];
			chars[n-i-1]=temp;
		}
		
		return String.valueOf(chars);
	}
	
	public static void main(String[] args){
		String s="hello";
		System.out.println(reverseString(s));
	}
}
