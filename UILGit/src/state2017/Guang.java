package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Guang {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("guang.dat"));
		while(scan.hasNextInt()) {
			String s = Integer.toString(scan.nextInt(), scan.nextInt());
			int l = s.length();
			for(int i = 0; i < l; i++)
				s = "0"+s;
			System.out.println(s);
		}
	}
}
