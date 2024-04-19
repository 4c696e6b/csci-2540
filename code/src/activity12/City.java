package activity12;

public class City extends KeyedItem<String>{

	private String country;

	City(String newCity,String newCountry){
		super(newCity);
		country = newCountry;
	}

	public String getCountry() {
		return this.country;
	}

	public String toString() {
		String str;
		str = getKey() + ", " + country;
		return str;
	}
	
}