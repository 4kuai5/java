package testreflect;

import java.lang.reflect.Field;

public class ChangeStringValue {

	
	public static void main(String[] args) throws Exception {
		/*String str="abc";*/                                           //也可以这么写
		String str=new String("str");
		System.out.println(str);
		//反射可以获取私有属性   可以操作私有属性        不合理
		//1.获取String类对应的那个Class
		Class clazz = str.getClass();                                  //反射机制的三种方法之一
		//2.通过clazz获取类中的value属性
		Field field = clazz.getDeclaredField("value");
		//3.直接操作属性的值不可以的      得设置私有属性可以被操作
		field.setAccessible(true);
		//4.private final char[] value ={'a','b','c'};可以改值  ，但是不能改地址
		//所以要获取value属性里面的值(内存地址)
		char[] temp = (char[])field.get(str);
		//5.通过temp的地址引用，找到真实String对象中的数组，修改数组内的每一个元素
		temp[0]='陈'; temp[1]='浩'; temp[2]='天';
		//最终输出一个str的值                                               
		System.out.println(str);                                       
		//String不可改变长度和内容 ，长度真的不可改变，但是内容虽然是私有属性看不到，但是可以通过反射机制修改内容里面的属性值
	}

}
