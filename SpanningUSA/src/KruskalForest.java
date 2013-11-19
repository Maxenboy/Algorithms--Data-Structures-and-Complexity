import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;


public class KruskalForest {
	Vector<HashSet<String>> cityGroups = new Vector<HashSet<String>>();
	TreeSet<Edge> kruskalForest = new TreeSet<Edge>();

	public TreeSet<Edge> getEdges(){
		return kruskalForest;
	}

	public HashSet<String> getCityGroup(String city){
		for(HashSet<String> cityGroup : cityGroups){
			if(cityGroup.contains(city)){
				return cityGroup;
			}
		}
		return null;
	}

	public void addEdge(Edge edge){
		String firstCity = edge.getFirstCity();
		String secondCity = edge.getSecondCity();
		HashSet<String> firstCityGroup = getCityGroup(firstCity);
		HashSet<String> secondCityGroup = getCityGroup(secondCity);

		if(firstCityGroup == null){
			kruskalForest.add(edge);
			if(secondCityGroup == null){
				HashSet<String> bothCitiesGroup = new HashSet<String>();
				bothCitiesGroup.add(firstCity);
				bothCitiesGroup.add(secondCity);
				cityGroups.add(bothCitiesGroup);
			}else{
				secondCityGroup.add(firstCity);
			}
		}else{
			if(secondCityGroup == null){
				firstCityGroup.add(secondCity);
				kruskalForest.add(edge);
			} else if(firstCityGroup != secondCityGroup){
				firstCityGroup.addAll(secondCityGroup);
				cityGroups.remove(secondCityGroup);
				kruskalForest.add(edge);
			}
		}

	}
}