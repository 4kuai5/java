package Prouduct;

public class Consumer extends Thread{
	//创建同一个仓库对象
	private Warehouse wh;
	public Consumer(){}
	public Consumer(Warehouse wh){
		this.wh=wh;
	}
	//当仓库里有东西时，就一直取货物
	public 	void run(){
		while(true){
			wh.get();
			System.out.println("消费者消费了一件货物");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
