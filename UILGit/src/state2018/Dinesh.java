package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dinesh {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("dinesh.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			scan.nextLine();
			HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
			Scanner sc = new Scanner(scan.nextLine());
			while(sc.hasNext())
				map.put(sc.next(), new HashMap<>());
			
			int paths = scan.nextInt();
			for(int j = 0; j < paths; j++) {
				String s1 = scan.next(), s2 = scan.next();
				int dist = scan.nextInt();
				map.get(s1).put(s2, dist);
				map.get(s2).put(s1, dist);
			}
			
			int searches = scan.nextInt();
			for(int j = 0; j < searches; j++) {
				String start = scan.next(), end = scan.next();
				System.out.printf("%s to %s:%d%n", start, end, distance(map, start, end, new HashMap<>(), new ArrayList<>()));
			}
		}
	}
	
	public static int distance(HashMap<String, HashMap<String, Integer>> map, String start, String end, HashMap<String, HashMap<String, Integer>> memo, ArrayList<String> repeatStack) {
		if(start.equals(end))
			return 0;
		if(memo.get(start) == null)
			memo.put(start, new HashMap<>());
		
		if(!memo.get(start).containsKey(end)) {
			int min = Integer.MAX_VALUE;
			repeatStack.add(start);
			for(String s: map.get(start).keySet()) {
				if(repeatStack.contains(s))
					continue;
				int temp = distance(map, s, end, memo, repeatStack);
				if(temp < Integer.MAX_VALUE && temp + map.get(start).get(s) < min)
					min = temp + map.get(start).get(s);
			}
			repeatStack.remove(start);
			if(min < Integer.MAX_VALUE)
				memo.get(start).put(end, min);
			else
				return Integer.MAX_VALUE;
		}
		
		return memo.get(start).get(end);
	}
}