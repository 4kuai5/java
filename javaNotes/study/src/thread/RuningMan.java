package thread;
//�̵߳����ַ���֮һ
public class RuningMan extends Thread {
	
	private String name;
	
	public RuningMan(){}
	public RuningMan(String name){
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
		r1.start();//��thread���м̳й����ķ���
		r2.start();
		r3.start();
		

	}

}
