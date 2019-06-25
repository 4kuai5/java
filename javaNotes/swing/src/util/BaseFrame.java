package util;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame{

	//ģ��ģʽ
	
	//���һ������  �κδ�����Ҫ������   ִ�����̶̹�
	
	public BaseFrame(){}
	public BaseFrame(String title){
		super(title);
	}
	
	protected void init(){
		this.set();
		this.addElement();
		this.addListener();
		this.setFrameSelf();
	}
	
	
	//1.����  ����  ��ɫ  ����  ���� �ȵ�
	protected abstract void set();
	
	//2.��������ӵ�������
	protected abstract void addElement();
	
	//3.����¼�����
	protected abstract void addListener();
	
	//4.���ô�������
	protected abstract void setFrameSelf();
}
