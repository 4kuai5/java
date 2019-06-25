package thread;
//因为在同一时间段，会有不同的窗口出票所以是多线程 
public class Window extends Thread {
	
	private String windowName;                             //窗口的名字
	public Window(String windowName){
		this.windowName=windowName;
	}
	
	public void run(){
		this.sellTicket();                                //run方法里尽量少写代码，所以取调用下面的方法
	}
	//出票
	public void sellTicket(){
		while(true){                                     //循环买票(一直卖)
			System12306 sys=System12306.getInstance();   //单例模式,类名.调用
			Ticket ticket=sys.getTicket();
			if(ticket==null){
				System.out.println("对不起"+this.windowName+"窗口车票已经买完");
				break;
			}
			System.out.println("从"+windowName+"售出："+ticket);
		}
	}

}
