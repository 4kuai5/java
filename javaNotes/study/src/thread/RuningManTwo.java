package thread;
//�̵߳����ַ���֮һ
public class RuningManTwo implements Runnable {
	
	private String name;
	
	public  RuningManTwo(){}
	public  RuningManTwo(String name){
		this.name=name;
	}
	//��дrun����
	public void run(){
		for(int i=1;i<=100;i++){
			System.out.println(this.name+"�ܵ���"+i+"����");
		}
	}
	public static void main(String[] args) {
		//1.����һ���̶߳���
		RuningMan r1=new RuningMan("�ձ���");
		RuningMan r2=new RuningMan("������");
		RuningMan r3=new RuningMan("������");
		//2.����start����,���߳̽������״̬
		Thread t1=new Thread(r1);
		t1.start();//��thread���м̳й����ķ���
		Thread t2=new Thread(r2);
		t2.start();//��thread���м̳й����ķ���
		Thread t3=new Thread(r3);
		t3.start();//��thread���м̳й����ķ���
	}

}
