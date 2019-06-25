package myselfannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD})  //可以放在类的构造方法上，方法上，属性上
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	public abstract String[] value();//从Person注解中得到里面的值,传到value方法里,执行一下,把Stringp[]类型的返回值输出出来

}
