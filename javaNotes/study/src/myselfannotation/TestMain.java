package myselfannotation;

public class TestMain {
	
	public static void main(String[] args){
		
		//��ȡһ��Person����         �����Լ���ֵ           ������Ҫ     MySpring
		//����Ĵ���Ȩ����ת(IOC)     ��ֵ(�Զ�DI)     ���˴���
		MySpring  ms = new MySpring();//������    �����Ǵ�������    �Զ���ֵ
		Person p = (Person)ms.getBean("myselfannotation.Person");
		System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
		
		/*try {
			//����Person���У����������ע����Ϣ  ��Ҫ�õ����似��
			//1.��ȡPerson��Ӧ����Class
			Class clazz = Person.class;
			//2.ͨ��clazz��ȡ���������
			Field field = clazz.getDeclaredField("name");
			//3.ͨ��field��ȡ�����ע�����
			Annotation a =field.getAnnotation(MyAnnotation.class);  //(ע�������); a�൱��@MyAnnotation({})
			//4.���÷���ִ��a�е�value����
			Class aclazz = a.getClass();//a�����ȡ����Ӧ��Class
			//5.ͨ��aclazz��ȡ����value����
			Method amethod = aclazz.getMethod("value");
			//6.ִ��value�ķ���,��ȡ���ݵ���Ϣ
			String[] values =(String[])amethod.invoke(a); //�����Ķ���,����ִ��ʱ��Ҫ�Ĳ���;invoke��Objectͨ������Ҫ
			//7.չʾһ��values�ڵ���Ϣ
			for(String value:values){
				System.out.println(value);
			}*/
			
			//���������������ִ�й���
			/*//3.ͨ��field��ȡ�����ע�����
			Annotation a =field.getAnnotation(MyAnnotation.class);  //(ע�������); a�൱��@MyAnnotation({})
			//��������������д,����������һ����̬��Ч����������.�����������˽�з�����----->������Ҫ����
			MyAnnotation a =(MyAnnotation)field.getAnnotation(MyAnnotation.class);
			//4.����a����ִ��һ��value�ķ���   �����ǰ��˹�����
			String[] values =a.value();
			System.out.println(values[0]);*/
			
			
		/*	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//3.
	}
}
