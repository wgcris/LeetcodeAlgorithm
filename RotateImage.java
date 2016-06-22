package com.wg.leetcode;

import java.util.Arrays;

/*
 * ��ת����
 * ˼·�����ø��Խ����ύ����ˮƽ�ύ��
 */
public class RotateImage {
   /**
    * ����ά����˳ʱ����ת90��
    * @param matrix
    */
	public static void rotate(int[][] matrix){
	   //�����Сn*n
		int n=matrix.length;
		if(n==1) return;
		
	//�Ը��Խ���Ϊ����н���
		for(int i=0;i<n;i++){
			for(int j=n-1-i;j>=0;j--){
				if(n-1-i==j)continue; //�Խ��߲�����
				//����
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i]=temp;		
			}
		}
		
		//��ˮƽ����з�ת
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				//����
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
		//��������
//		int[][] copy=new int[matrix.length][matrix.length];
		
		rotate(matrix);
		
	}
}
