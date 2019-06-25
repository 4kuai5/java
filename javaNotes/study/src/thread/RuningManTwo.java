package thread;
//线程的两种方法之一
public class RuningManTwo implements Runnable {
	
	private String name;
	
	public  RuningManTwo(){}
	public  RuningManTwo(String name){
		this.name=name;
	}
	//重写run方法
	public void run(){
		for(int i=1;i<=100;i++){
			System.out.println(this.name+"跑到第"+i+"米了");
		}
	}
	public static void main(String[] args) {
		//1.创建一个线程对象
		RuningMan r1=new RuningMan("苏炳添");
		RuningMan r2=new RuningMan("博尔特");
		RuningMan r3=new RuningMan("加特林");
		//2.调用start方法,让线程进入就绪状态
		Thread t1=new Thread(r1);
		t1.start();//从thread类中继承过来的方法
		Thread t2=new Thread(r2);
		t2.start();//从thread类中继承过来的方法
		Thread t3=new Thread(r3);
		t3.start();//从thread类中继承过来的方法
	}

}
