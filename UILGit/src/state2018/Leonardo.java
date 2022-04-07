package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leonardo {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("leonardo.dat"));
		
		while(scan.hasNextLine()) {
			String arr[] = scan.nextLine().split("=");
			String per[] = arr[0].trim().split("\\s+");
			String real[] = arr[1].trim().split("\\s+");
			
			String out = "";
			for(String s: per)
				out += s.charAt(0);
			out += " = ";
			for(String s: real)
				out += s.charAt(s.length()-1);
			
			System.out.println(out.toUpperCase());
		}
	}
}
