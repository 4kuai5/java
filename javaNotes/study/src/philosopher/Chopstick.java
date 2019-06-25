package philosopher;

public class Chopstick {
	private int num;
	public Chopstick(int num){
		this.num=num;
	}
	public int getNum(){                       //私有属性，方便以后知道拿走的是的哪个编号
		return this.num;
	}

}
