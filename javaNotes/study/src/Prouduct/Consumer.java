package Prouduct;

public class Consumer extends Thread{
	//����ͬһ���ֿ����
	private Warehouse wh;
	public Consumer(){}
	public Consumer(Warehouse wh){
		this.wh=wh;
	}
	//���ֿ����ж���ʱ����һֱȡ����
	public 	void run(){
		while(true){
			wh.get();
			System.out.println("������������һ������");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
