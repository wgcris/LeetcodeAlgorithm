package com.wgcris.LeetcodeAlgorithm;
/*
 * 超级丑数，可以指定丑数包含的素数，求出第n个素数
 * 思路： 参考uglyNumberII
 */
public class SuperUglyNumber {
   
	public static int nthSuperUglyNumber(int n,int[]primes){
		int[] ugly=new int[n];
		//定义数组factor[]用来标记primes数组中每个素数
		int[] factors=new int[primes.length];
		
		ugly[0]=1;
		for(int i=1;i<n;i++){
			ugly[i]=Integer.MAX_VALUE;
//			for(int j=0;i<primes.length;j++){
//				ugly[i]=Math.min(ugly[i], primes[j]*ugly[factors[j]]);
//			}
//			for(int j=0;j<primes.length;j++){
//				while(ugly[factors[j]]*primes[j]<=ugly[i]) factors[j]++;
//			}
			for(int j=0;j<primes.length;j++){
				if(primes[j]*ugly[factors[j]]==ugly[i-1]){
					factors[j]++;
				}
				ugly[i]=Math.min(ugly[i], primes[j]*ugly[factors[j]]);
			}
		}
		return ugly[n-1];
	}
	
	public static void main(String[] args){
		int[] primes={2,7,13,19};
		System.out.println(nthSuperUglyNumber(12, primes));
	}
}
