package Prouduct;

public class Producer extends Thread{
	
	private Warehouse wh;
	public Producer(){}
	public Producer(Warehouse wh){
		this.wh=wh;
	}
	//生产者run方法，一直往仓库里存东西
	public void run(){
		while(true){
			wh.set();
			System.out.println("生产者生产了一件货物");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
