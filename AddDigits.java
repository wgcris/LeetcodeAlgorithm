package com.wgcris.LeetcodeAlgorithm;
/*
 * ����һ���Ǹ�����ÿһλ��ӣ��ظ�ִ�У��õ�������Ϊ��λ��
 * eg:38   3+8=11��1+1=2 ���2
 */
public class AddDigits {

	public static  int addDigits(int num){
		if(num==0) return 0;
		int result;
		result=num%9;
		if(result==0) result=9;
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(addDigits(45));
	}

}
