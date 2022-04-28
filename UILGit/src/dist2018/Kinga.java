package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kinga {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("kinga.dat"));
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			
			System.out.print("  ");
			for(char c = 'A'; c < 'A'+n; c++) {
				System.out.print(c);
				if(c < 'A'+n-1)
					System.out.print("|");
			}
			System.out.println();
			
			for(int i = 0; i < Math.pow(2, n); i++) {
				String s = Integer.toString(i, 2);
				while(s.length() < n)
					s = "0"+s;
				System.out.print((i+1)+" ");
				for(int j = 0; j < n; j++) {
					System.out.print(s.charAt(j));
					if(j < n-1)
						System.out.print("|");
				}
				System.out.println();
			}
			System.out.println("=====");
		}
	}
}
