package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paola {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("paola.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int let = scan.next().charAt(0)-'A', levels = scan.nextInt();
			for(int j = 0; j < levels; j++) {
				String s = "";
				for(int l = 0; l <= j; l++) {
					s += (char)(let+'A');
					let = (let+1)%26;
				}
				System.out.printf("%"+levels+"s%n", s);
			}
		}
	}
}
