package freedomgame;
import java.util.HashMap;

public class User {
	int money;
	int item;
	HashMap<String , Integer> bag = new HashMap<>();
	public User(int money, int item) {
		this.money = money;
		this.item = item;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public HashMap getBag() {
		return bag;
	}
}
