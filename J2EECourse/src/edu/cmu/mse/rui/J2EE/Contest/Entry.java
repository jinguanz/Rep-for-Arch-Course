package edu.cmu.mse.rui.J2EE.Contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Entry {

	private static final int count = 20;
	private static HashMap<String, Integer> aStringOcctimeMap = new HashMap<String, Integer>();
	private static HashMap<Integer, ArrayList<String>> numberTowordsMap = new HashMap<Integer, ArrayList<String>>();
	private static final String regex = "\\W";

	private static void readFile(String filename) {
		try {
			BufferedReader fr = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			while (fr.readLine() != null) {
				for (int i = 0; i < count; i++) {
					sb = sb.append(fr.readLine());
				}

				String[] arr = sb.toString().split(regex);
				for (int i = 0; i < arr.length; i++) {
					String key = arr[i].trim().toLowerCase();
					//System.out.print(key);
					if (aStringOcctimeMap.containsKey(key)) {
						int tempcount = aStringOcctimeMap.get(key) + 1;
						aStringOcctimeMap.remove(key);
						aStringOcctimeMap.put(key, tempcount);
					} else
						aStringOcctimeMap.put(key, 1);
				}
				sb.delete(0, sb.length());
				
			}
			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] mostFrequent(String fileName) {
		// TODO Auto-generated method stub
		String[] strarr = new String[10];
		long startTime = System.currentTimeMillis();
	
		
		readFile(fileName);
		long endTime = System.currentTimeMillis();
		System.out.println("read file Time = " + (endTime - startTime));
		mapConvertor();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer i : numberTowordsMap.keySet()) {
			arr.add(i);
		}
	
		Collections.sort(arr);
		for (int i = 0; i < 10; i++) {
			for (String word : numberTowordsMap
					.get(arr.get(arr.size() - 2 - i))) {
				strarr[i] = word;
			}

		}

		return strarr;
	}

	private static void mapConvertor() {
		for (String word : aStringOcctimeMap.keySet()) {
			Integer count = aStringOcctimeMap.get(word);
			if (numberTowordsMap.containsKey(count)) {
				numberTowordsMap.get(count).add(word);

			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(word);
				numberTowordsMap.put(count, al);
			}

		}

	}

}
