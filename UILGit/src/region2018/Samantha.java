package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Samantha {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("samantha.dat"));
		while(scan.hasNextLine()) {
			ArrayList<String> list = new ArrayList<>(Arrays.asList(scan.nextLine().split("\\s+")));
			double sub = list.stream().mapToDouble(Double::parseDouble).sum();
			System.out.printf("Subtotal: $%7.2f%n", sub);
			System.out.printf("Subtotal: $%7.2f%n", sub*0.0825);
			System.out.printf("Subtotal: $%7.2f%n", sub*1.0825);
			System.out.println("=====");
		}
	}
}
