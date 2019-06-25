package testJoin;

public class ThreadTwo extends Thread{
	public void run(){                                 
	System.out.println("thread two start");  
	ThreadThree three=new ThreadThree(this);           //线程三锁定线程二，所以要有参数，参数是锁定的对象
	three.start();
	try {
		Thread.sleep(5000);                            //线程二要加入线程一中，所以线程一得等一下线程二
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("thread two end");
	}

}
