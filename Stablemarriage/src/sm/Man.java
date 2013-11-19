package sm;
import java.util.LinkedList;

public class Man {
	private String name;
	private LinkedList<Woman> listOfWoman;
	private boolean isMarried;
	private Woman myWoman;

	public Man( String name) {
		this.name = name;
		listOfWoman = new LinkedList<Woman>();
		isMarried = false;
	}

	public String toString() {
		return name;
	}

	public void addWomen(Woman woman) {
		listOfWoman.add(woman);

	}

	public Woman getFirstWoman() {
		return listOfWoman.poll();
	}

	public void setMarried(Woman woman) {
		isMarried = true;
		myWoman = woman;
		woman.setMarried(this);
	}

	public Woman getMyWoman() {
		return myWoman;
	}

	public void findAvailableWoman() {
		for (Woman w : listOfWoman) {
			if (w.prefers(this)) {
				setMarried(w);
				break;
			}
		}
	}

	

	public boolean isMarried() {
		return isMarried;
	}

	public void setSingle() {
		isMarried = false;
		myWoman = null;
	}
	public LinkedList<Woman> getList(){
		return listOfWoman;
	}
}