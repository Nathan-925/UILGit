package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Johnny {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("johnny.dat"));
		
		HashMap<String, Character> map = new HashMap<>();
		while(scan.hasNext()) {
			String s = scan.nextLine();
			Scanner sc = new Scanner(s);
			if(s.matches("\\W.*")) {
				char c = sc.next().charAt(0);
				sc.useDelimiter("\\s|/");
				while(sc.hasNext())
					map.put(sc.next(), c);
			}
			else {
				while(sc.hasNext())
					System.out.print(map.get(sc.next()));
				System.out.println();
			}
		}
	}
}
