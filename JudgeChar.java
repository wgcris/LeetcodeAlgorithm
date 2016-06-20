package com.wgcris.LeetcodeAlgorithm;

import java.util.Stack;

/*
 * ¿®∫≈∆•≈‰
 */
public class JudgeChar {

	
	public static void judge(String str){
		Stack<Character>stack= new Stack<Character>();
		for(int i=0;i<str.length();i++){
			 char c1= str.charAt(i);
			 //œ»Ω´”ˆµΩµƒ∑˚∫≈—π’ª
			if(c1=='('||c1=='{'||c1=='[')
				stack.push(c1);
			else if(stack.peek()=='{'&& str.charAt(i)=='}'||stack.peek() == '(' && str.charAt(i) == ')'||stack.peek() == '[' && str.charAt(i) == ']')
		        stack.pop();
		}
		if(stack.isEmpty()){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  //  System.out.println(match("([aghfdlfdfd])"));
		String str="[(a{dafad}b)]";
      judge(str);
	}

}
