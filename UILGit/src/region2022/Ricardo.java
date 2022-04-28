package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Ricardo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ricardo.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String s = scan.next();
			System.out.println("Case #"+(i+1)+": "+parse(s, 1, s.length()));
		}
	}
	
	public static long parse(String s, int start, int end) {
		LinkedList<Long> list = new LinkedList<>();
		long out = 1;
		boolean or = false;
		for(int i = start; i < end; i++) {
			if(s.charAt(i) == '|') {
				or = true;
				out++;
			}
			else if(s.charAt(i) == '(') {
				int n = i+1, open = 0;
				while(s.charAt(n) != ')' || open != 0) {
					if(s.charAt(n) == '(')
						open++;
					else if(s.charAt(n) == ')')
						open--;
					n++;
				}
				list.add(parse(s, i+1, n));
				i = n;
			}
		}
		for(long l: list)
			if(or)
				out += l-1;
			else
				out *= l;
		return out;
	}
}
