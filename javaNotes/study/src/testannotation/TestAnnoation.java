package testannotation;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע��(�Լ�����ע��)
//ע�������(����Ҫ�ľ��ǿ���Я��һЩ��Ϣ(����))

@Target({FIELD,METHOD,CONSTRUCTOR}) //������ǰ�����ע����Է���������д��
@Retention(RetentionPolicy.RUNTIME)//������ǰ�����ע�����ʲô�������е�            
//������:Դ�������(SOURCE)--->(����)--->�ֽ���(CLASS)--->(����)--->�ڴ�ִ��(RUNTIME)
@Inherited//������ǰע���Ƿ��ܱ�֮�����̳�   (д�Ͼ���)
public @interface TestAnnoation {

	//public static final String test="asd";//�Ƚ��ټ�
	
	
	public abstract String test();//ע�ⷽ������Ҫ���з���ֵ(�ӿڲ���)   //����--->���봫��(�൱�ڰ����ǵ���Ϣ���ݸ�����)
	//����ֵ����:1.������������    2.String  3.ö������enum  4.ע������@  5.��������[],������ڲ���Ҫ�����ϵ��������� 
	
	
}
