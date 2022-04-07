package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Keerthi {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("keerthi.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			char arr[][] = new char[10][10];
			scan.nextLine();
			for(int j = 0; j < 10; j++) {
				String str = scan.nextLine();
				for(int l = 0; l < 10; l++) {
					arr[j][l] = str.charAt(l);
				}
			}
			
			for(int j = 0; j < 10; j++) {
				flood(arr, 0, j);
				flood(arr, arr.length-1, j);
				flood(arr, j, 0);
				flood(arr, j, arr[0].length-1);
			}
			
			int cnt = 0;
			for(int j = 1; j < arr.length-1; j++) {
				for(int l = 1; l < arr[0].length-1; l++) {
					if(arr[j][l] == '#') {
						cnt++;
						flood(arr, j, l);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void flood(char[][] arr, int x, int y) {
		if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == '.')
			return;
		
		arr[x][y] = '.';
		flood(arr, x+1, y);
		flood(arr, x-1, y);
		flood(arr, x, y+1);
		flood(arr, x, y-1);
	}
}
