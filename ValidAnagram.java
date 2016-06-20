package com.wgcris.LeetcodeAlgorithm;
/*
 * 判断有两个单词中，每个字幕出现的次数相同
 * 例子：s="anagram" t="nagaram"; 则：s==t
 * 思路：变形词的本质是两个单词中，每个字母出现的次数相同，所以我们可以用一个哈希表，
 * 记录第一个单词中每个字母的个数，再遍历第二个单词，减去相应的字母出现次数，如果某个字母的计数器不为0了，
 * 则说明某个字母出现的次数不一样。这里只用了一个大小为26的数组，是假设只会出现英文字母。
 */
public class ValidAnagram {

	public  boolean isAnagram(String s,String t){
		int[] table=new int[26];
		for(int i=0;i<s.length();i++)
			//统计单词中每个字母出现的次数
			table[s.charAt(i)-'a']++;
		for(int j=0;j<t.length();j++)
			//遍历第二个单词，减去相应字母，判断字母出现的次数是否为0
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
