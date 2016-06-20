package com.wgcris.LeetcodeAlgorithm;
/*
 * Լɪ�����⣺��n��С����Χ��һ��Ȧ��Ȼ������1-3��������3���˳���Ȧ�����������������һ���˵ı�š�
 * 
 */
public class Joseph {
    private static LinkNode root;
    /**
     * ������������
     * @param n
     */
    public static void createList(int n){
    	LinkNode temp=null;
    	for(int i=1;i<=n;i++){
    		if(i==1)
    		{
    			LinkNode node=new LinkNode(i);
    			temp=node;
    			root=node;
    		}
    		else{
    			if(i==n){
        			LinkNode node=new LinkNode(i);
        			temp.next=node;
        			temp=node;
        			temp.next=root;
        			
        		}
        		else{
        			LinkNode node=new LinkNode(i);
        			temp.next=node;
        			temp=node;
        			
        		}
    		}
    	    
    	}
    }
    
    public static void printList(LinkNode root){
    	if(root==null)
    		return;
    	LinkNode temp= root;
    	do{
    		System.out.print(temp.data+" ");
    		temp=temp.next;
    	}while(temp!=root);
    }
    
    
    public static void play(int n){
    	LinkNode temp = root;
   
    	while(n!=1){
    		//��3��
    		for(int j=1;j<3;j++){
    			temp=temp.next;
    		}
    		//�ҵ���Ȧ��ǰһ���ڵ�
    		LinkNode temp2=temp;
    		while(temp2.next!=temp){
    			temp2=temp2.next;
    		}
    		//Ȼ��ɾ����Ȧ�ڵ�
    		temp2.next=temp.next;
    		temp=temp.next;
    		n--;
    	}
    	System.out.println(temp.data);
    }
    //�������
	public static void insert(int n){
		if(root==null){
			root= new LinkNode(n);
		   
		}
		else{
			LinkNode node = root;
			while(node.next!=null){
				node=node.next;
			}
			node.next=new LinkNode(n);
			
		}
		
	
	}
		
	public static void rep(boolean[] people){
		int i=0;
		int j=0;
		int n=people.length;
		int m=n;
		while(n>2){
			i=++i%m;
			if(people[i]==true){
				j++;
				if(j==3){
					people[i]=false;
				//	System.out.println(i);
					n--;
					j=0;
				}
			}		
		}
		
		for(int k=0;k<people.length;k++){
			System.out.print(people[k]+" ");
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//        boolean people[] = new boolean[10];
//        for(int i = 0; i<10; i++){
//            people[i] = true;
//        }
//        rep(people);
		createList(10);
		//System.out.println(root.next.data);
		play(10);
	//	printList(root);
//		
	}

}
class LinkNode{
	int data;	
	LinkNode next;
	public LinkNode(int data){
		this.data=data;
	}
}