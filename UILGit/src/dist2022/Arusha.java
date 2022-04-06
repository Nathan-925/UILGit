package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arusha {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("arusha.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String s = scan.next();
			String ins = scan.next();
			for(char c: ins.toCharArray())
				if(c == 'L')
					s = s.substring(1)+s.charAt(0);
				else
					s = s.charAt(s.length()-1)+s.substring(0, s.length()-1);
			System.out.println(s);
		}
	}
}
