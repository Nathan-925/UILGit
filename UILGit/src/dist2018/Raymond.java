package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Raymond {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("raymond.dat"));
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			System.out.println(n+" "+~n);
		}
	}
}
