import java.util.Arrays;

public class Animal {
	private String name;
	private char[] dna;

	public Animal(String name, String dna) {
		this.name = name.trim();
		this.dna = dna.toCharArray();
	}

	public String getName() {
		return name;
	}

	public char[] getDna() {
		return dna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(dna);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Animal other = (Animal) obj;
		if (!Arrays.equals(dna, other.dna))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
