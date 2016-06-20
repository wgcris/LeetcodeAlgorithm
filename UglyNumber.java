package com.wgcris.LeetcodeAlgorithm;
/*
 * ���ݳ�ª���Ķ��壬���ǽ�����������2��3��5��ֱ���޷�������Ҳ���ǳ���2��3��5����������Ϊ0ʱֹͣ��
 * ��ʱ����õ�1��˵�����������Ӷ���2��3��5���������1�����ǳ�ª����
 */
public class UglyNumber {
  
	
	public static boolean isUgly(int num){
		if(num<=0)return false;
		if(num==1) return true;
		
		while(num>=2 &&num%2==0) num/=2;
		while(num>=3 &&num%3==0) num/=3;
		while(num>=5 &&num%5==0) num/=5;
		
		return num==1;
	}
}
