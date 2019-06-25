package testJoin;

public class ThreadOne extends Thread{
	public void run(){
		System.out.println("thread one start");
		ThreadTwo two =new ThreadTwo();          //让two加入到one中
		two.start();
		try {
			two.join(2000);                      //线程二加入线程一当中 ;join中也可以添加毫秒值，当线程二所需时间大于join中的值，线程一就不等它了.
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                              
		System.out.println("thread one start");
	}
}
