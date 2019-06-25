package thread;

import java.util.Vector;

public class System12306 {

	//����ģʽ ------------> ��ֻ֤��һ��ϵͳ�Ϳ�����
	private System12306(){}                          //1.����˽�еĹ��췽��(���ñ������new)
	private static System12306 sys=new System12306();//2.�Լ�newһ��(����ʽ)  private(��ȫ) static(Ψһ��һ��,ֻ��ʼ��һ��)
	public static System12306 getInstance(){//static:��֮ǰ��û�ж����,����֮��Ż��ж���; û������ô������-->ͨ������.����
		return sys;
	}
	//����   ����  Vector:�׶��̰߳�ȫ������ ;ArrayList:�׶��̲߳�̫��ȫ���ǿ�
	private Vector<Ticket>  tickets= new Vector<Ticket>();           //��Ʊ ������Ʊ����һ��������Ҫ��ȫ��
	
	//��ǰϵͳ�������tickets���ϳ�ʼ����ֵ
	{
		for(int i=10;i<100;i++){
			tickets.add(new Ticket("����"+i,"����"+i,(i%5+5)*25F));	//+i:��������վ������һ��
		}
	}
	
	//���һ������,�Ӽ�������Ʊ
	public Ticket getTicket(){
        try{
        	return tickets.remove(0);                 //�����˾����ߵ�һ��(index)
        }catch (Exception e){                         //���ȡû�ˣ��ͻ��׳�Խ���쳣   �����ֶ���һ��try-catch
        	return null;
        }
	}
}
