package com.wg.leetcode;
/*
 * 28。implement strStr();  判断一个字符串是另一个字符串的子集     类似于Java 中 indexOf()方法
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack
 * 思路：这是典型的KMP模式匹配
 */
public class ImplementStrstr {
    /**
     * 思路：naive方法逐个进行对比
     * 
     * @param haystack
     * @param needle
     * @return
     */
	public static int strStr(String haystack, String needle){
		if(haystack==null || needle==null) return -1;
		if(needle.length()==0)return 0;
		int n1=haystack.length()-1;
		int n2=needle.length()-1;
		for(int i=0;i<=n1;i++){
			if(i+n2>n1) return -1;
			int m=i;
			for(int j=0;j<=n2;j++){
				if(needle.charAt(j)==haystack.charAt(m)){
					if(j==n2) return i;
					 m++;
				}					
				else{
					break;
				}
			}
		}
		return -1;

	}
	/**
	 * KMP 算法
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr1(String haystack, String needle) {
        if(haystack==null || needle==null)    
            return 0;
 
	int h = haystack.length();
	int n = needle.length();
 
	if (n > h)
		return -1;
	if (n == 0)
		return 0;
 
	int[] next = getNext(needle);
	int i = 0;
 
	while (i <= h - n) {
		int success = 1;
		for (int j = 0; j < n; j++) {
			if (needle.charAt(0) != haystack.charAt(i)) {
				success = 0;
				i++;
				break;
			} else if (needle.charAt(j) != haystack.charAt(i + j)) {
				success = 0;
				i = i + j - next[j - 1];
				break;
			}
		}
		if (success == 1)
			return i;
	}
 
	return -1;
}
 
//calculate KMP array
public int[] getNext(String needle) {
	int[] next = new int[needle.length()];
	next[0] = 0;
 
	for (int i = 1; i < needle.length(); i++) {
		int index = next[i - 1];
		while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
			index = next[index - 1];
		}
 
		if (needle.charAt(index) == needle.charAt(i)) {
			next[i] = next[i - 1] + 1;
		} else {
			next[i] = 0;
		}
	}
 
	return next;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String haystack="abfdcsscdef";
       String needle="cd";
      
       System.out.println(strStr(haystack, needle));
	}

}
