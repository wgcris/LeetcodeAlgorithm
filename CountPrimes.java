package com.wgcris.LeetcodeAlgorithm;
/*
 * ����С�ڷǸ������������ĸ�����
 */
public class CountPrimes {
   
	public static int countPrimes(int n){
		int count=0;
		for(int i=1;i<n;i++){
			if(isPrimes(i)) count++;
		}
		return count;
	}
	
	//�ж�һ�����Ƿ�������
	public static  boolean isPrimes(int num){
		if(num<=1)return false;
		//һ������Լ��<=n/2;
		for(int i=2;i*i<=num;i++){
			if(num%i==0) return false;
		}
		return true;
	}
	/**
	 * ����һ��˼·��ȡ����2,3,4,5�ı�����ʣ�µľ�������
	 * @param n
	 * @return
	 */
	public int countPrimes1(int n){
		//����ٱ��ʾ1-n������ЩҪɾ������Щ����
		boolean[] isPrimes=new boolean[n];
		for(int i=2;i<n;i++){
			isPrimes[i]=true;
		}
		for(int i=2;i*i<n;i++){
			if(!isPrimes[i])continue;
			for(int j=i*i;j<n;j+=i){
				isPrimes[j]=false;
			}
		}
		int count=0;
		for(int i=2;i<n;i++){
			if(isPrimes[i])count++;
		}
		return count;
	}
	
	public static void main(String[] args){
	//	System.out.println(isPrimes(3));
		System.out.println(countPrimes(5));
	}
}
