package com.wgcris.LeetcodeAlgorithm;
/*
 * A->1;B->2 AA->27   26½øÖÆ
 */
public class ExcelSheetColumnNumber {

	public static void titleToNumber(String s){
		int num=0;
		for(int i=0;i<s.length();i++){
			num=num*26+(s.charAt(i)-'A'+1);
		}
		System.out.println(num);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    titleToNumber("AC");
	
	}

}
