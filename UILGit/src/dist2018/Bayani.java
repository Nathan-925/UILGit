package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bayani {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("bayani.dat"));
		double total = 0;
		while(scan.hasNextDouble()) {
			double d = scan.nextDouble();
			System.out.printf("        $%7.2f%n", d);
			total += d;
		}
		System.out.printf("Total = $%7.2f%n", total);
	}
}
