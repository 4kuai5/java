package testJoin;

public class ThreadTwo extends Thread{
	public void run(){                                 
	System.out.println("thread two start");  
	ThreadThree three=new ThreadThree(this);           //�߳��������̶߳�������Ҫ�в����������������Ķ���
	three.start();
	try {
		Thread.sleep(5000);                            //�̶߳�Ҫ�����߳�һ�У������߳�һ�õ�һ���̶߳�
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("thread two end");
	}

}
