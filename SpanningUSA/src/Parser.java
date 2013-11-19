import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.TreeSet;

public class Parser extends BufferedReader {
	private TreeSet<Edge> set;

	public Parser(Reader in) throws Exception {
		super(in);
		set = new TreeSet<Edge>();
	}

	public TreeSet<Edge> parse() throws IOException {
		for (int i = 0; i < 128; i++) {
			readLine();		
		}
		
		String line = readLine();
		while (line != null) {
			String city = line.split("--")[0];
			String[] temp = line.split("--")[1].split(" \\[");
			String connection = temp[0];
			int dist = Integer.valueOf(temp[1].substring(0,
					temp[1].length() - 1));
			set.add(new Edge(city, connection, dist));
			line = readLine();
		}
		return set;
	}
}
