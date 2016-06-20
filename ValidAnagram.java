package com.wgcris.LeetcodeAlgorithm;
/*
 * �ж������������У�ÿ����Ļ���ֵĴ�����ͬ
 * ���ӣ�s="anagram" t="nagaram"; ��s==t
 * ˼·�����δʵı��������������У�ÿ����ĸ���ֵĴ�����ͬ���������ǿ�����һ����ϣ��
 * ��¼��һ��������ÿ����ĸ�ĸ������ٱ����ڶ������ʣ���ȥ��Ӧ����ĸ���ִ��������ĳ����ĸ�ļ�������Ϊ0�ˣ�
 * ��˵��ĳ����ĸ���ֵĴ�����һ��������ֻ����һ����СΪ26�����飬�Ǽ���ֻ�����Ӣ����ĸ��
 */
public class ValidAnagram {

	public  boolean isAnagram(String s,String t){
		int[] table=new int[26];
		for(int i=0;i<s.length();i++)
			//ͳ�Ƶ�����ÿ����ĸ���ֵĴ���
			table[s.charAt(i)-'a']++;
		for(int j=0;j<t.length();j++)
			//�����ڶ������ʣ���ȥ��Ӧ��ĸ���ж���ĸ���ֵĴ����Ƿ�Ϊ0
			table[t.charAt(j)-'a']--;
		for(int i:table){
			if(i!=0) return false;
			
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
