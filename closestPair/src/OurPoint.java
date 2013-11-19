public class OurPoint implements Comparable<OurPoint> {
	private double x, y;
	private int nbr;

	public OurPoint(double x, double y, String nbr) {
		this.x = x;
		this.y = y;
		this.nbr = Integer.valueOf(nbr);

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getNbr() {
		return nbr;
	}

	public double distance(OurPoint p) {
		return Math.hypot((p.y - this.y), (p.x - this.x));
	}

	@Override
	public int compareTo(OurPoint o) {
		if (x == o.x) {
			return 0;
		} else if (x > o.x) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nbr;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OurPoint other = (OurPoint) obj;
		if (nbr != other.nbr)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
