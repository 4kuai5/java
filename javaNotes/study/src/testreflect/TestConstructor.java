package testreflect;

import java.lang.reflect.Constructor;

public class TestConstructor {

	public static void main(String[] args) {
		//�ҵ�person��Ӧ��Class
		Class clazz = Person.class;
		//clazz.newInstance();����������ͻ��ʼ��һ���޲������췽��
		//�ҵ�person�޲������췽��
		try {
			Constructor con = clazz.getConstructor(String.class);             //������ֻ������
			//ִ�й��췽��
			Person p = (Person)con.newInstance("name");                       //name������Person���s
			System.out.println(p);
			con.getModifiers();                                               //���η�
			con.getName();                                                    //����
			con.getParameterTypes();                                          //��������
			con.getExceptionTypes();                                          //�쳣����
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                      
	}

}
