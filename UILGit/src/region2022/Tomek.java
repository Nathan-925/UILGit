package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tomek {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("tomek.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			char arr[][] = new char[scan.nextInt()][scan.nextInt()];
			scan.nextLine();
			for(int j = 0; j < arr.length; j++) {
				String s = scan.nextLine();
				for(int l = 0; l < arr[0].length; l++)
					arr[j][l] = s.charAt(l);
			}
			
			for(int j = 0; j < arr.length; j++) {
				flood(arr, j, 0);
				flood(arr, j, arr[0].length-1);
			}
			for(int j = 0; j < arr[0].length; j++) {
				flood(arr, 0, j);
				flood(arr, arr.length-1, j);
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int j = 0; j < arr.length; j++) {
				for(int l = 0; l < arr[0].length; l++) {
					int n = flood(arr, j, l);
					if(n > 0)
						list.add(n);
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println("Case #"+(i+1)+": "+list.size());
			if(list.isEmpty())
				System.out.print("NONE");
			else
				for(int n: list)
					System.out.print(n+" ");
			System.out.println();
		}
	}
	
	public static int flood(char[][] arr, int x, int y) {
		if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == 'W')
			return 0;
		
		arr[x][y] = 'W';
		return 1 + 
				flood(arr, x+1, y) + 
				flood(arr, x-1, y) + 
				flood(arr, x, y+1) + 
				flood(arr, x, y-1);
	}
}
