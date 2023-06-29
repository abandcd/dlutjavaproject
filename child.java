package exp05;

public class child extends adult{
	private String name;
	private int age;
	private int price=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getbed() {
		if(price==30) {
			return "是";
		}
		else return "否";
	}
}
