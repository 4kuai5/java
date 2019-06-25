package testreflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			Class clazz=Class.forName("testreflect.Person");
			Person p =(Person)clazz.newInstance();         //���÷�����ƴ�������(����һ)
			/*Person p = new Person();*/                   //������ͨ������������(������)
			//ͨ��clazz����ȡ���е�����
			Field f = clazz.getDeclaredField("name");      //��ȡ˽������   ���ǲ��ܽ��и�ֵ
			System.out.println(f.getName());
			f.setAccessible(true);                         //��������Ϳ��Զ�˽�����Խ��и�ֵ��
			f.set(p, "�ƶ�ѩ");                             //��ֵ
			System.out.println(p);
			String fname =(String)f.get(p);                //ȡֵ
			System.out.println(fname);
			
			/*
			Field[] fields = clazz.getFields();            //ȡ���������е����� ,ͬʱҲȡ���˸���Ĺ�������
			System.out.println(fields.length);
			
			Field name =clazz.getField("name");            //���ȵ�֪�����Ե����֣���ε��ǹ�������
			//��������  ��ֵ 
			name.set(p,"�º���");
			System.out.println(p);
			//ȡֵ
			String namef=(String) name.get(p);             //����֪�����㷵��ֵ������ʲô����������
			System.out.println(namef);*/
			
			
			
			/*//�Լ��Ľṹ  ��ֵ ȡֵ
			int mod = name.getModifiers();                   //��ȡ�������η�
			System.out.println(mod);
			Class fclass = name.getType();                   //��ȡ���Ե�����
			System.out.println(fclass.getName());
			String fname = name.getName();                   //��ȡ��������
			System.out.println(fname);*/
			
			
			
			/*Person p = (Person)clazz.newInstance();        //�൱�ڵ�������person�����޲������췽����������                        
			System.out.println(p);*/
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //����������ַ���֮һ
		
		/*//�ҳ����еĽӿڸ���
		ArrayList<String> list = new ArrayList<String>();
		//��ȡ���϶�Ӧ���Ǹ�Class
		Class clazz = ArrayList.class; 
		Class[] classes = clazz.getInterfaces();            //��ȡ��ǰclazz�����еĸ���ӿ�
		for(Class c:classes){
			System.out.println(c.getName());
		}*/
		
	
		/*//�ҳ����м̳еĸ���
		ArrayList<String> list = new ArrayList<String>();
		//��ȡ���϶�Ӧ���Ǹ�Class
		Class clazz = ArrayList.class;                         //����������ַ���֮һ
		Class sclass = clazz.getSuperclass();
		while(sclass!=null){
			System.out.println(sclass.getName());
			sclass = sclass.getSuperclass();
		}*/                                                   //ֻ�ܻ�ȡ�̳еĸ��࣬û�нӿ�
		
		
		/*try {
			//ͨ��һ��Class����������Person.class��
			Class clazz=Class.forName("testreflect.Person"); //����������ַ���֮һ
			//�����Լ��Ľṹ
			int mod=clazz.getModifiers();                    //�������η������������б�ʾ
			System.out.println(mod);
			//��ȡ�������
	 		String name = clazz.getName();                   //��ȫ��������������                                    
			String simplename = clazz.getSimpleName();       //����
			System.out.println(name);
			System.out.println(simplename);
			//��ȡ�����ڵİ�
			Package p = clazz.getPackage();
			System.out.println(p.getName());
			System.out.println("------------------------------------");
			Class pclass = clazz.getSuperclass();            //��ȡ����(����)
			System.out.println(pclass.getName());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}

}
