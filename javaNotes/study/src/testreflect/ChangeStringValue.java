package testreflect;

import java.lang.reflect.Field;

public class ChangeStringValue {

	
	public static void main(String[] args) throws Exception {
		/*String str="abc";*/                                           //Ҳ������ôд
		String str=new String("str");
		System.out.println(str);
		//������Ի�ȡ˽������   ���Բ���˽������        ������
		//1.��ȡString���Ӧ���Ǹ�Class
		Class clazz = str.getClass();                                  //������Ƶ����ַ���֮һ
		//2.ͨ��clazz��ȡ���е�value����
		Field field = clazz.getDeclaredField("value");
		//3.ֱ�Ӳ������Ե�ֵ�����Ե�      ������˽�����Կ��Ա�����
		field.setAccessible(true);
		//4.private final char[] value ={'a','b','c'};���Ը�ֵ  �����ǲ��ܸĵ�ַ
		//����Ҫ��ȡvalue���������ֵ(�ڴ��ַ)
		char[] temp = (char[])field.get(str);
		//5.ͨ��temp�ĵ�ַ���ã��ҵ���ʵString�����е����飬�޸������ڵ�ÿһ��Ԫ��
		temp[0]='��'; temp[1]='��'; temp[2]='��';
		//�������һ��str��ֵ                                               
		System.out.println(str);                                       
		//String���ɸı䳤�Ⱥ����� ��������Ĳ��ɸı䣬����������Ȼ��˽�����Կ����������ǿ���ͨ����������޸��������������ֵ
	}

}
