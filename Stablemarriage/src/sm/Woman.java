package sm;
import java.util.ArrayList;

public class Woman {
	private String name;
	private ArrayList<Man> listOfMan;
	private boolean isMarried;
	private Man myMan;
	private int index, myManIndex;

	public Woman(String name) {
		
		this.name = name;
		listOfMan = new ArrayList<Man>();
		isMarried = false;
	}

	public String toString() {
		return name;
	}

	public void addMan(Man man) {
		listOfMan.add(man);
	}

	public void setMarried(Man man) {
		isMarried = true;
		if (myMan != null) {
			myMan.setSingle();
		}
		myMan = man;
	}

	public boolean isMarried() {
		return isMarried;
	}


	public boolean prefers(Man man) {
		index = listOfMan.indexOf(man);
		myManIndex = listOfMan.indexOf(myMan);
		return index < myManIndex ? true : false;
	}

	
	public ArrayList<Man> getList() {
		return listOfMan;
	}
}