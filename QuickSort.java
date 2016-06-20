package com.wgcris.LeetcodeAlgorithm;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] array = {63,99,3,5,55,66,100,1000,21,2,9,4,23,2,6};
     quickSort(array,0,array.length-1);
     for(int i=0;i<array.length;i++){
    	 System.out.print(array[i]+" ");
     }
	}
	
	public static void quickSort(int []array,int low,int high){
//		int i,j;
//		i=low;
//		j=high;
//		int key =array[low];
//		
//		while(i<j){
//			while(i<j && array[j]>=key){ //j从右向左找第一个小于x的数
//				j--;
//			}
//			//    if(i<j)
//				array[i]=array[j];
//			
//			while(i<j && array[i]<key)//i 从左向右找大于x的数
//			{
//				i++;
//			}
//			//    if(i>j)
//				array[j]=array[i];
//				array[i]=key;
//		  }
//			
		  if(low>=high)
			  return ;
		    int mid =partion(array,low,high);
			quickSort(array,low,mid-1);
			quickSort(array,mid+1,high);
		
	}
	
	public static int partion(int[] arr, int low ,int high){
		int pivot = arr[low];
		int i=low;
		int j=high;
		while(i<j){
			while(i<j && arr[j]>=pivot){
				j--;
			}
			arr[i]=arr[j];
			while(i<j&& arr[i]<pivot){
				i++;
			}
			arr[j]=arr[i];
		}
		arr[i]=pivot;
		return i;
	}

}
