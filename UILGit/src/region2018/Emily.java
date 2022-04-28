package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emily {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("emily.dat"));
		int size = scan.nextInt();
		char arr[][] = new char[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				arr[i][j] = scan.next().charAt(0);
		
		int dirs[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		while(scan.hasNext()) {
			String s = scan.next();
			System.out.println("<"+s+">");
			boolean found = false;
			for(int[] dir: dirs) {
				String compass = "";
				if(dir[0] == 1)
					compass += "S";
				else if(dir[0] == -1)
					compass += "N";
				if(dir[1] == 1)
					compass += "E";
				else if(dir[1] == -1)
					compass += "W";
				
				for(int i = 0; i < size; i++) {
					Outer:
					for(int j = 0; j < size; j++) {
						int x = i, y = j, ind = 0;
						while(ind < s.length()) {
							if(s.charAt(ind++) != arr[x][y])
								continue Outer;
							x = (x+dir[0])%size;
							if(x < 0)
								x += size;
							y = (y+dir[1])%size;
							if(y < 0)
								y += size;
						}
						found = true;
						System.out.printf("(%d,%d) %s%n", i+1, j+1, compass);
					}
				}
			}
			if(!found)
				System.out.println("NOT FOUND");
		}
	}
}
