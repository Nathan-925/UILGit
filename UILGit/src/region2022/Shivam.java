package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shivam {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("shivam.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			Matcher m = Pattern.compile("f\\(x\\)=(-?\\d+)?x\\^2(([+\\-]?\\d+)x)?([+\\-]?\\d+)?").matcher(scan.next());
			m.matches();
			
			int a, b, c;
			if(m.group(1) == null)
				a = 1;
			else
				a = Integer.parseInt(m.group(1));
			
			if(m.group(2) == null)
				b = 0;
			else
				b = Integer.parseInt(m.group(3));
			
			if(m.group(4) == null)
				c = 0;
			else
				c = Integer.parseInt(m.group(4));
			
			double r1 = ((double)-b+Math.sqrt(b*b-4*a*c))/(2*a),
				   r2 = ((double)-b-Math.sqrt(b*b-4*a*c))/(2*a);
			if(r1 == -0)	//This drives me insane idk why i have to catch -0
				r1 = 0;
			if(r2 == -0)
				r2 = 0;
			
			//System.out.println(r1+" "+r2);
			System.out.print("Function "+(i+1)+": ");
			if(Double.isNaN(r1))
				System.out.println("There are no real roots to the function.");
			else if(r1 == r2)
				System.out.printf("There is one real root at (%.2f,0.00).%n", r1);
			else {
				if(r1 > r2) {
					double temp = r1;
					r1 = r2;
					r2 = temp;
				}
				System.out.printf("There are two real roots at (%.2f,0.00) and (%.2f,0.00).%n", r1, r2);
			}
		}
	}
}
