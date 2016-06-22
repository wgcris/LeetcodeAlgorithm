package com.wg.leetcode;
/*
 * 345����ת�ַ�ת�е�Ԫ����ĸ
 */
public class ReverseVowelsOfString {
   /**
    * ˼·����������ָ��ֱ��ǰ�ͺ���б���������Ԫ����ĸ�ͽ��н���
    * @param s
    * @return
    */
	public static String reverseVowel(String s){
		if(s==null || s.length()<1) return s;
		
		int index1=0;
		int index2=s.length()-1;
		char[] chars=s.toCharArray();
		//���Ի���s.contains();ֱ���ж��Ƿ���Ԫ����ĸ
	  //  String vowels="aeiouAEIOU";
	   
		while(index1<index2){
			//���index1��index2��Ӧ�ַ�����Ԫ����ĸ������н���
			while(isVowel(chars[index1]) && isVowel(chars[index2])){
				//����
				char temp=chars[index1];
				chars[index1]=chars[index2];
				chars[index2]=temp;
				//��������
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
		
		
		//char����ת����string
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
