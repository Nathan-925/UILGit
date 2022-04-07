package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalina {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("catalina.dat"));
		
		while(scan.hasNextLine()) {
			Scanner sc = new Scanner(scan.nextLine());
			sc.useDelimiter("[^A-Z]");
			while(sc.hasNext())
				System.out.print(sc.next());
			System.out.println();
		}
	}
}
