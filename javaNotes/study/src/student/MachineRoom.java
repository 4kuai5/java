package student;

public class MachineRoom {

	//����--����:�ۺϹ�ϵ    �������е���   
	//��������5����   �������������͵�
	public Computer[] computers = new Computer[5];
	
	//�����   �ڹ��췽��֮ǰ���������飬�⹦��Ϳ�������
	{                                                            //�ڶ��ַ���     �ڹ��췽��֮ǰ��new�����ʱ��ͻ��Զ����е���
		for(int i=0;i<computers.length;i++){
			computers[i]=new Computer(i+1);     //��ֵ
		}
	}
	/*//���һ������  ���������Խ��г�ʼ����ֵ                                                     ��һ�ַ���
	public void init(){
		for(int i=0;i<computers.length;i++){
			computers[i]=new Computer(i+1);     //��ֵ
		}
	}
	//��ֵ֮����Ҫ����һ��          �����þͻ�������ָ���쳣
	public MachineRoom(){
		this.init();
	}*/
	public void welcome(Student s){
		String name=s.getName();
		System.out.println("��ӭ"+name+"�������");
		//ѧ������֮��ʼ��Ѱ����
		for(int i=0;i<computers.length;i++){
			boolean computersState = computers[i].isUsed();      //��Ҫ�жϵ�ǰ���Ե�״̬
			if(computersState==false){//��ʾ��ǰ��������ʹ��
				s.useComputer(computers[i]);
				break;
			}
		}	
	}
}
