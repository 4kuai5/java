package Prouduct;

import java.util.ArrayList;

public class Warehouse {

	//�ڲֿ��ﴴ��һ�����ϣ�������Ż���
	public ArrayList<String> list=new ArrayList<String>();//<�ŵ�������>
	//��ӻ���
	public synchronized void set(){                //synchronized �̰߳�ȫ��  һ��ʱ���ֻ��һ���߳̽��з���    �������ǵ�ǰ������������Ķ���
		if(list.size()<4){
			list.add("a");
		}else{
			//return;							  //�÷���ִ�е�����ͽ���
			try {
				this.notifyAll();                 //�໥����
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//ȡ������
	public synchronized void get(){
		if(list.size()>0){
			list.remove(0);                      //int index:����λ��  0Ϊ��һ��
		}else{
			//return;
			try {
				this.notifyAll();                //�໥����
				this.wait();                     //�ֿ���������wait  ���ǲֿ����ȴ�       ���ʲֿ���������߳̽���ȴ�״̬
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
