package Q13_07_Lambda_Expressions;

public class Country {
	private String name;
	private int size;
	private String continent;
	public Country(String n, String c, int sz) {
		name = n;
		size = sz;
		continent = c;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContinent() {
		return continent;
	}
	
	public int getPopulation() {
		return size;
	}
}
