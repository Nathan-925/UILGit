package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dennis {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("dennis.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int n = scan.nextInt();
			ArrayList<String> list = new ArrayList<>();
			for(int j = 0; j < n; j++)
				list.add(scan.next());
			int length = list.stream().mapToInt(s -> s.length()).max().getAsInt();
			for(int j = 0; j < length; j++) {
				for(String s: list)
					System.out.print(s.length() > j ? s.charAt(j) : " ");
				System.out.println();
			}
			for(int j = 0; j < n; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
