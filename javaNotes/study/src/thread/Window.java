package thread;
//��Ϊ��ͬһʱ��Σ����в�ͬ�Ĵ��ڳ�Ʊ�����Ƕ��߳� 
public class Window extends Thread {
	
	private String windowName;                             //���ڵ�����
	public Window(String windowName){
		this.windowName=windowName;
	}
	
	public void run(){
		this.sellTicket();                                //run�����ﾡ����д���룬����ȡ��������ķ���
	}
	//��Ʊ
	public void sellTicket(){
		while(true){                                     //ѭ����Ʊ(һֱ��)
			System12306 sys=System12306.getInstance();   //����ģʽ,����.����
			Ticket ticket=sys.getTicket();
			if(ticket==null){
				System.out.println("�Բ���"+this.windowName+"���ڳ�Ʊ�Ѿ�����");
				break;
			}
			System.out.println("��"+windowName+"�۳���"+ticket);
		}
	}

}
