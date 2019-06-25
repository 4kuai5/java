package testreflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			Class clazz=Class.forName("testreflect.Person");
			Person p =(Person)clazz.newInstance();         //利用反射机制创建对象(方法一)
			/*Person p = new Person();*/                   //利用普通方法创建对象(方法二)
			//通过clazz来获取类中的属性
			Field f = clazz.getDeclaredField("name");      //获取私有属性   但是不能进行赋值
			System.out.println(f.getName());
			f.setAccessible(true);                         //加上这个就可以对私有属性进行赋值了
			f.set(p, "黄东雪");                             //存值
			System.out.println(p);
			String fname =(String)f.get(p);                //取值
			System.out.println(fname);
			
			/*
			Field[] fields = clazz.getFields();            //取出所有类中的属性 ,同时也取出了父类的公有属性
			System.out.println(fields.length);
			
			Field name =clazz.getField("name");            //首先得知道属性的名字，其次得是公有属性
			//操作属性  存值 
			name.set(p,"陈浩天");
			System.out.println(p);
			//取值
			String namef=(String) name.get(p);             //它不知道的你返回值类型是什么，所以造型
			System.out.println(namef);*/
			
			
			
			/*//自己的结构  赋值 取值
			int mod = name.getModifiers();                   //获取属性修饰符
			System.out.println(mod);
			Class fclass = name.getType();                   //获取属性的类型
			System.out.println(fclass.getName());
			String fname = name.getName();                   //获取属性名字
			System.out.println(fname);*/
			
			
			
			/*Person p = (Person)clazz.newInstance();        //相当于到调用了person类中无参数构造方法创建对象                        
			System.out.println(p);*/
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //反射类的三种方法之一
		
		/*//找出所有的接口父类
		ArrayList<String> list = new ArrayList<String>();
		//获取集合对应的那个Class
		Class clazz = ArrayList.class; 
		Class[] classes = clazz.getInterfaces();            //获取当前clazz的所有的父类接口
		for(Class c:classes){
			System.out.println(c.getName());
		}*/
		
	
		/*//找出所有继承的父类
		ArrayList<String> list = new ArrayList<String>();
		//获取集合对应的那个Class
		Class clazz = ArrayList.class;                         //反射类的三种方法之一
		Class sclass = clazz.getSuperclass();
		while(sclass!=null){
			System.out.println(sclass.getName());
			sclass = sclass.getSuperclass();
		}*/                                                   //只能获取继承的父类，没有接口
		
		
		/*try {
			//通过一个Class对象来操作Person.class类
			Class clazz=Class.forName("testreflect.Person"); //反射类的三种方法之一
			//类有自己的结构
			int mod=clazz.getModifiers();                    //返回修饰符，用整数进行表示
			System.out.println(mod);
			//获取类的名字
	 		String name = clazz.getName();                   //类全名，包名加类名                                    
			String simplename = clazz.getSimpleName();       //类名
			System.out.println(name);
			System.out.println(simplename);
			//获取类所在的包
			Package p = clazz.getPackage();
			System.out.println(p.getName());
			System.out.println("------------------------------------");
			Class pclass = clazz.getSuperclass();            //获取超类(父类)
			System.out.println(pclass.getName());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}

}
