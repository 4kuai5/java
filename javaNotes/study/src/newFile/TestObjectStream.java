package newFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectStream {

	
	public static void main(String[] args) {
		
		//对象输出流
		//try {
			//将对象直接记录在文件中   永久保存   对象序列化
			//Person p1 =new Person("黄东雪",123);
			//FileOutputStream fos =new FileOutputStream("D://aaa/ddd.txt",true);
			//ObjectOutputStream oos= new ObjectOutputStream(fos);
			//oos.writeObject(p1); //将对象拆分成字节碎片 序列化到文件里
			//oos.flush();
		//} catch (IOException e) {
			//e.printStackTrace();
		//}

		//对象输入流
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
