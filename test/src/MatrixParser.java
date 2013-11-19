import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class MatrixParser extends BufferedReader {
	HashMap<String, HashMap<String, Integer>> map;
	ArrayList<String> indexes;

	public MatrixParser(Reader in) throws Exception {
		super(in);
		map = new HashMap<String, HashMap<String, Integer>>();
		indexes = new ArrayList<String>();
	}

	public HashMap<String, HashMap<String, Integer>> parse() throws Exception {
		for (int i = 0; i < 6; i++) {
			readLine();
		}
		String[] keys = readLine().trim().split(" +");
		for (String s : keys) {
			map.put(s, new HashMap<String, Integer>());
			indexes.add(s);
		}

		for (int i = 0; i < 24; i++) {
			String[] cost = readLine().split(" +");
			for (int j = 1; j < cost.length; j++) {
				map.get(indexes.get(j - 1)).put(cost[0],
						Integer.parseInt(cost[j]));
			}
		}
		return map;
	}

}