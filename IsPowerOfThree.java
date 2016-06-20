package com.wgcris.LeetcodeAlgorithm;
/**
 * �ж�һ������3���ݣ�������ѭ�����ߵ���
 * ˼·�����3������ݣ�Ȼ���ж�n�Ƿ�Ϊ������ݵ�Լ�����������Ϊ3���ݣ������ǡ�
 * @author wgcris
 *
 */
public class IsPowerOfThree {
   
	public static boolean isPowerOfThree(int n){
		if(n<=0) return false;
		int maxvalue=(int) Math.pow(3, (int)(Math.log(0x7fffffff)/Math.log(3)));
		
		return maxvalue%n==0;
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfThree(6));
	
	}
}
