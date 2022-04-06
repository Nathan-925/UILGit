package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Shirley {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("shirley.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int arr[][] = new int[scan.nextInt()][scan.nextInt()];
			for(int j = 0; j < arr.length; j++)
				for(int l = 0; l < arr[0].length; l++)
					arr[j][l] = scan.nextInt();
			
			ArrayList<Cluster> list = new ArrayList<>();
			for(int j = 0; j < arr.length; j++)
				for(int l = 0; l < arr[0].length; l++) {
					Cluster test = new Cluster();
					cluster(j, l, arr, test);
					if(test.size >= 2)
						list.add(test);
				}
			
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("Case #"+(i+1)+":");
			for(int j = 0; j < 3; j++)
				if(j >= list.size())
					System.out.println("NONE");
				else
					System.out.printf("%d %.1f%n", list.get(j).count, (((double)list.get(j).size/(arr.length*arr[0].length))*100));
			System.out.println("^^^^^^^^^^^^");
		}
	}
	
	public static void cluster(int x, int y, int[][] arr, Cluster cluster) {
		if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] < 250)
			return;
		cluster.size++;
		cluster.count += arr[x][y];
		arr[x][y] = 0;
		cluster(x-1, y, arr, cluster);
		cluster(x+1, y, arr, cluster);
		cluster(x, y-1, arr, cluster);
		cluster(x, y+1, arr, cluster);
	}
}

class Cluster implements Comparable<Cluster>{
	int size, count;
	
	public Cluster() {
		size = 0;
		count = 0;
	}

	@Override
	public int compareTo(Cluster o) {
		return Integer.compare(count, o.count);
	}
}