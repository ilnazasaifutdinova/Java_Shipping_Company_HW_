package items;

public class Item {

	//Attributes
	private String name;
	private double height;
	private double wide;
	private double length;
	private double weight;
		
	//Constructors
	public Item(String name, double height, double wide, double length, double weight) {
			this.name = name;
			this.height = height;
			this.wide = wide;
			this.length = length;
			this.weight = weight;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWide() {
		return wide;
	}

	public void setWide(double wide) {
		this.wide = wide;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Calculate Volume method
	public double itemVolume() {
		return (height * wide * length) / 1000000; //m**3 (вроде)
	}
	
	//Print item info method
	public void printItemInfo() {
		System.out.println("Item: " + name);
		System.out.println("boxSize: " + height + "*" + wide + "*" + length) ;
		System.out.println("Weight: " + weight);
		System.out.println("Item Volume: " + itemVolume());
	}
	
}