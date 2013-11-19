import java.util.Comparator;

public class OurPointYSort implements Comparator<OurPoint> {

	@Override
	public int compare(OurPoint a, OurPoint b) {
		if (a.getY() == b.getY()) {
			return 0;
		} else if (a.getY() > b.getY()) {
			return 1;
		} else {
			return -1;
		}
	}

}
