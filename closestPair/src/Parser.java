import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

public class Parser extends BufferedReader {
	public int size;
	public ArrayList<OurPoint> list;

	public Parser(Reader in) {
		super(in);
		list = new ArrayList<OurPoint>();
	}

	public ArrayList<OurPoint> parse() throws IOException {
		String line = readLine().trim();
		while(!line.contains("DIMENSION")) {
			line=readLine().trim();
		}
		size = Integer.valueOf(line.split(": ")[1]);
		while (!(line.equals("NODE_COORD_SECTION"))) {
			line = readLine().trim();
		}
		for(int i =0;i<size;i++){
			line =readLine().trim();
			String[] pointdata = line.split(" +");
			list.add(new OurPoint(Double.parseDouble(pointdata[1]), Double
					.parseDouble(pointdata[2]), pointdata[0]));
		}
		Collections.sort(list);
		return list;
	}
	
	
}
