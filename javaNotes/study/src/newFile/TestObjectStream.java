package newFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectStream {

	
	public static void main(String[] args) {
		
		//���������
		//try {
			//������ֱ�Ӽ�¼���ļ���   ���ñ���   �������л�
			//Person p1 =new Person("�ƶ�ѩ",123);
			//FileOutputStream fos =new FileOutputStream("D://aaa/ddd.txt",true);
			//ObjectOutputStream oos= new ObjectOutputStream(fos);
			//oos.writeObject(p1); //�������ֳ��ֽ���Ƭ ���л����ļ���
			//oos.flush();
		//} catch (IOException e) {
			//e.printStackTrace();
		//}

		//����������
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://aaa//ddd.txt"));
			Person p=(Person)ois.readObject();
			System.out.println(p);
			p.eat();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
