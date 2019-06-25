package Prouduct;

public class Test {

	public static void main(String[] args) {
		Warehouse wh=new Warehouse();
		Producer p=new Producer(wh);
		//设置线程的优先级别1-10
		p.setPriority(10);
		Consumer c=new Consumer(wh);
		p.start();
		c.start();
	}

}
