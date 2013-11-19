package sm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

public class Parser extends BufferedReader {
	private String s;
	private int size;
	private LinkedList <Man> manlist;
	private LinkedList<Woman> womenlist;
	private String[] namesAndNbr, nbrAndPreferences, preferences;

	public Parser(Reader in) throws Exception {
		super(in);
		manlist = new LinkedList<Man>();
		womenlist = new LinkedList<Woman>();

	}

	public LinkedList <Man> parse() throws IOException {
		s = readLine();
		while (s.startsWith("#")) {
			s = readLine();
		}
		size = Integer.parseInt(s.substring(2));
		for (int i = 0; i < 2 * size; i++) {
			s = readLine();
			namesAndNbr = s.split(" ");
			if (Integer.parseInt(namesAndNbr[0]) % 2 != 0) {
				Man m = new Man( namesAndNbr[1]);
				manlist.add(i/2, m);
			} else {
				Woman w = new Woman(namesAndNbr[1]);
				womenlist.add(i/2, w);

			}

		}
		readLine();
		for (int i = 0; i < size * 2; i++) {
			s = readLine();
			nbrAndPreferences = s.split(":");
			preferences = nbrAndPreferences[1].substring(1).split(" ");
			if (Integer.parseInt(nbrAndPreferences[0]) % 2 != 0) {
				for (int j = 0; j < preferences.length; j++) {
					manlist.get(i/2).addWomen(
							womenlist.get((Integer.parseInt(preferences[j])-1)/2));
					
				}
				
			} else {
				for (int j = 0; j < preferences.length; j++) {
					womenlist.get(i/2).addMan(
							manlist.get((Integer.parseInt(preferences[j])-1)/2));

				}
			}

		}
		
		

		return manlist;
	}
}