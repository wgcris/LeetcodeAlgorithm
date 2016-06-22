package com.wg.leetcode;
/*
 * 345：翻转字符转中的元音字母
 */
public class ReverseVowelsOfString {
   /**
    * 思路：借助两个指针分别从前和后进行遍历，遇到元音字母就进行交换
    * @param s
    * @return
    */
	public static String reverseVowel(String s){
		if(s==null || s.length()<1) return s;
		
		int index1=0;
		int index2=s.length()-1;
		char[] chars=s.toCharArray();
		//可以换成s.contains();直接判断是否是元音字母
	  //  String vowels="aeiouAEIOU";
	   
		while(index1<index2){
			//如果index1和index2对应字符都是元音字母，则进行交换
			while(isVowel(chars[index1]) && isVowel(chars[index2])){
				//交换
				char temp=chars[index1];
				chars[index1]=chars[index2];
				chars[index2]=temp;
				//交换完了
				index1++;
				index2--;
			}
			while(index1<index2 && !isVowel(chars[index1])){
				index1++;
			}
			while(index1<index2  && !isVowel(chars[index2])){
				index2--;
			}
		}
		
		
		//char数组转换成string
		return s.valueOf(chars);
		
	}
	
	public static boolean isVowel(char c){
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
			return true;
		}else
			return false;		
	} 
	
	
	public static void main(String[] args){
	
//	    String s="leetcode";
//		System.out.println(reverseVowel(s));
		char a='a';
		System.out.println(a+"");
	}
}
