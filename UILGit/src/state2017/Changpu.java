package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Changpu {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("changpu.dat"));
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			if(n%2==0)
				System.out.println(n+" "+~n);
			else
				System.out.println(n+" "+-n);
		}
	}
}
