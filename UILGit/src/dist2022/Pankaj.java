package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pankaj {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pankaj.dat"));
		int cases = scan.nextInt();
		scan.nextLine();
		Outer:
		for(int i = 0; i < cases; i++) {
			System.out.print("Test case "+(i+1)+": ");
			
			ArrayList<String> campers = new ArrayList<>(Arrays.asList(scan.nextLine().split(",")));
			boolean graph[][] = new boolean[campers.size()][campers.size()];
			for(String s: scan.nextLine().split(",")) {
				String arr[] = s.split("<->");
				graph[campers.indexOf(arr[0])][campers.indexOf(arr[1])] = true;
				graph[campers.indexOf(arr[1])][campers.indexOf(arr[0])] = true;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(0);
			int colors[] = new int[campers.size()];
			colors[0] = 1;
			while(!queue.isEmpty()) {
				int test = queue.poll();
				for(int l = 0; l < graph[0].length; l++) {
					if(graph[test][l]) {
						if(colors[l]==0) {
							colors[l] = colors[test]%2+1;
							queue.add(l);
						}
						else if(colors[test] == colors[l]) {
							System.out.println("impossible");
							continue Outer;
						}
					}
				}
			}
			System.out.println("possible");
		}
	}
}
