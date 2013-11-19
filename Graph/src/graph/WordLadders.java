package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WordLadders {

	public static void main(String[] args) throws IOException {
		ArrayList<String> words = new ArrayList<String>();
		String file = "lab2/words-5757.dat";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			words.add(line);
		}
		br.close();
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < words.size(); i++){
			String word = words.get(i);
			String c1 = String.valueOf(word.charAt(1));
			String c2 = String.valueOf(word.charAt(2));
			String c3 = String.valueOf(word.charAt(3));
			String c4 = String.valueOf(word.charAt(4));
			ArrayList<String> wordNeighbours = new ArrayList<String>();
			for(int j = 0; j < words.size(); j++){
				String potentialWord = words.get(j);
				StringBuilder sb = new StringBuilder(potentialWord);
				int index = sb.indexOf(c1);
				if(index > -1){
					sb.deleteCharAt(index);
				}
				index = sb.indexOf(c2);
				if(index > -1){
					sb.deleteCharAt(index);
				}
				index = sb.indexOf(c3);
				if(index > -1){
					sb.deleteCharAt(index);
				}
				index = sb.indexOf(c4);
				if(index > -1){
					sb.deleteCharAt(index);
				}
				if(sb.length() == 1){
					wordNeighbours.add(potentialWord);
				}
			}
			graph.put(word, wordNeighbours);
		}
		
		String file2 = "lab2/words-5757-test.in";
		BufferedReader read = new BufferedReader(new FileReader(file2));
		String line2;
		while ((line2 = read.readLine()) != null) {
			HashMap<String, Boolean> discover = new HashMap<String, Boolean>();
			for(String z : graph.keySet()){
				discover.put(z, false);
			}

			String[] lines = line2.split(" ");
			String word1 = lines[0];
			String word2 = lines[1];
			int layerCounter = 0;
			HashMap<Integer, ArrayList<String>> layerTree = new HashMap<Integer, ArrayList<String>>();
			ArrayList<String> nodes = new ArrayList<String>();
			nodes.add(word1);
			layerTree.put(layerCounter, nodes);
			discover.put(word1, true);

			while(!layerTree.get(layerCounter).isEmpty()){
				ArrayList<String> newNeighbours = new ArrayList<String>();
				ArrayList<String> currentLayerWords = layerTree.get(layerCounter);
				for(int w = 0; w < currentLayerWords.size(); w++){
					String aNeighbour = currentLayerWords.get(w);
					ArrayList<String> tempList = graph.get(aNeighbour);
					for(int u = 0; u < tempList.size(); u++){
						String currentNode = tempList.get(u);
						if(!discover.get(currentNode)){
							discover.put(currentNode, true);
							newNeighbours.add(currentNode);
						}
					}
				}
				layerCounter++;
				layerTree.put(layerCounter, newNeighbours);
			}
			int b = 0;
			while(b != layerTree.size() && !layerTree.get(b).contains(word2)){
				b++;
			}
			if(b == layerTree.size()){
				System.out.println("-1");
			}
			else{
				System.out.println(b);
			}
		}
		br.close();
	}
}
