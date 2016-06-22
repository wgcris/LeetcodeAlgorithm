package com.wg.leetcode;

import java.util.ArrayList;
import java.util.List;

import sun.net.www.content.text.plain;

import com.sun.org.apache.xml.internal.utils.IntStack;



/*
 * 59,给定一个整数n，构造一个二维数组，数组元素由1-n^2平方填充，元素排列顺序为螺旋顺时针
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
			//上，从左向右
			for(int i=left;i<=right;i++){
				matrix[top][i]=num++;
			}
			if(++top>bottom)break;
			//右，从上至下
			for(int i=top;i<=bottom;i++){
				matrix[i][right]=num++;
			}
			if(left>--right)break;
			//下，从右向左
			for(int i=right;i>=left;i--){
				matrix[bottom][i]=num++;
			}
			if(top>--bottom)break;
			//左边，从下往上
			for(int i=bottom;i>=top;i--){
				matrix[i][left]=num++;
			}
			if(++left>right)break;
			
		}
		return matrix;
	}
	
	//以螺旋顺序打印二维数组
	/**
	 * 设定四个边界值，逐个边进行遍历，调整边界值大小
	 * @param matrix
	 */
	public static void print(int[][] matrix){
		int top=0;
		int left=0;
		int right=matrix[0].length-1;
		int bottom=matrix.length-1;
		List<Integer>list=new ArrayList<Integer>();
		while(true){
			//左边从左到右
			for(int i=left;i<=right;i++){
		        list.add(matrix[top][i]);
			}
		// 
			if(++top>bottom)break;
			//右边从上倒下
			for(int i=top;i<=bottom;i++){
				list.add(matrix[i][right]);
			}
			if(left>--right)break;
			
			// 底部，从右向左
			for(int i=right;i>=left;i--){
				list.add(matrix[bottom][i]);
			}
			if(top>--bottom)break;
			
			//左边，从下往上
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
