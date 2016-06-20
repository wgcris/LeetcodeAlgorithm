package com.wgcris.LeetcodeAlgorithm;
/*
 * 计算小于非负整数的素数的个数。
 */
public class CountPrimes {
   
	public static int countPrimes(int n){
		int count=0;
		for(int i=1;i<n;i++){
			if(isPrimes(i)) count++;
		}
		return count;
	}
	
	//判断一个数是否是素数
	public static  boolean isPrimes(int num){
		if(num<=1)return false;
		//一个数的约数<=n/2;
		for(int i=2;i*i<=num;i++){
			if(num%i==0) return false;
		}
		return true;
	}
	/**
	 * 另外一种思路，取出点2,3,4,5的倍数，剩下的就是素数
	 * @param n
	 * @return
	 */
	public int countPrimes1(int n){
		//用真假表表示1-n数，那些要删除，那些保留
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
