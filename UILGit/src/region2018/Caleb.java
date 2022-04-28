package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Caleb {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("caleb.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String arr[] = scan.next().split("/");
			if(arr[0].equals("0"))
				arr[0] = "360";
			System.out.printf("%d:%02d%n", Integer.parseInt(arr[0])/30, Integer.parseInt(arr[1])/6);
		}
	}
}
