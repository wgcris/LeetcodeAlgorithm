package com.wgcris.LeetcodeAlgorithm;

public class MergeSort {  
    
	   //先递归分解 再合并序列
	   public void mergeSort(int[] a,int first,int last,int temp[])
			{
				if(first<last)
				{
					int mid=(first+last)/2;
					mergeSort(a,first,mid,temp);
					mergeSort(a,mid+1,last,temp);
					mergearray(a,first,mid,last,temp);
				}	
			}
	    public void mergearray(int a[], int first, int mid, int last, int temp[])  
	    {  
	        int i = first, j = mid + 1;  
	        int m = mid,   n = last;  
	        int k = 0;  
	          
	        while (i <= m && j <= n)  
	        {  
	            if (a[i] <= a[j])  
	                temp[k++] = a[i++];  
	            else  
	                temp[k++] = a[j++];  
	        }  
	          
	        while (i <= m)  
	            temp[k++] = a[i++];  
	          
	        while (j <= n)  
	            temp[k++] = a[j++];  
	          
	        for (i = 0; i < k; i++)  
	            a[first + i] = temp[i];  
	    }  



	public static void main(String[] args) {
		MergeSort m=new MergeSort();
		int[] a={5,4,8,1,2,3,4,5,7,6,4,1,5};
		int[] temp=new int[a.length];
		m.mergeSort(a, 0, a.length-1, temp);
		for(int i:a)
			System.out.print(i+" ");
	}
}