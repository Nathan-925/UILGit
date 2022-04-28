package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Juana {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("juana.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int arr[][] = new int[scan.nextInt()][scan.nextInt()];
			for(int j = 0; j < arr.length; j++)
				for(int l = 0; l < arr[0].length; l++)
					arr[j][l] = scan.nextInt();
			
			System.out.print("Test case #"+(i+1)+":");
			try {
				int x = scan.nextInt()-1, y = scan.nextInt()-1, numy = scan.nextInt(), numx = scan.nextInt();
				String s = "\n";
				for(int j = 0; j < numx; j++) {
					for(int l = 0; l < numy; l++)
						s += String.format("%5d", arr[j+x][l+y]);
					s += "\n";
				}
				System.out.print(s);
			}
			catch (Exception e) {
				System.out.println(" Unable to extract requested size!");
			}
			System.out.println("--------------------");
		}
	}
}
