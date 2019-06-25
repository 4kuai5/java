package philosopher;

public class Philosopher extends Thread{
	
	public String pname;//��ѧ�ҵ�����
	private Chopstick left;
	private Chopstick right;
	private long time;
	
	public  Philosopher(String pname,Chopstick left,Chopstick right,long time){
		this.pname=pname;
		this.left=left;
		this.right=right;
		this.time=time;
	}
	public void run(){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (left) {
			System.out.println(this.pname+"���������ֱߵ�"+this.left.getNum()+"����");
			synchronized (right) {
				System.out.println(this.pname+"���������ֱߵ�"+this.right.getNum()+"����");
				System.out.println(this.pname+"��ѧ�ҳԷ�");
			}
		}
		
	}

}
