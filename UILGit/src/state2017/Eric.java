package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eric {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("eric.dat"));
		while(scan.hasNext()) {
			int a = scan.nextInt(), b = scan.nextInt(), cnt = 2;
			int a1 = a, b1 = b;
			do {
				int temp = b1;
				b1 = (a1+b1)%10;
				a1 = temp;
				cnt++;
			} while(!(a1==a && b1==b));
			System.out.println(cnt);
		}
	}
}
