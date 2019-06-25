package testreflect;

import java.lang.reflect.Method;

public class TestMethod {

	public static void main(String[] args) {
		try {
			//获取Person对应的Class
			Class clazz=Person.class;
			Person p=(Person)clazz.newInstance();           //创建反射对象
	 		//通过clazz获取其中的方法
			Method m = clazz.getMethod("eat",String.class); //方法名    通过方法参数对应的Class来找寻
			String result=(String)m.invoke(p,"测试参数");    //调用的方法有参数就填参数，有返回值就填返回值
			System.out.println(result);
			
			Method an = clazz.getMethod("sleep");           //同样可以调用出父类公有的方法
			an.invoke(p);
			
			Method[] ma=clazz.getMethods();                 //获取所有的公有方法(自己类+父类)
			
			Method s = clazz.getDeclaredMethod("testPrivate");//获取私有的方法
			System.out.println(s.getName());                 
			s.setAccessible(true);
			s.invoke(p, null);	
			/*int mm= m.getModifiers();                       //获取方法的修饰符(权限+特征)
			Class mrt= m.getReturnType();                   // 获取返回值数据类型
			String mn=m.getName();                          //获取方法的名字
			Class[] mpts= m.getParameterTypes();            //获取方法参数表的类型
			Class[] mets=m.getExceptionTypes();             //获取方法抛出异常的类型
*/			
		} catch (Exception e) {
			
			e.printStackTrace();
		}                    

	}

}
