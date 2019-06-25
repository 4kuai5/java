package util;

import java.util.HashMap;


//Ŀ����Ϊ�˹������Ĳ���
//����Ŀ���Ȩ������ǰ��������      IOC���Ʒ�ת-----ӳ��
//���������йܵķ�ʽʵ���˶���ĵ���
public class MySpring {

	//����  Ϊ�˴洢���б�����Ķ���
	private static HashMap<String,Object> beanBox = new HashMap<String,Object>();
	
	
	//���һ������  ��ȡ�κ�һ����Ķ���
	//����ֵ(����)  ����String ����
	@SuppressWarnings("unchecked")
	public static   <T>T/* Object*/ getBean(String className){ //����һ����ȫ��
		//Object obj =null;
		T obj = null;
		try {
			
			//1.ֱ�Ӵ�beanBox�����ȡ
			//obj = beanBox.get(className);
			obj =(T) beanBox.get(className);
			//2.���obj��null, ֤��֮ǰû�д������������
			if(obj==null){
				//3.ͨ�������ֻ�ȡClass
				Class clazz = Class.forName(className);
				//4.ͨ���������һ������
				//obj = clazz.newInstance();
				obj =(T)clazz.newInstance();
				//5.�µĶ�����뼯��
				beanBox.put(className, obj);
			}
			
			/*//1.ͨ�������ֻ�ȡClass                                  ��������ûд����֮ǰ��
			Class clazz = Class.forName(className);
			//2.ͨ���������һ������
			obj = clazz.newInstance();    //��ô��������--->new һ�� --->new�ı��ʾ��ǵ��ù��췽��
*/		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
}
