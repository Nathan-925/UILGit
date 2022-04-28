package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Candela {
	public static void main(String[] args) throws FileNotFoundException {
		//This outputs different than judge out, but the solutions are better I think?
		Scanner scan = new Scanner(new File("candela.dat"));
		int questions = scan.nextInt();
		ArrayList<Question> list = new ArrayList<>();
		for(int i = 0; i < questions; i++)
			list.add(new Question(scan.nextInt(), scan.nextInt()));
		
		while(scan.hasNextInt()) {
			int target = scan.nextInt();
			ArrayList<Question> best = new ArrayList<>();
			for(int i = 0; i < Math.pow(2, list.size()); i++) {
				ArrayList<Question> test = new ArrayList<>();
				String s = String.format("%"+(list.size()-1)+"s", Integer.toString(i, 2));
				for(int j = 0; j < s.length(); j++)
					if(s.charAt(j)=='1')
						test.add(list.get(j));
				if(test.stream().mapToInt(n -> n.diff).sum() <= target)
					if(test.stream().mapToInt(n -> n.score).sum() > best.stream().mapToInt(n -> n.score).sum())
						best = test;
			}
			System.out.printf("Target diff     = %-2d%n", target);
			System.out.printf("Calculated diff = %-2d%n", best.stream().mapToInt(n -> n.diff).sum());
			System.out.printf("Expected points = %-2d%n", best.stream().mapToInt(n -> n.score).sum());
			for(int i = 0; i < best.size(); i++)
				System.out.printf("Q#%2d, %s%n", (list.indexOf(best.get(i))+1), best.get(i));
			System.out.println("=====");
		}
	}
}

class Question{
	int score, diff;
	
	public Question(int score, int diff) {
		this.score = score;
		this.diff = diff;
	}
	
	@Override
	public String toString() {
		return String.format("%2d pts, diff %d", score, diff);
	}
}