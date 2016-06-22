package com.wg.leetcode;

import java.util.ArrayList;
import java.util.List;

import sun.net.www.content.text.plain;

import com.sun.org.apache.xml.internal.utils.IntStack;



/*
 * 59,����һ������n������һ����ά���飬����Ԫ����1-n^2ƽ����䣬Ԫ������˳��Ϊ����˳ʱ��
 * [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrix {
   
	public static  int[][] generateMatrix(int n){
		int[][] matrix=new int[n][n];
		int top=0;
		int left=0;
		int right=n-1;
		int bottom=n-1;
		int num=1;
		while(true){
			//�ϣ���������
			for(int i=left;i<=right;i++){
				matrix[top][i]=num++;
			}
			if(++top>bottom)break;
			//�ң���������
			for(int i=top;i<=bottom;i++){
				matrix[i][right]=num++;
			}
			if(left>--right)break;
			//�£���������
			for(int i=right;i>=left;i--){
				matrix[bottom][i]=num++;
			}
			if(top>--bottom)break;
			//��ߣ���������
			for(int i=bottom;i>=top;i--){
				matrix[i][left]=num++;
			}
			if(++left>right)break;
			
		}
		return matrix;
	}
	
	//������˳���ӡ��ά����
	/**
	 * �趨�ĸ��߽�ֵ������߽��б����������߽�ֵ��С
	 * @param matrix
	 */
	public static void print(int[][] matrix){
		int top=0;
		int left=0;
		int right=matrix[0].length-1;
		int bottom=matrix.length-1;
		List<Integer>list=new ArrayList<Integer>();
		while(true){
			//��ߴ�����
			for(int i=left;i<=right;i++){
		        list.add(matrix[top][i]);
			}
		// 
			if(++top>bottom)break;
			//�ұߴ��ϵ���
			for(int i=top;i<=bottom;i++){
				list.add(matrix[i][right]);
			}
			if(left>--right)break;
			
			// �ײ�����������
			for(int i=right;i>=left;i--){
				list.add(matrix[bottom][i]);
			}
			if(top>--bottom)break;
			
			//��ߣ���������
			for(int i=bottom;i>=top;i--){
				list.add(matrix[i][left]);
			}
			if(++left>right)break;
			
		}
		System.out.println(list);
	}
	
	public static void main(String[] args){
		int[][] matrix={{1,2,3,4},{4,5,6,5},{7,8,9,5}};
		System.out.println(matrix.length+" "+ matrix[0].length);
//		int[][] matrix=generateMatrix(3);
//		print(matrix);
	}
}
