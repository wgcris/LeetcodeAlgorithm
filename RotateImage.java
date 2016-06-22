package com.wg.leetcode;

import java.util.Arrays;

/*
 * 旋转矩阵
 * 思路：利用副对角线轴交换和水平轴交换
 */
public class RotateImage {
   /**
    * 将二维矩阵顺时针旋转90度
    * @param matrix
    */
	public static void rotate(int[][] matrix){
	   //矩阵大小n*n
		int n=matrix.length;
		if(n==1) return;
		
	//以副对角线为轴进行交换
		for(int i=0;i<n;i++){
			for(int j=n-1-i;j>=0;j--){
				if(n-1-i==j)continue; //对角线不交换
				//交换
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i]=temp;		
			}
		}
		
		//以水平轴进行翻转
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				//交换
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-i][j];
				matrix[n-1-i][j]=temp;
			}
		}
		print(matrix, n);
		
   }
	
	public static void print(int[][]matrix,int n){
		//print		 
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						System.out.print(matrix[i][j]+" ");
					}
					System.out.println();
				}
	}
	public static void main(String[] args){
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		print(matrix, 3);
		//复制数组
//		int[][] copy=new int[matrix.length][matrix.length];
		
		rotate(matrix);
		
	}
}
