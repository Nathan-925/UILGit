package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Michal {
	
	static String[][] nums = {{" _ ", "| |", "|_|"},
							  {"   ", "  |", "  |"},
							  {" _ ", " _|", "|_ "},
							  {" _ ", " _|", " _|"},
							  {"   ", "|_|", "  |"},
							  {" _ ", "|_ ", " _|"},
							  {" _ ", "|_ ", "|_|"},
							  {" _ ", "  |", "  |"},
							  {" _ ", "|_|", "|_|"},
							  {" _ ", "|_|", "  |"}};
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("michal.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String s = scan.next();
			String border = "**";
			for(int j = 0; j < s.length(); j++)
				border += "***";
			
			System.out.println(border);
			for(int j = 0; j < 3; j++) {
				System.out.print("*");
				for(int l = 0; l < s.length(); l++)
					System.out.print(nums[s.charAt(l)-48][j]);
				System.out.println("*");
			}
			System.out.printf("*%"+(s.length()*3)+"s*%n", "");
			System.out.println(border);
		}
	}
}
