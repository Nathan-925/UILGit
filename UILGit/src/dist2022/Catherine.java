package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catherine {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("catherine.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String target = scan.next(), guess = scan.next();
			for(int j = 0; j < target.length(); j++)
				if(guess.charAt(j) == target.charAt(j))
					System.out.print((char)(guess.charAt(j)-32));
				else if(target.contains(guess.charAt(j)+""))
					System.out.print(guess.charAt(j));
				else
					System.out.print("*");
			System.out.println();
		}
	}
}
