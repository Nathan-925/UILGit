package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manos {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("manos.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int t1 = scan.nextInt(), t2 = scan.nextInt();
			if(t1 == 0 || t2 == 0 || (t1+t2)%2!=0)
				System.out.println("P1");
			else
				System.out.println("P2");
		}
	}
}
