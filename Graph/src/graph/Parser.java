package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
	private HashMap<String, ArrayList<String>> graph;
	private ArrayList<String> words;
	private Scanner scan;
	private String word;

	public Parser(File in) throws Exception {
		scan = new Scanner(in);
		words = new ArrayList<String>();
		while (scan.hasNext()) {
			words.add(scan.nextLine());
		}
		for (int i = 0; i < words.size(); i++) {
			word = words.get(i);
			graph.put(word, neighBours(word, word.substring(1), words));

		}
	}

	private ArrayList<String> neighBours(String word, String ending,
			ArrayList<String> list) {
		ArrayList<String> copy = (ArrayList<String>)list.clone();
		copy.remove(word);
		char[] characters = ending.toCharArray();
		for (String s : copy) {
			if (s != null || characters.length != 0) {
				outer: for (int i = 0; i < characters.length; i++) {
					for (int j = 0; j < s.length(); j++) {
						if (s.charAt(j) != characters[i]) {
							copy.remove(s);
						} else {
							continue outer;
						}
					}

				}
			}
		}
		return copy;
	}
	
	public ArrayList<String> parse(File newFile) throws Exception{
		scan=new Scanner(newFile);
		ArrayList<String> pairs=new ArrayList<String>();
		while(scan.hasNext()) {
			String[] pair=scan.nextLine().split(" ");
			pairs.add(pair[0]);
			pairs.add(pair[1]);
		}
		return pairs;
	}

}
