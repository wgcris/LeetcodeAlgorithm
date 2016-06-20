package com.wgcris.LeetcodeAlgorithm;
/*
 * ���⣺һ��������λ�洢��һ��int�����У�����˳��Ϊ�����λ��array[0] �����λ��[n-1]�����磺98���洢Ϊ��array[0]=9; array[1]=8;
����˼·������������һλ��ʼ��1����Ҫ���ǽ�λ�������[0]λ֮����Ȼ�н�λ���ڣ���Ҫ�¿�һ������Ϊ(n.length + 1)�����飬����ԭ�������顣
 */
public class PlusOne {
   public static int[] plusOne(int[] digits){
	   int len=digits.length;
	   int flag=1;
	   for(int i=len-1;i>=0;i--){
		   digits[i]=digits[i]+flag;
		   if(digits[i]>9){
			   flag=1;
			   digits[i]=0;
		   }
		   else{
			   flag=0;
			   digits[i]=digits[i];
		   } 
	   }
	   int[] result;
	   if(flag!=0){
		    result=new int[len+1];
		   for(int i=1;i<result.length;i++){
			   result[i]=digits[i-1];
		   }
		   result[0]=1;
	   } else{
		   return digits;
	   }
	   
	   return result;
   }
   
   public static void main(String[] main){
	   int[] digits={9,8};
	   int[] digits1={9,9};
	   int[] result=plusOne(digits1);
	   for(int i:result){
		   System.out.print(i+" ");
	   }
   }
}
