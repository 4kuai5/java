package Prouduct;

public class Producer extends Thread{
	
	private Warehouse wh;
	public Producer(){}
	public Producer(Warehouse wh){
		this.wh=wh;
	}
	//������run������һֱ���ֿ���涫��
	public void run(){
		while(true){
			wh.set();
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
