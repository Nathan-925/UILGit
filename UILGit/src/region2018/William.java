package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class William {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("william.dat"));
		while(scan.hasNext()) {
			String s = scan.next();
			String s1 = s.substring(0, s.length()/2), s2 = new StringBuilder(s.substring(s.length()/2)).reverse().toString();
			int[][] arr = genPath(new int[s1.length()+1][s2.length()+1], s1, s2, 0, 0);
			String out = "";
			int x = arr.length-1, y = arr[0].length-1;
			while(x > 0 && y > 0)
				if(s1.charAt(x-1) == s2.charAt(y-1)) {
					out += s1.charAt(--x);
					y--;
				}
				else if(arr[x-1][y] > arr[x][y-1])
					x -= 1;
				else
					y -= 1;
			System.out.println(new StringBuilder(out).reverse()+":"+out);
		}
	}
	
	public static int[][] genPath(int[][] arr, String s1, String s2, int n1, int n2) {
		if(n2 >= s2.length())
			return arr;
		if(s1.charAt(n1) == s2.charAt(n2))
			arr[n1+1][n2+1] = arr[n1][n2]+1;
		else if(arr[n1][n2+1] > arr[n1+1][n2])
			arr[n1+1][n2+1] = arr[n1][n2+1];
		else
			arr[n1+1][n2+1] = arr[n1+1][n2];
		return genPath(arr, s1, s2, (n1+1)%s1.length(), n2+n1/(s1.length()-1));
	}
}
