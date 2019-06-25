package testreflect;

import java.lang.reflect.Constructor;

public class TestConstructor {

	public static void main(String[] args) {
		//找到person对应的Class
		Class clazz = Person.class;
		//clazz.newInstance();正常在这里就会初始化一个无参数构造方法
		//找到person无参数构造方法
		try {
			Constructor con = clazz.getConstructor(String.class);             //括号里只传参数
			//执行构造方法
			Person p = (Person)con.newInstance("name");                       //name传给了Person里的s
			System.out.println(p);
			con.getModifiers();                                               //修饰符
			con.getName();                                                    //名字
			con.getParameterTypes();                                          //参数类型
			con.getExceptionTypes();                                          //异常类型
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                      
	}

}
