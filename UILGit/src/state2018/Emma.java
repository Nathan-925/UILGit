package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emma {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("emma.dat"));
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			String s = "";
			for(int i = 0; i < n; i++)
				s = "*"+s+" ";
			s = (s+s).trim();
			for(int i = 0; i < n; i++)
				System.out.println(s);
			for(int i = 0; i < n; i++) {
				char arr[] = new char[n];
				arr[i] = '*';
				arr[n-i-1] = '*';
				System.out.printf("%"+n+"s%s%n", "", String.valueOf(arr));
			}
			for(int i = 0; i < n; i++)
				System.out.println(s);
			System.out.println("==========");
		}
	}
}
