package bean;

public class Order {
	private int id;
	private String name;
	private String value;
	private user user;

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", value=" + value + ", user=" + user + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	
}
