package testJoin;

public class ThreadOne extends Thread{
	public void run(){
		System.out.println("thread one start");
		ThreadTwo two =new ThreadTwo();          //��two���뵽one��
		two.start();
		try {
			two.join(2000);                      //�̶߳������߳�һ���� ;join��Ҳ������Ӻ���ֵ�����̶߳�����ʱ�����join�е�ֵ���߳�һ�Ͳ�������.
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                              
		System.out.println("thread one start");
	}
}
