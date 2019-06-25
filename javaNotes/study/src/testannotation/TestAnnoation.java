package testannotation;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解(自己定义注解)
//注解的作用(最主要的就是可以携带一些信息(内容))

@Target({FIELD,METHOD,CONSTRUCTOR}) //描述当前的这个注解可以放置在哪里写的
@Retention(RetentionPolicy.RUNTIME)//描述当前的这个注解存在什么作用域中的            
//作用域:源代码代码(SOURCE)--->(编译)--->字节码(CLASS)--->(加载)--->内存执行(RUNTIME)
@Inherited//描述当前注解是否能被之类对象继承   (写上就能)
public @interface TestAnnoation {

	//public static final String test="asd";//比较少见
	
	
	public abstract String test();//注解方法必须要求有返回值(接口不用)   //方法--->必须传递(相当于把我们的信息传递给别人)
	//返回值类型:1.基本数据类型    2.String  3.枚举类型enum  4.注解类型@  5.数组类型[],数组的内部需要是如上的四种类型 
	
	
}
