package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matthew {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("matthew.dat"));
		while(scan.hasNext()) {
			String arr[] = scan.nextLine().split("\\s+");
			int cases = scan.nextInt();
			for(int i = 0; i < cases; i++) {
				String out = "";
				String pat = scan.next().replace("*", ".*").replace("?", ".");
				for(String s: arr)
					if(s.matches(pat))
						out += s+" ";
				if(out.length() != 0)
					System.out.println(out.trim());
				else
					System.out.println("NONE");
			}
			scan.nextLine();
		}
	}
}
