package com.wgcris.LeetcodeAlgorithm;

import java.util.HashMap;
/*
 * ��������ת���� ��Χ��0-3999��
 * //����1������5������10��L��50��C��100��D��500��M��1000�� 
        // rules:λ�ڴ����ĺ���ʱ����Ϊ������λ�ڴ�����ǰ�����Ϊ����
        //eg����=3,��=4,��=6,����=19,����=20,��L��=45,MCM����C=1980
        //"DCXXI"
 */

public class RomanToInt {

	public static int romanToInt(String s){
		if(s==null||s.length()==0)
			return 0;
		int len=s.length();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		    map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        int result= map.get(s.charAt(len-1));
	        int temp=result;
	        for(int i=len-2;i>=0;i--){
	        	int cur=map.get(s.charAt(i));
	        	if(temp>cur)
	        		result+=cur;
	        	else{
	        		result-=cur;
	        	}
	        	temp=cur;
	        }
	        return result;
	        
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
