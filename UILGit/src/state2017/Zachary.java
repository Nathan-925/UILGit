package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zachary {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("zachary.dat"));
		while(scan.hasNext()) {
			int a = scan.nextInt(), b = scan.nextInt();
			for(int i = 1; i <= a; i++) {
				for(int j = 1; j <= b; j++)
					System.out.print((i*j)%10);
				System.out.println();
			}
		}
	}
}
