package Prouduct;

public class Test {

	public static void main(String[] args) {
		Warehouse wh=new Warehouse();
		Producer p=new Producer(wh);
		//�����̵߳����ȼ���1-10
		p.setPriority(10);
		Consumer c=new Consumer(wh);
		p.start();
		c.start();
	}

}
