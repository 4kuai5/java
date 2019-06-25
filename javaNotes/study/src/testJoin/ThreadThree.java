package testJoin;

public class ThreadThree extends Thread{
	private ThreadTwo two;
	public ThreadThree(ThreadTwo two){
		this.two=two;
	}
	public void run(){                          //��д�������ܴ���
		//��twoִ�й�����  one�ȴ��Ĺ�����   three��two��������
		System.out.println("thread three start");
		synchronized (two) {
			System.out.println("two is locked");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("two is free");
		}
		System.out.println("thread three end");
	}

}
