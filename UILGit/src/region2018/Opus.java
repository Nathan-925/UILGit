package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Opus {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("opus.dat"));
		scan.next();
		String key[] = scan.nextLine().trim().split("\\s+");
		ArrayList<ArrayList<Student>> list = new ArrayList<>();
		for(int i = 0; i < 6; i++)
			list.add(new ArrayList<>());
		while(scan.hasNext()) {
			String first = scan.next(), last = scan.next(), school = scan.next();
			list.get(scan.next().charAt(0)-49).add(new Student(first, last, school, scan.nextLine().trim().split("\\s+"), key));
		}
		
		for(int i = 0; i < 6; i++) {
			if(!list.get(i).isEmpty()) {
				System.out.println((i+1)+"A");
				Collections.sort(list.get(i));
				for(int j = 0; j < list.get(i).size(); j++) {
					int place = j+1;
					while(place > 1 && list.get(i).get(j).isUnbreakable(list.get(i).get(place-2)))
						place--;
					System.out.println(place+" "+list.get(i).get(j));
				}
			}
		}
	}
}

class Student implements Comparable<Student>{
	String first, last, school;
	int score;
	double percent;
	
	public Student(String first, String last, String school, String[] answers, String[] key) {
		this.first = first;
		this.last = last;
		this.school = school;
		
		int correct = 0, answered = 0;
		for(int i = 0; i < answers.length; i++) {
			if(answers[i].equals("S"))
				continue;
			if(answers[i].equals(key[i])) {
				score += 6;
				correct++;
			}
			else
				score -= 2;
			answered++;
		}
		percent = (double)correct/answered;
	}
	
	public boolean isUnbreakable(Student o) {
		return score == o.score && percent == o.percent;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s - %s: %d", last, first, school, score);
	}

	@Override
	public int compareTo(Student o) {
		if(score != o.score)
			return Integer.compare(o.score, score);
		if(percent != o.percent)
			return Double.compare(o.percent, percent);
		if(!last.equals(o.last))
			return last.compareTo(o.last);
		return first.compareTo(o.first);
	}
}