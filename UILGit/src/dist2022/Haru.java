package dist2022;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Haru {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("haru.dat"));
		int cases = scan.nextInt();
		Outer:
		for(int i = 0; i < cases; i++) {
			int ins = scan.nextInt();
			Point p[] = new Point[2];
			String insStrings[] = new String[2];
			boolean[][] arr = new boolean[101][101];
			for(int j = 0; j < 2; j++) {
				p[j] = new Point(scan.nextInt(), scan.nextInt());
				insStrings[j] = scan.next();
			}
			
			for(int j = 0; j < ins; j++) {
				//print(arr);
				for(int l = 0; l < 2; l++) {
					arr[p[l].x][p[l].y] = true;
					switch(insStrings[l].charAt(j)) {
						case 'R':
							p[l].x++;
							break;
						case 'L':
							p[l].x--;
							break;
						case 'U':
							p[l].y++;
							break;
						case 'D':
							p[l].y--;
							break;
					}
				}
				if(p[0].equals(p[1])) {
					System.out.println("HEAD ON");
					continue Outer;
				}
				else if(arr[p[0].x][p[0].y] && arr[p[1].x][p[1].y]) {
					System.out.println("DOUBLE SPIKE");
					continue Outer;
				}
				else if(arr[p[0].x][p[0].y]) {
					System.out.println("P2 WIN");
					continue Outer;
				}
				else if(arr[p[1].x][p[1].y]) {
					System.out.println("P1 WIN");
					continue Outer;
				}
			}
			System.out.println("DRAW");
		}
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
		System.out.println("----------");
	}
}