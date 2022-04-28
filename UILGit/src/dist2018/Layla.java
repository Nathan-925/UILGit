package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Layla {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("layla.dat"));
		while(scan.hasNext()) {
			double x = scan.nextDouble(), y = scan.nextDouble(), n = scan.nextDouble();
			double a = 0, b = 0, c = 0;
			switch(scan.next()) {
				case "A":
					a = n;
					b = a/x;
					c = b/y;
					break;
				case "B":
					b = n;
					a = b*x;
					c = b/y;
					break;
				case "C":
					c = n;
					b = c*y;
					a = b*x;
					break;
			}
			System.out.printf("A = %.3f%n", a);
			System.out.printf("B = %.3f%n", b);
			System.out.printf("C = %.3f%n", c);
			System.out.println("=====");
		}
	}
}
