
public class Edge implements Comparable<Edge> {
	private String city1;
	private String city2;
	private int distance;
	
	public Edge(String city1, String city2, int distance){
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}
	
	public String getFirstCity(){
		return city1;
	}
	
	public String getSecondCity(){
		return city2;
	}
	
	public int getDistance(){
		return distance;
	}

	@Override
	public int compareTo(Edge edge) {
		return (this.distance < edge.distance) ? -1 : 1;
	}
	

}