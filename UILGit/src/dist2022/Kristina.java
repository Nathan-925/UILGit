package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Kristina {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("kristina.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String fix = scan.next();
			String arr[] = scan.nextLine().trim().split("\\s+");
			
			if(fix.equals("PRE")) {
				Node root = new Node(arr[0].charAt(0));
				for(int j = 1; j < arr.length; j++) {
					Node n;
					try {
						n = new Node(Integer.parseInt(arr[j]));
					}
					catch(NumberFormatException e) {
						n = new Node(arr[j].charAt(0));
					}
					root.add(n);
				}
				System.out.println(root.solve());
			}
			else {
				Stack<Integer> nums = new Stack<>();
				for(String s: arr) {
					try {
						nums.push(Integer.parseInt(s));
					}
					catch(NumberFormatException e) {
						nums.push(op(s.charAt(0), nums.pop(), nums.pop()));
					}
				}
				System.out.println(nums.pop());
			}
			
			
		}
	}
	
	public static int op(char op, int a, int b) {
		switch(op) {
			case '+':
				return a+b;
			case '-':
				return b-a;
			case '*':
				return a*b;
			case '/':
				return b/a;
			case '^':
				return (int)Math.pow(b, a);
			default:
				return a;
		}
	}
	
}

class Node{
	char op;
	int num;
	boolean solved;
	Node left, right;
	
	public Node(char op) {
		this.op = op;
	}
	
	public Node(int num) {
		this.num = num;
		solved = true;
	}
	
	public int solve() {
		if(solved)
			return num;
		return Kristina.op(op, left.solve(), right.solve());
	}
	
	public boolean add(Node n) {
		if(solved)
			return false;
		if(right == null) {
			right = n;
			return true;
		}
		if(right.add(n))
			return true;
		if(left == null) {
			left = n;
			return true;
		}
		return left.add(n);
	}
}
