package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rohan {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("rohan.dat"));
		while(scan.hasNextInt()) {
			int xa = scan.nextInt(), ya = scan.nextInt(), 
				xb = scan.nextInt(), yb = scan.nextInt(), 
				xc = scan.nextInt(), yc = scan.nextInt();
			
			double a = dist(xb, yb, xc, yc), 
				   b = dist(xa, ya, xc, yc),
				   c = dist(xa, ya, xb, yb);
			
			double semi = (a+b+c)/2;
			
			System.out.printf("(%.2f,%.2f)%n", ((a*xa+b*xb+c*xc)/(a+b+c)), ((a*ya+b*yb+c*yc)/(a+b+c)));
			
			System.out.printf("(%.2f,%.2f)%n", ((xa+xb+xc)/3.0), ((ya+yb+yc)/3.0));
			
			System.out.printf("%.2f%n", Math.sqrt(semi*(semi-a)*(semi-b)*(semi-c)));
		}
	}
	
	public static double dist(double xa, double ya, double xb, double yb) {
		return Math.sqrt(Math.pow(xa-xb, 2) + Math.pow(ya-yb, 2));
	}
}
