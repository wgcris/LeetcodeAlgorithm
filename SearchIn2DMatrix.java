package com.wg.leetcode;
/*
 * 240 ��ά�����������
 * ˼·�������Ͻǿ�ʼ����
 */
public class SearchIn2DMatrix {
  
	public static boolean searchIn2DMatrix(int[][] matrix,int key){
		boolean result=false;
		int row=0;
		int columns=matrix[0].length-1;
		while(row<matrix.length && columns>=0){
			if(matrix[row][columns]==key) result=true;
			else if(matrix[row][columns]<key){
				row++;
			}else{
				columns--;
			}
		}
		return result;
	}
}
