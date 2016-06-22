package com.wg.leetcode;
 

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Queue;  
import java.util.Stack;  
   
/** 
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888  ���ɸ㶨�����еĶ�������Ŀ 
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html  �㷨��ȫ��3�� ������ 
 *  
 * TODO: һ��Ҫ��������д����������ĵݹ�ͷǵݹ������� 
 * 
 * 1. ��������еĽڵ����: getNodeNumRec���ݹ飩��getNodeNum�������� 
 * 2. ������������: getDepthRec���ݹ飩��getDepth  
 * 3. ǰ�����������������������: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec 
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2) 
 * 4.�ֲ����������������δ������£��������ң�: levelTraversal, levelTraversalRec���ݹ�ⷨ���� 
 * 5. �������������Ϊ�����˫������: convertBST2DLLRec, convertBST2DLL 
 * 6. ���������K��Ľڵ������getNodeNumKthLevelRec, getNodeNumKthLevel 
 * 7. ���������Ҷ�ӽڵ�ĸ�����getNodeNumLeafRec, getNodeNumLeaf 
 * 8. �ж����ö������Ƿ���ͬ������isSameRec, isSame 
 * 9. �ж϶������ǲ���ƽ���������isAVLRec 
 * 10. ��������ľ����ƻ��Ͳ��ƻ�ԭ�����������������mirrorRec, mirrorCopyRec 
 * 10.1 �ж��������Ƿ��ྵ��isMirrorRec 
 * 11. ��������������ڵ����͹������Ƚڵ㣺getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2 
 * 12. ��������нڵ�������룺getMaxDistanceRec 
 * 13. ��ǰ��������к�������������ؽ���������rebuildBinaryTreeRec 
 * 14.�ж϶������ǲ�����ȫ��������isCompleteBinaryTree, isCompleteBinaryTreeRec 
 *  
 */ 
public class BinaryTreeDemo {  
   
    /* 
                 1  
                / \  
               2   3  
              / \   \  
             4  5   6  
     */ 
    public static void main(String[] args) {  
        TreeNode r1 = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);  
           
        r1.left = r2;  
        r1.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;  
           
//      System.out.println(getNodeNumRec(r1));  
//      System.out.println(getNodeNum(r1));  
//      System.out.println(getDepthRec(r1));  
//      System.out.println(getDepth(r1));  
           
//      preorderTraversalRec(r1);  
//      System.out.println();  
//      preorderTraversal(r1);  
//      System.out.println();  
//      inorderTraversalRec(r1);  
//      System.out.println();  
//      inorderTraversal(r1);  
//      System.out.println();  
//      postorderTraversalRec(r1);  
//      System.out.println();  
//      postorderTraversal(r1);  
//      System.out.println();  
//      levelTraversal(r1);  
//      System.out.println();  
//      levelTraversalRec(r1);  
//      System.out.println();  
           
//      TreeNode tmp = convertBSTRec(r1);  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.right == null){  
//              break;  
//          }  
//          tmp = tmp.right;  
//      }  
//      System.out.println();  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.left == null){  
//              break;  
//          }  
//          tmp = tmp.left;  
//      }  
           
           
//      TreeNode tmp = convertBST2DLL(r1);  
//      while(true){  
//          if(tmp == null){  
//              break;  
//          }  
//          System.out.print(tmp.val + " ");  
//          if(tmp.right == null){  
//              break;  
//          }  
//          tmp = tmp.right;  
//      }  
           
//      System.out.println(getNodeNumKthLevelRec(r1, 2));  
//      System.out.println(getNodeNumKthLevel(r1, 2));  
           
//      System.out.println(getNodeNumLeafRec(r1));  
//      System.out.println(getNodeNumLeaf(r1));  
           
//      System.out.println(isSame(r1, r1));  
//      inorderTraversal(r1);  
//      System.out.println();  
//      mirror(r1);  
//      TreeNode mirrorRoot = mirrorCopy(r1);  
//      inorderTraversal(mirrorRoot);  
           
        System.out.println(isCompleteBinaryTree(r1));  
        System.out.println(isCompleteBinaryTreeRec(r1));  
           
    }  
   
    private static class TreeNode {  
        int val;  
        TreeNode left;  
        TreeNode right;  
   
        public TreeNode(int val) {  
            this.val = val;  
        }  
    }  
   
    /** 
     * ��������еĽڵ�����ݹ�ⷨ�� O(n) 
     * ��1�����������Ϊ�գ��ڵ����Ϊ0  
     * ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� + 
     *            �������ڵ���� + 1 
     */ 
    public static int getNodeNumRec(TreeNode root) {  
        if (root == null) {  
            return 0;  
        } else {  
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;  
        }  
    }  
    
   
    
    /** 
     *  ��������еĽڵ���������ⷨO(n)������˼��ͬLevelOrderTraversal�� 
     *  ����һ��Queue����Java���������LinkedList��ģ��  
     */ 
    public static int getNodeNum(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        int count = 1;  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        while(!queue.isEmpty()){  
            TreeNode cur = queue.remove();      // �Ӷ�ͷλ���Ƴ�  
            if(cur.left != null){           // ��������ӣ��ӵ���β  
                queue.add(cur.left);  
                count++;  
            }  
            if(cur.right != null){      // ������Һ��ӣ��ӵ���β  
                queue.add(cur.right);  
                count++;  
            }  
        }  
           
        return count;  
    }  
   
    /** 
     * �����������ȣ��߶ȣ� �ݹ�ⷨ�� O(n) 
     * ��1�����������Ϊ�գ������������Ϊ0  
     * ��2�������������Ϊ�գ������������ = max(��������ȣ� ���������) + 1 
     */ 
    public static int getDepthRec(TreeNode root) {  
        if (root == null) {  
            return 0;  
        }  
   
        int leftDepth = getDepthRec(root.left);  
        int rightDepth = getDepthRec(root.right);  
        return Math.max(leftDepth, rightDepth) + 1;  
    }  
   
    /** 
     * �����������ȣ��߶ȣ� �����ⷨ�� O(n) 
     * ����˼��ͬLevelOrderTraversal��������һ��Queue 
     */ 
    public static int getDepth(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
           
        int depth = 0;                          // ���  
        int currentLevelNodes = 1;      // ��ǰLevel��node������  
        int nextLevelNodes = 0;         // ��һ��Level��node������  
           
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // �Ӷ�ͷλ���Ƴ�  
            currentLevelNodes--;            // ���ٵ�ǰLevel node������  
            if(cur.left != null){               // ��������ӣ��ӵ���β  
                queue.add(cur.left);  
                nextLevelNodes++;           // ��������һ��Level node������  
            }  
            if(cur.right != null){          // ������Һ��ӣ��ӵ���β  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
               
            if(currentLevelNodes == 0){ // ˵���Ѿ������굱ǰ������нڵ�  
                depth++;                       // ���Ӹ߶�  
                currentLevelNodes = nextLevelNodes;     // ��ʼ����һ��ı���  
                nextLevelNodes = 0;  
            }  
        }  
           
        return depth;  
    }  
      
 
    /** 
     * ǰ����������������������� ǰ������ݹ�ⷨ��  
     * ��1�����������Ϊ�գ��ղ���  
     * ��2�������������Ϊ�գ����ʸ��ڵ㣬ǰ�������������ǰ����������� 
     */ 
    public static void preorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        System.out.print(root.val + " ");  
        preorderTraversalRec(root.left);  
        preorderTraversalRec(root.right);  
    }  
       
    /** 
     *  ǰ����������ⷨ����һ������stack�����ǰ��Һ��ӷŽ�ջ 
     *  http://www.youtube.com/watch?v=uPTCbdHSFg4 
     */ 
    public static void preorderTraversal(TreeNode root) {  
        if(root == null){  
            return;  
        }  
           
        Stack<TreeNode> stack = new Stack<TreeNode>();      // ����stack  
        stack.push(root);  
           
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();     // ��ջջ��Ԫ��  
            System.out.print(cur.val + " ");  
               
            // �ؼ��㣺Ҫ��ѹ���Һ��ӣ���ѹ�����ӣ������ڳ�ջʱ���ȴ�ӡ�����ٴ�ӡ�Һ���  
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
   
    /** 
     * ��������ݹ�ⷨ  
     * ��1�����������Ϊ�գ��ղ�����  
     * ��2�������������Ϊ�գ�������������������ʸ��ڵ㣬������������� 
     */ 
    public static void inorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        inorderTraversalRec(root.left);  
        System.out.print(root.val + " ");  
        inorderTraversalRec(root.right);  
    }  
       
    /** 
     * ������������ⷨ ����ջ�ȰѸ��ڵ���������Ӷ���ӵ�ջ�ڣ� 
     * Ȼ�����ջ��Ԫ�أ��ٴ���ջ��Ԫ�ص������� 
     * http://www.youtube.com/watch?v=50v1sJkjxoc 
     *  
     * ����һ�ַ����ܲ��õݹ��ջ�����������������ķ��������鷳�Ժ��� 
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/ 
     */ 
    public static void inorderTraversal(TreeNode root){  
        if(root == null){  
            return;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;  
           
        while( true ){  
            while(cur != null){     // �����һ���ǿսڵ����е����ӵ�ջ  
                stack.push(cur);  
                cur = cur.left;  
            }  
               
            if(stack.isEmpty()){  
                break;  
            }  
                   
            // ��Ϊ��ʱ�Ѿ�û�������ˣ��������ջ��Ԫ��  
            cur = stack.pop();  
            System.out.print(cur.val + " ");  
            cur = cur.right;    // ׼������������  
        }  
    }  
   
    /** 
     * ��������ݹ�ⷨ  
     * ��1�����������Ϊ�գ��ղ���  
     * ��2�������������Ϊ�գ����������������������������������ʸ��ڵ� 
     */ 
    public static void postorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        postorderTraversalRec(root.left);  
        postorderTraversalRec(root.right);  
        System.out.print(root.val + " ");  
    }  
       
    /** 
     *  ������������ⷨ 
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU 
     *   
     */ 
    public static void postorderTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
           
        Stack<TreeNode> s = new Stack<TreeNode>();      // ��һ��stack�������node���������Һ���  
        Stack<TreeNode> output = new Stack<TreeNode>();// �ڶ���stack���ڷ�ת��һ��stack���  
           
        s.push(root);  
        while( !s.isEmpty() ){      // ȷ������Ԫ�ض�����תת�Ƶ��ڶ���stack  
            TreeNode cur = s.pop(); // ��ջ��Ԫ����ӵ��ڶ���stack  
            output.push(cur);         
               
            if(cur.left != null){       // ��ջ��Ԫ�ص����Ӻ��Һ��ӷֱ�������һ��stack  
                s.push(cur.left);  
            }  
            if(cur.right != null){  
                s.push(cur.right);  
            }  
        }  
           
        while( !output.isEmpty() ){ // ��������ڶ���stack����Ϊ�������  
            System.out.print(output.pop().val + " ");  
        }  
    }  
   

    /** 
     * �ֲ����������������δ������£��������ң����� 
     * �൱�ڹ������������ʹ�ö���ʵ�֡����г�ʼ���������ڵ�ѹ����С������в�Ϊ�գ��������²���������һ���ڵ� 
     * �����ʣ������ӽڵ�����ӽڵ㲻Ϊ�գ�����ѹ����� 
     */ 
    public static void levelTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.push(root);  
   
        while (!queue.isEmpty()) {  
            TreeNode cur = queue.removeFirst();  
            System.out.print(cur.val + " ");  
            if (cur.left != null) {  
                queue.add(cur.left);  
            }  
            if (cur.right != null) {  
                queue.add(cur.right);  
            }  
        }  
    }  
       
    /** 
     *  �ֲ�������������ݹ飩 
     *  �������˻��õݹ�ȥ��level traversal 
     *  ����˼������һ�����ArrayList�����������ÿһ���ArrayList�� 
     *  ���ArrayList��size��level�й�ϵ 
     *   
     *  ������Ŀǰ��������õĵݹ�ⷨ�� 
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543 
     */ 
    public static void levelTraversalRec(TreeNode root) {  
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();  
        dfs(root, 0, ret);  
        System.out.println(ret);  
    }  
       
    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret){  
        if(root == null){  
            return;  
        }  
           
        // ���һ���µ�ArrayList��ʾ�µ�һ��  
        if(level >= ret.size()){  
            ret.add(new ArrayList<Integer>());  
        }  
           
        ret.get(level).add(root.val);   // �ѽڵ���ӵ���ʾ��һ���ArrayList��  
        dfs(root.left, level+1, ret);       // �ݹ鴦����һ�����������������  
        dfs(root.right, level+1, ret);  
    }  
       
   
    /** 
     * �������������Ϊ�����˫������ Ҫ���ܴ����½ڵ㣬ֻ����ָ�롣  
     * �ݹ�ⷨ�� 
     * �ο���http://stackoverflow.com/questions/11511898/converting-a-binary-search-tree-to-doubly-linked-list#answer-11530016 
     * �о����������ĵݹ�ⷨ����Ҫע��ݹ��꣬root����������м�λ�ã����Ҫ�ֶ� 
     * ��root�Ƶ�����ͷ������β 
     */ 
    public static TreeNode convertBST2DLLRec(TreeNode root) {  
        root = convertBST2DLLSubRec(root);  
           
        // root����������м�λ�ã����Ҫ�ֶ���root�Ƶ�����ͷ  
        while(root.left != null){  
            root = root.left;  
        }  
        return root;  
    }  
       
    /** 
     *  �ݹ�ת��BSTΪ˫������(DLL) 
     */ 
    public static TreeNode convertBST2DLLSubRec(TreeNode root){  
        if(root==null || (root.left==null && root.right==null)){  
            return root;  
        }  
           
        TreeNode tmp = null;  
        if(root.left != null){          // ����������  
            tmp = convertBST2DLLSubRec(root.left);  
            while(tmp.right != null){   // Ѱ�����ҽڵ�  
                tmp = tmp.right;  
            }  
            tmp.right = root;       // �����������������root����  
            root.left = tmp;  
        }  
        if(root.right != null){     // ����������  
            tmp = convertBST2DLLSubRec(root.right);  
            while(tmp.left != null){    // Ѱ������ڵ�  
                tmp = tmp.left;  
            }  
            tmp.left = root;        // �����������������root����  
            root.right = tmp;  
        }  
        return root;  
    }  
    
    /** 
     * �������������Ϊ�����˫������ �����ⷨ 
//   * ����inorder traversal������ 
     */ 
    public static TreeNode convertBST2DLL(TreeNode root) {  
        if(root == null){  
            return null;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;        // ָ��ǰ����ڵ�  
        TreeNode old = null;            // ָ��ǰһ������Ľڵ�  
        TreeNode head = null;       // ����ͷ  
           
        while( true ){  
            while(cur != null){     // �����һ���ǿսڵ����е����ӵ�ջ  
                stack.push(cur);  
                cur = cur.left;  
            }  
               
            if(stack.isEmpty()){  
                break;  
            }  
                   
            // ��Ϊ��ʱ�Ѿ�û�������ˣ��������ջ��Ԫ��  
            cur = stack.pop();  
            if(old != null){  
                old.right = cur;  
            }  
            if(head == null){       // /��һ���ڵ�Ϊ˫������ͷ�ڵ�  
                head = cur;  
            }  
               
            old = cur;          // ����old  
            cur = cur.right;    // ׼������������  
        }  
           
        return head;  
    }  
   
   
    /** 
     * ���������K��Ľڵ����   �ݹ�ⷨ��  
     * ��1�����������Ϊ�ջ���k<1����0 
     * ��2�������������Ϊ�ղ���k==1������1 
     * ��3�������������Ϊ����k>1������root��������k-1��Ľڵ������root������k-1��ڵ����֮�� 
     *  
     * ����rootΪ����k��ڵ���Ŀ �ȼ��� ����root����Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ ���� 
     * ��root�Һ���Ϊ����k-1�㣨��Ϊ����root��һ�㣩�ڵ���Ŀ 
     *  
     * �������������Ȱ���������������������������⽵�� 
     *  
     */ 
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {  
        if (root == null || k < 1) {  
            return 0;  
        }  
   
        if (k == 1) {  
            return 1;  
        }  
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);      // ��root��������k-1��ڵ���  
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);    // ��root��������k-1��ڵ���  
        return numLeft + numRight;  
    }  
       
    /** 
     *  ���������K��Ľڵ����   �����ⷨ��  
     *  ͬgetDepth�ĵ����ⷨ 
     */ 
    public static int getNodeNumKthLevel(TreeNode root, int k){  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        int i = 1;  
        int currentLevelNodes = 1;      // ��ǰLevel��node������  
        int nextLevelNodes = 0;         // ��һ��Level��node������  
           
        while( !queue.isEmpty() && i<k){  
            TreeNode cur = queue.remove();      // �Ӷ�ͷλ���Ƴ�  
            currentLevelNodes--;            // ���ٵ�ǰLevel node������  
            if(cur.left != null){               // ��������ӣ��ӵ���β  
                queue.add(cur.left);  
                nextLevelNodes++;           // ��������һ��Level node������  
            }  
            if(cur.right != null){          // ������Һ��ӣ��ӵ���β  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
               
            if(currentLevelNodes == 0){ // ˵���Ѿ������굱ǰ������нڵ�  
                currentLevelNodes = nextLevelNodes;     // ��ʼ����һ��ı���  
                nextLevelNodes = 0;  
                i++;            // ���뵽��һ��  
            }  
        }  
           
        return currentLevelNodes;  
    }  
   
    /** 
     * ���������Ҷ�ӽڵ�ĸ������ݹ飩 
     */ 
    public static int getNodeNumLeafRec(TreeNode root) {  
        // ��root�����ڣ����ؿ�  
        if (root == null) {  
            return 0;  
        }  
   
        // ��ΪҶ�ӽڵ�ʱ����1  
        if (root.left == null && root.right == null) {  
            return 1;  
        }  
   
        // ��һ���������������������֮�ͣ�ԭ��ͬ��һ��  
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);  
    }  
       
    /** 
     *  ���������Ҷ�ӽڵ�ĸ����������� 
     *  ���ǻ���Level order traversal 
     */ 
    public static int getNodeNumLeaf(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
           
        int leafNodes = 0;              // ��¼��һ��Level��node������  
           
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // �Ӷ�ͷλ���Ƴ�  
            if(cur.left != null){               // ��������ӣ��ӵ���β  
                queue.add(cur.left);  
            }  
            if(cur.right != null){              // ������Һ��ӣ��ӵ���β  
                queue.add(cur.right);  
            }  
            if(cur.left==null && cur.right==null){          // Ҷ�ӽڵ�  
                leafNodes++;  
            }  
        }  
           
        return leafNodes;  
    }  
   
    /** 
     * �ж����ö������Ƿ���ͬ������ 
     * �ݹ�ⷨ��  
     * ��1��������ö�������Ϊ�գ������� 
     * ��2��������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ�  
     * ��3��������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ� 
     */ 
    public static boolean isSameRec(TreeNode r1, TreeNode r2) {  
        // ������ö�������Ϊ�գ�������  
        if (r1 == null && r2 == null) {  
            return true;  
        }  
        // ������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ�  
        else if (r1 == null || r2 == null) {  
            return false;  
        }  
   
        if(r1.val != r2.val){  
            return false;  
        }  
        boolean leftRes = isSameRec(r1.left, r2.left);      // �Ƚ϶�Ӧ������  
        boolean rightRes = isSameRec(r1.right, r2.right); // �Ƚ϶�Ӧ������  
        return leftRes && rightRes;  
    }  
       
    /** 
     * �ж����ö������Ƿ���ͬ������������ 
     * ����һ�鼴�ɣ�������preorder 
     */ 
    public static boolean isSame(TreeNode r1, TreeNode r2) {  
        // ������������ǿ������򷵻�true  
        if(r1==null && r2==null){  
            return true;  
        }  
           
        // �����һ�����ǿ�������һ�Ų��ǣ��򷵻�false  
        if(r1==null || r2==null){  
            return false;  
        }  
           
        Stack<TreeNode> s1 = new Stack<TreeNode>();  
        Stack<TreeNode> s2 = new Stack<TreeNode>();  
           
        s1.push(r1);  
        s2.push(r2);  
           
        while(!s1.isEmpty() && !s2.isEmpty()){  
            TreeNode n1 = s1.pop();  
            TreeNode n2 = s2.pop();  
            if(n1==null && n2==null){  
                continue;  
            }else if(n1!=null && n2!=null && n1.val==n2.val){  
                s1.push(n1.right);  
                s1.push(n1.left);  
                s2.push(n2.right);  
                s2.push(n2.left);  
            }else{  
                return false;  
            }  
        }  
        return true;  
    }  
   
    /** 
     * �ж϶������ǲ���ƽ������� �ݹ�ⷨ��  
     * ��1�����������Ϊ�գ������� 
     * ��2�������������Ϊ�գ����������������������AVL���������������������߶�������1�������棬�������ؼ� 
     */ 
    public static boolean isAVLRec(TreeNode root) {  
        if(root == null){           // ���������Ϊ�գ�������  
            return true;  
        }  
           
        // ������������������߶�������1�����ƽ�������, getDepthRec()��ǰ��ʵ�ֹ��������߶ȵķ���  
        if(Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1){  
            return false;  
        }  
           
        // �ݹ��ж����������������Ƿ�Ϊƽ�������  
        return isAVLRec(root.left) && isAVLRec(root.right);  
    }  
       
   
    /** 
     * ��������ľ��� �ݹ�ⷨ��  
     * ��1�����������Ϊ�գ����ؿ� 
     * ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻��������������� 
     */ 
    // 1. �ƻ�ԭ����������ԭ�������ĳ��侵��  
    public static TreeNode mirrorRec(TreeNode root) {  
        if (root == null) {  
            return null;  
        }  
   
        TreeNode left = mirrorRec(root.left);  
        TreeNode right = mirrorRec(root.right);  
   
        root.left = right;  
        root.right = left;  
        return root;  
    }  
       
    // 2. �����ƻ�ԭ������������һ���µľ�����  
    public static TreeNode mirrorCopyRec(TreeNode root){  
        if(root == null){  
            return null;  
        }  
           
        TreeNode newNode = new TreeNode(root.val);  
        newNode.left = mirrorCopyRec(root.right);  
        newNode.right = mirrorCopyRec(root.left);  
           
        return newNode;  
    }  
       
    // 3. �ж��������Ƿ��ྵ��  
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){  
        // ������������ǿ������򷵻�true  
        if(r1==null && r2==null){  
            return true;  
        }  
           
        // �����һ�����ǿ�������һ�Ų��ǣ��򷵻�false  
        if(r1==null || r2==null){  
            return false;  
        }  
           
        // ������������ǿ��������ȱȽϸ��ڵ�  
        if(r1.val != r2.val){  
            return false;  
        }  
           
        // �ݹ�Ƚ�r1���������ľ����ǲ���r2������ ��   
        // r1���������ľ����ǲ���r2������  
        return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);  
    }  
       
    // 1. �ƻ�ԭ����������ԭ�������ĳ��侵��  
    public static void mirror(TreeNode root) {  
        if(root == null){  
            return;  
        }  
           
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);  
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
               
            // �������Һ���  
            TreeNode tmp = cur.right;  
            cur.right = cur.left;  
            cur.left = tmp;  
               
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
       
    // 2. �����ƻ�ԭ������������һ���µľ�����  
    public static TreeNode mirrorCopy(TreeNode root){  
        if(root == null){  
            return null;  
        }  
           
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        Stack<TreeNode> newStack = new Stack<TreeNode>();  
        stack.push(root);  
        TreeNode newRoot = new TreeNode(root.val);  
        newStack.push(newRoot);  
           
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();  
            TreeNode newCur = newStack.pop();  
               
            if(cur.right != null){  
                stack.push(cur.right);  
                newCur.left = new TreeNode(cur.right.val);  
                newStack.push(newCur.left);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
                newCur.right = new TreeNode(cur.left.val);  
                newStack.push(newCur.right);  
            }  
        }  
           
        return newRoot;  
    }  
       
   
    /** 
     * ��������������ڵ����͹������Ƚڵ�  
     * �ݹ�ⷨ��  
     * ��1����������ڵ�ֱ��ڸ��ڵ�������������������򷵻ظ��ڵ� 
     * ��2����������ڵ㶼������������ݹ鴦������������������ڵ㶼������������ݹ鴦�������� 
     */ 
    public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {  
        if (findNodeRec(root.left, n1)) {               // ���n1������������  
            if (findNodeRec(root.right, n2)) {      // ���n2������������  
                return root;                                // ���ظ��ڵ�  
            } else {            // ���n2Ҳ������������  
                return getLastCommonParentRec(root.left, n1, n2); // �ݹ鴦��  
            }  
        } else {                // ���n1������������  
            if (findNodeRec(root.left, n2)) {           // ���n2��������  
                return root;  
            } else {                 // ���n2��������  
                return getLastCommonParentRec(root.right, n1, n2); // �ݹ鴦��  
            }  
        }  
    }  
   
    // �����������ݹ��ж�һ�����Ƿ�������  
    private static boolean findNodeRec(TreeNode root, TreeNode node) {  
        if (root == null || node == null) {  
            return false;  
        }  
        if (root == node) {  
            return true;  
        }  
   
        // �ȳ������������в���  
        boolean found = findNodeRec(root.left, node);  
        if (!found) {       // ������Ҳ����������������в���  
            found = findNodeRec(root.right, node);  
        }  
        return found;  
    }  
       
    // ��������������ڵ����͹������Ƚڵ� �����Ӽ���ĵݹ飩  
    public static TreeNode getLastCommonParentRec2(TreeNode root, TreeNode n1, TreeNode n2) {  
        if(root == null){  
            return null;  
        }  
           
        // �����һ��match����˵����ǰnode����Ҫ�ҵ���͹�������  
        if(root.equals(n1) || root.equals(n2)){  
            return root;  
        }  
        TreeNode commonInLeft = getLastCommonParentRec2(root.left, n1, n2);  
        TreeNode commonInRight = getLastCommonParentRec2(root.right, n1, n2);  
           
        // ���һ���������ҵ���һ�����������ҵ�����˵��root��Ψһ���ܵ���͹�������  
        if(commonInLeft!=null && commonInRight!=null){  
            return root;  
        }  
           
        // ���������Ҫ��Ȼ��������Ҫ��Ȼ��������  
        if(commonInLeft != null){  
            return commonInLeft;  
        }  
           
        return commonInRight;  
    }  
   
    /** 
     * �ǵݹ�ⷨ��  
     * ����Ӹ��ڵ㵽�����ڵ��·����Ȼ���ٱȽ϶�Ӧ·���Ľڵ���У����һ����ͬ�Ľڵ�Ҳ���������ڶ������е���͹������Ƚڵ� 
     */ 
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {  
        if (root == null || n1 == null || n2 == null) {  
            return null;  
        }  
   
        ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();  
        boolean res1 = getNodePath(root, n1, p1);  
        ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();  
        boolean res2 = getNodePath(root, n2, p2);  
   
        if (!res1 || !res2) {  
            return null;  
        }  
   
        TreeNode last = null;  
        Iterator<TreeNode> iter1 = p1.iterator();  
        Iterator<TreeNode> iter2 = p2.iterator();  
   
        while (iter1.hasNext() && iter2.hasNext()) {  
            TreeNode tmp1 = iter1.next();  
            TreeNode tmp2 = iter2.next();  
            if (tmp1 == tmp2) {  
                last = tmp1;  
            } else { // ֱ�������ǹ����ڵ�  
                break;  
            }  
        }  
        return last;  
    }  
   
    // �ѴӸ��ڵ㵽node·�������еĵ㶼��ӵ�path��  
    private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {  
        if (root == null) {  
            return false;  
        }  
           
        path.add(root);     // ������ڵ�ӵ�·����  
        if (root == node) {  
            return true;  
        }  
   
        boolean found = false;  
        found = getNodePath(root.left, node, path); // ��������������  
           
        if (!found) {               // ���û�ҵ���������������  
            found = getNodePath(root.right, node, path);  
        }  
        if (!found) {               // ���ʵ��û�ҵ�֤������ڵ㲻��·���У�˵���ղ���ӽ�ȥ�Ĳ���·���ϵĽڵ㣬ɾ����  
            path.remove(root);    
        }  
   
        return found;  
    }  
   
    /** 
     * ��������нڵ�������� ���������������Զ�������ڵ�֮��ľ��롣 (distance / diameter) 
     * �ݹ�ⷨ��  
     * ��1�����������Ϊ�գ�����0��ͬʱ��¼������������������ȣ���Ϊ0 
     * ��2�������������Ϊ�գ�������Ҫô���������е������룬Ҫô���������е������룬 
     * Ҫô���������ڵ��е����ڵ��������+�������ڵ��е����ڵ�������룬 
     * ͬʱ��¼���������������ڵ��е����ڵ�������롣 
     *  
     * http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html 
     *  
     * ����һ�������������������������: 
  
        ���A: ·������������������ڵ㣬ͨ�����ڵ㣬�ٵ�������������ڵ㡣 
        ���B: ·�����������ڵ㣬��������������������������·����ȡ����ߡ� 
        ֻ��Ҫ���������������·�����룬��ȡ����ߣ����Ǹö������������� 
     */ 
    public static Result getMaxDistanceRec(TreeNode root){  
        if(root == null){  
            Result empty = new Result(0, -1);       // Ŀ�����õ��÷� +1 �󣬰ѵ�ǰ�Ĳ����ڵ� (NULL) ��������������Ϊ 0  
            return empty;  
        }  
           
        // ��������������ֱ�������  
        Result lmd = getMaxDistanceRec(root.left);  
        Result rmd = getMaxDistanceRec(root.right);  
           
        Result res = new Result();  
        res.maxDepth = Math.max(lmd.maxDepth, rmd.maxDepth) + 1;        // ��ǰ������  
        // ȡ���A�����B�нϴ�ֵ  
        res.maxDistance = Math.max( lmd.maxDepth+rmd.maxDepth, Math.max(lmd.maxDistance, rmd.maxDistance) );  
        return res;  
    }  
       
    private static class Result{  
        int maxDistance;  
        int maxDepth;  
        public Result() {  
        }  
   
        public Result(int maxDistance, int maxDepth) {  
            this.maxDistance = maxDistance;  
            this.maxDepth = maxDepth;  
        }  
    }  
       
    /** 
     * 13. ��ǰ��������к�������������ؽ����������ݹ飩 
     * �о���ƪ�ǽ�����Ϊ������: 
     * http://crackinterviewtoday.wordpress.com/2010/03/15/rebuild-a-binary-tree-from-inorder-and-preorder-traversals/ 
     * ���л��ᵽһ�ֱ��⿪����ռ�ķ��������´β��� 
     */ 
    public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){  
        TreeNode root = null;  
        List<Integer> leftPreOrder;  
        List<Integer> rightPreOrder;  
        List<Integer> leftInorder;  
        List<Integer> rightInorder;  
        int inorderPos;  
        int preorderPos;  
    
        if ((preOrder.size() != 0) && (inOrder.size() != 0))  
        {  
            // ��preorder�ĵ�һ��Ԫ����Ϊroot  
            root = new TreeNode(preOrder.get(0));  
    
            //  Based upon the current node data seperate the traversals into leftPreorder, rightPreorder,  
            //  leftInorder, rightInorder lists  
            // ��Ϊ֪��root�ڵ��ˣ����Ը���root�ڵ�λ�ã���preorder��inorder�ֱ𻮷�Ϊ root��� �� �Ҳ� ������������  
            inorderPos = inOrder.indexOf(preOrder.get(0));      // inorder���еķָ��  
            leftInorder = inOrder.subList(0, inorderPos);  
            rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());  
    
            preorderPos = leftInorder.size();                           // preorder���еķָ��  
            leftPreOrder = preOrder.subList(1, preorderPos + 1);  
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());  
    
            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInorder);        // root������������preorder��inorder�����������γɵ���  
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInorder); // root������������preorder��inorder���Ҳ�������γɵ���  
        }  
    
        return root;  
    }  
       
    /** 
        14.  �ж϶������ǲ�����ȫ�������������� 
        ��������������Ϊh������ h ���⣬�������� (1��h-1) �Ľ�������ﵽ�������� 
        �� h �����еĽ�㶼��������������ߣ��������ȫ�������� 
        �������㷨������Σ����ϵ��£������ң�������������������һ���ڵ��������Ϊ��ʱ�� 
        ��ýڵ�����������Ϊ�գ��Һ�������Ľڵ���������������Ϊ�գ���������ȫ�������� 
     */ 
    public static boolean isCompleteBinaryTree(TreeNode root){  
        if(root == null){  
            return false;  
        }  
           
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
        boolean mustHaveNoChild = false;  
        boolean result = true;  
           
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();  
            if(mustHaveNoChild){    // �Ѿ��������п������Ľڵ��ˣ�������ֵı���ΪҶ�ڵ㣨����������Ϊ�գ�    
                if(cur.left!=null || cur.right!=null){  
                    result = false;  
                    break;  
                }  
            } else {  
                if(cur.left!=null && cur.right!=null){      // ��������������������ǿգ����������  
                    queue.add(cur.left);  
                    queue.add(cur.right);  
                }else if(cur.left!=null && cur.right==null){    // ����������ǿյ�������Ϊ�գ�˵���Ѿ����ֿսڵ㣬֮����붼Ϊ������  
                    mustHaveNoChild = true;  
                    queue.add(cur.left);  
                }else if(cur.left==null && cur.right!=null){    // ���������Ϊ�յ��������ǿգ�˵��������Ѿ�������ȫ������ȫ����  
                    result = false;  
                    break;  
                }else{          // �������������Ϊ�գ������ı���Ҳ��Ϊ������  
                    mustHaveNoChild = true;  
                }  
            }  
        }  
        return result;  
    }  
       
    /** 
     * 14.  �ж϶������ǲ�����ȫ���������ݹ飩 
     * http://stackoverflow.com/questions/1442674/how-to-determine-whether-a-binary-tree-is-complete 
     *  
     */ 
    public static boolean isCompleteBinaryTreeRec(TreeNode root){  
//      Pair notComplete = new Pair(-1, false);  
//      return !isCompleteBinaryTreeSubRec(root).equalsTo(notComplete);  
        return isCompleteBinaryTreeSubRec(root).height != -1;  
    }  
       
    // �ݹ��ж��Ƿ�������������  
    public static boolean isPerfectBinaryTreeRec(TreeNode root){  
        return isCompleteBinaryTreeSubRec(root).isFull;  
    }  
       
    // �ݹ飬Ҫ����һ��Pair class���������ĸ߶Ⱥ��Ƿ���������Ϣ  
    public static Pair isCompleteBinaryTreeSubRec(TreeNode root){  
        if(root == null){  
            return new Pair(0, true);  
        }  
           
        Pair left = isCompleteBinaryTreeSubRec(root.left);  
        Pair right = isCompleteBinaryTreeSubRec(root.right);  
           
        // �������ڵ㣬������������ͬ�߶ȣ�����Ψһ�����γ�������������Ҳ�����ڵ㣩�����  
        if(left.isFull && left.height==right.height){  
            return new Pair(1+left.height, right.isFull);  
        }  
           
        // ���������������������ڵ㣬�������߶ȱ�������һ  
        // ע�⵽���������Ϊ����ȫ���������ĸ߶��Ѿ������ó�-1��  
        // ��˲���������ڶ���������  
        if(right.isFull && left.height==right.height+1){  
            return new Pair(1+left.height, false);  
        }  
           
        // ����������Ƿ���ȫ����ֱ�����ø߶�Ϊ-1  
        return new Pair(-1, false);  
    }  
       
    private static class Pair{  
        int height;             // ���ĸ߶�  
        boolean isFull;     // �Ƿ��Ǹ�����  
   
        public Pair(int height, boolean isFull) {  
            this.height = height;  
            this.isFull = isFull;  
        }  
   
        public boolean equalsTo(Pair obj){  
            return this.height==obj.height && this.isFull==obj.isFull;  
        }  
    }  
       
}  
