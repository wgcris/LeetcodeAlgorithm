package com.wgcris.LeetcodeAlgorithm;

import java.util.HashSet;
import java.util.Set;

/*
 * happyNumber eg:1^2 + 9^2 = 82
                  8^2 + 2^2 = 68
                  6^2 + 8^2 = 100
                  1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
       public static boolean isHappy(int n){
    	   if (n <= 0) return false;
    	    HashSet<Integer> set = new HashSet<Integer>();
    	    int m=0;
    	    while(n !=1 && !set.contains(n)) {
    	        set.add(n);
    	        m = n;
    	        n = 0;
    	        while(m != 0) {
    	            n += (m%10)*(m%10);
    	            m = m/10;
    	        }
    	    }
    	    if (n == 1) return true;
    	    else return false;
     }
       
       public static  boolean isHappy1(int n){
    	  if(n<=0)return false;
    	  Set<Integer> set =new HashSet<Integer>();
    	  set.add(n);
    	  while(n!=1){
    		  int result=0;
    		  while(n!=0){
    			  result+=(n%10)*(n%10);
    			  n/=10;
    		  }
    		  if(!set.add(result)) return false;
    		  else {
    			  set.add(result);
    			  n=result;  
    		  }
    	  }
    	  return true;
       }
      public static void main(String[] args){
    	  System.out.println(isHappy1(100));

    	
      }
}
