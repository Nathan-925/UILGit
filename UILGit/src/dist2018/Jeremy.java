package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jeremy {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("jeremy.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int arr[][] = new int[scan.nextInt()][scan.nextInt()];
			for(int j = 0; j < arr.length; j++)
				for(int l = 0; l < arr[0].length; l++)
					arr[j][l] = scan.nextInt();
			int x = scan.nextInt(), y = scan.nextInt(), fill = scan.nextInt();
			int remove = arr[x][y];
			flood(arr, x, y, remove, fill);
			
			for(int j = 0; j < arr.length; j++) {
				for(int l = 0; l < arr[0].length; l++)
					System.out.print(arr[j][l]+" ");
				System.out.println();
			}
			System.out.println("=====");
		}
	}
	
	public static void flood(int[][] arr, int x, int y, int remove, int fill) {
		if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != remove)
			return;
		arr[x][y] = fill;
		flood(arr, x+1, y, remove, fill);
		flood(arr, x-1, y, remove, fill);
		flood(arr, x, y+1, remove, fill);
		flood(arr, x, y-1, remove, fill);
	}
}
