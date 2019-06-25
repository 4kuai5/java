package myselfannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MySpring {
	//���һi������  ��һ��������  ����һ������  �����ڵ�����ֵ������
	public Object getBean(String className){  //Objectͨ����
		Object obj =null;
		
		try {
			//1.ͨ�����ݵ�classname����ȡ��Ӧ����Class
			Class clazz = Class.forName(className);
			//2.ͨ��clazzz����һ���յĶ���
			//obj = clazz.newInstance();//���ù��췽��(��һ�ּ��׷���)
			Constructor con = clazz.getConstructor();//�ҵ������޲������췽��(�ڶ��ַ�������),������������Ǵ������Ĺ��췽��
			obj = con.newInstance();
			//3.���������Ժ�  �������ڵ����������Զ���ֵDI(����ע��)
			// ֵ--->�ļ� : �ô����ڴ����װ����.jar�����޸�  �ļ��������޸�
			//    .xml    �������ڿ�����ʱ��  Դ����������ļ�����һ��  ��ȡ/�޸ıȽ��鷳
			// ֵ--->ע�� : �ô����ڿ�����ʱ�򷽱�  Դ�����ע����һ��  ��ȡ/����ʱ��Ƚ�����
			//    @		   �������ڴ����װ������  ע����Я������Ϣ�����޸�
			//4.��ȡ���Ե�ֵ--->��ǰ����޲������췽��֮��
			Annotation a = con.getAnnotation(MyAnnotation.class);
			//5.��ȡaע�������Я������Ϣ---->person�������е�����ֵ
			Class aclazz = a.getClass();//a�����ȡ����Ӧ��Class
			Method amethod = aclazz.getMethod("value");
			String[] values =(String[])amethod.invoke(a);
			//6.��values�е�ÿһ��ֵ  ��Ӧ�ĸ�ֵ����
			//��Ѱ���Ե�set������ֵ
			Field[] fields = clazz.getDeclaredFields();//��ȡȫ����˽������
			for(int i=0;i<fields.length;i++){
				//��ȡ���Ե�����
				String fieldName=fields[i].getName();
				//����set�������ַ���
				String firstLetter = fieldName.substring(0, 1).toUpperCase();//substring:��ȡλ��;toUpperCase:����ĸ��д
				String otherLetter = fieldName.substring(1);
				//ƴ��
				StringBuffer setMethodName = new StringBuffer("set");
				setMethodName.append(firstLetter);
				setMethodName.append(otherLetter);
				//ͨ������õ�set���������ҵ���Ӧ��set����
				Class fieldType = fields[i].getType();
				Method setMethod = clazz.getMethod(setMethodName.toString(),fieldType );
				//ִ���ҵ���set����           ����Ӧ�����Ը�ֵ
				//��Ҫ��ע���ڶ�ȡ����String���͵�ֵת�����������Ͷ�Ӧ��ֵ
				setMethod.invoke(obj, fieldType.getConstructor(String.class).newInstance(values[i]));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}

}
