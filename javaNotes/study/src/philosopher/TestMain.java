package philosopher;

public class TestMain {

	public static void main(String[] args) {
		Chopstick c1=new Chopstick(1);
		Chopstick c2=new Chopstick(2);
		Chopstick c3=new Chopstick(3);
		Chopstick c4=new Chopstick(4);
		Philosopher p1=new Philosopher("��ѧ��a",c2,c1,0);
		Philosopher p2=new Philosopher("��ѧ��b",c3,c2,1000);
		Philosopher p3=new Philosopher("��ѧ��c",c4,c3,0);
		Philosopher p4=new Philosopher("��ѧ��d",c1,c4,1000);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
	}

}
