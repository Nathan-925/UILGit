package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Debra {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("debra.dat"));
		while(scan.hasNext()) {
			int lines = scan.nextInt();
			scan.nextLine();
			for(int i = 0; i < lines; i++)
				System.out.println(new StringBuffer(scan.nextLine()).reverse());
			System.out.println("=====");
		}
	}
}
