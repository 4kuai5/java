package student;

public class Computer {
	
	//��5̨���ԣ����б�һ�����
	private int number;
	//���Ե�״̬
	private boolean state=false;
	//�������췽��
	public Computer(){}
	public Computer(int number){
		this.number=number;
	}
	//��ȡ���Եı��
	public int getNumber(){
		return this.number;
	}
	//��ȡ���Ե�״̬
	public boolean isUsed(){
		return this.state;
	}
	
	public void open(){ 
		this.state=true;
		System.out.println(this.number+"�ŵ��Դ���");
		
	}
	public void use(){
		System.out.println(this.number+"�ŵ���ʹ����");
		
	}
	public void close(){
		this.state=false;
		System.out.println(this.number+"�ŵ��Թر���");
		
	}
}
