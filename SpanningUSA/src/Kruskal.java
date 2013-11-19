import java.io.FileReader;
import java.util.TreeSet;


public class Kruskal {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Parser parser = new Parser(new FileReader("USA-highway-miles.in"));
		TreeSet<Edge> edges = parser.parse();
		
		KruskalForest kf = new KruskalForest();
		for(Edge edge : edges){
			kf.addEdge(edge);
		}
		
		int miles = 0;
		for(Edge edge : kf.getEdges()){
			miles += edge.getDistance();
		}
		System.out.println(miles);
		

	}

}
