package bean;

import java.util.List;

public class user {
	private int id;
	private String name;
	private String money;
	private List<Order> list ;
	
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
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
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
	
}
