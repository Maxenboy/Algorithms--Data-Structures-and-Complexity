package sm;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class GSAlgorithm {

	public static void main(String[] args) throws Exception {
		Parser parser = new Parser(new FileReader(args[0]));
		LinkedList <Man> men = parser.parse();
		while (!AllMarried(men)) {
			for (Man m : men) {
				if (!m.isMarried()) {
					Woman w = m.getFirstWoman();
					if (!w.isMarried()) {
						m.setMarried(w);
					} else {
						if (w.prefers(m)) {
							m.setMarried(w);
						} else {
							m.findAvailableWoman();
						}
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		StringBuilder sb = new StringBuilder();
		for (Man m : men) {
			sb.append(m.toString() + " -- " + m.getMyWoman().toString()+"\r\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

	private static boolean AllMarried(LinkedList <Man> map) {
		boolean single = false;
		for (Man m : map) {
			if (!m.isMarried()) {
				single = true;
				break;
			}
		}
		return !single;

	}
}