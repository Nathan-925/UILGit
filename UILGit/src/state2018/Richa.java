package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Richa {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("richa.dat"));
		int cases = scan.nextInt();
		HashMap<Integer, Course> map = new HashMap<>();
		for(int i = 0; i < cases; i++) {
			int ind = scan.nextInt();
			String s = scan.next();
			boolean honors = s.charAt(0) == 'Y';
			int credits = 0;
			switch(s.charAt(1)) {
				case 'Y':
					credits = 4;
					break;
				case 'S':
					credits = 2;
					break;
				case 'Q':
					credits = 1;
					break;
			}
			map.put(ind, new Course(honors, credits));
		}
		
		scan.nextLine();
		while(scan.hasNextLine()) {
			Scanner sc = new Scanner(scan.nextLine());
			int credits = 0;
			double points = 0;
			while(sc.hasNext()) {
				String s = sc.next();
				Course c = map.get(sc.nextInt());
				double pts = 0;
				switch(s.charAt(0)) {
					case 'A':
						pts = 4.5;
						break;
					case 'B':
						pts = 3.5;
						break;
					case 'C':
						pts = 2.5;
						break;
					case 'D':
						pts = 1;
						break;
				}
				
				if(s.contains("+"))
					pts += 0.25;
				else if(s.contains("-"))
					pts -= 0.25;
				
				if(c.honors && pts >= 2.25)
					pts += 0.5;
				
				points += pts*c.credits;
				credits += c.credits;
			}
			System.out.printf("%.3f%n", (points/credits));
		}
	}
}

class Course {
	boolean honors;
	int credits;
	
	public Course(boolean honors, int credits) {
		this.honors = honors;
		this.credits = credits;
	}
}