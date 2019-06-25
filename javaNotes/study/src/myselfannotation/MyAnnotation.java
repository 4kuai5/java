package myselfannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD})  //���Է�����Ĺ��췽���ϣ������ϣ�������
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	public abstract String[] value();//��Personע���еõ������ֵ,����value������,ִ��һ��,��Stringp[]���͵ķ���ֵ�������

}
