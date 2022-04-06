package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Michaela {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("michaela.dat"));
		String arr[] = new String[27];
		for(int i = 0; i < 27; i++) {
			arr[i] = Integer.toString(i, 2).replace("1", "-").replace("0", ".");
			while(arr[i].length() < 6)
				arr[i] = "."+arr[i];
			arr[i] = "-"+arr[i];
		}
		
		int cases = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < cases; i++) {
			System.out.print("Message #"+(i+1)+": ");
			for(char c: scan.nextLine().toCharArray()) {
				c = Character.toUpperCase(c);
				if(c == 32)
					System.out.print(arr[0]);
				else
					System.out.print(arr[c-64]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
