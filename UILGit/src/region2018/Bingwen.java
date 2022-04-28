package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bingwen {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("bingwen.dat"));
		while(scan.hasNextInt())
			System.out.printf("%.2f%n", Math.cbrt(scan.nextInt()));
	}
}
