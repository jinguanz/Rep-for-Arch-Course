package edu.cmu.mse.rui.J2EE.Contest;

public class ContestMain {
	public static void main(String[] args) {
		//String fileName = args[0];
		String fileName="d2.txt";
		long startTime = System.currentTimeMillis();
		String[] answer = Entry.mostFrequent(fileName);
		long endTime = System.currentTimeMillis();

		for (String s : answer) {
			System.out.println(s);
		}

		System.out.println("Time = " + (endTime - startTime));
	}

}
