package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diya {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("diya.dat"));
		while(scan.hasNextInt()) {
			int size = scan.nextInt();
			int arr[][] = new int[size][size];
			int n = 1;
			int left = 0, right = size-1,
				bot = 0, top = size-1;
			int x = -1, y = 0;
			while(left <= right && bot <= top) {
				while(x < right)
					arr[y][++x] = n++;
				bot++;
				while(y < top)
					arr[++y][x] = n++;
				right--;
				while(x > left)
					arr[y][--x] = n++;
				top--;
				while(y > bot)
					arr[--y][x] = n++;
				left++;
			}
			for(int[] row: arr) {
				for(int num: row)
					System.out.printf("%-"+(Integer.toString(n-1).length()+1)+"d", num);
				System.out.println();
			}
			System.out.println("=====");
		}
	}
}
