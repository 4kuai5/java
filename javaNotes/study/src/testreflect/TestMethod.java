package testreflect;

import java.lang.reflect.Method;

public class TestMethod {

	public static void main(String[] args) {
		try {
			//��ȡPerson��Ӧ��Class
			Class clazz=Person.class;
			Person p=(Person)clazz.newInstance();           //�����������
	 		//ͨ��clazz��ȡ���еķ���
			Method m = clazz.getMethod("eat",String.class); //������    ͨ������������Ӧ��Class����Ѱ
			String result=(String)m.invoke(p,"���Բ���");    //���õķ����в�������������з���ֵ�����ֵ
			System.out.println(result);
			
			Method an = clazz.getMethod("sleep");           //ͬ�����Ե��ó����๫�еķ���
			an.invoke(p);
			
			Method[] ma=clazz.getMethods();                 //��ȡ���еĹ��з���(�Լ���+����)
			
			Method s = clazz.getDeclaredMethod("testPrivate");//��ȡ˽�еķ���
			System.out.println(s.getName());                 
			s.setAccessible(true);
			s.invoke(p, null);	
			/*int mm= m.getModifiers();                       //��ȡ���������η�(Ȩ��+����)
			Class mrt= m.getReturnType();                   // ��ȡ����ֵ��������
			String mn=m.getName();                          //��ȡ����������
			Class[] mpts= m.getParameterTypes();            //��ȡ���������������
			Class[] mets=m.getExceptionTypes();             //��ȡ�����׳��쳣������
*/			
		} catch (Exception e) {
			
			e.printStackTrace();
		}                    

	}

}
