package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Konstantinos {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("konstantinos.dat"));
		
		while(scan.hasNextInt()) {
			int x1 = scan.nextInt(), y1 = scan.nextInt();
			int r1 = scan.nextInt();
			int x2 = scan.nextInt(), y2 = scan.nextInt();
			int r2 = scan.nextInt();
			
			double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			
			if(d > r1+r2)
				System.out.println("NON-INTERSECTING");
			else if(d == r1+r2)
				System.out.println("EXTERNALLY TANGENT");
			else if(r1 == d+r2)
				System.out.println("INTERNALLY TANGENT");
			else if(r1 > d+r2)
				System.out.println("NESTED");
			else
				System.out.println("INTERSECTING");
		}
	}
}
