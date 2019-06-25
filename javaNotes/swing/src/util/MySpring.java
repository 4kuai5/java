package util;

import java.util.HashMap;


//目的是为了管理对象的产生
//对象的控制权交给当前类来负责      IOC控制反转-----映射
//生命周期托管的方式实现了对象的单例
public class MySpring {

	//属性  为了存储所有被管理的对象
	private static HashMap<String,Object> beanBox = new HashMap<String,Object>();
	
	
	//设计一个方法  获取任何一个类的对象
	//返回值(泛型)  参数String 类名
	@SuppressWarnings("unchecked")
	public static   <T>T/* Object*/ getBean(String className){ //传递一个类全名
		//Object obj =null;
		T obj = null;
		try {
			
			//1.直接从beanBox里面获取
			//obj = beanBox.get(className);
			obj =(T) beanBox.get(className);
			//2.如果obj是null, 证明之前没有创建过这个对象
			if(obj==null){
				//3.通过类名字获取Class
				Class clazz = Class.forName(className);
				//4.通过反射产生一个对象
				//obj = clazz.newInstance();
				obj =(T)clazz.newInstance();
				//5.新的对象存入集合
				beanBox.put(className, obj);
			}
			
			/*//1.通过类名字获取Class                                  这下面是没写集合之前的
			Class clazz = Class.forName(className);
			//2.通过反射产生一个对象
			obj = clazz.newInstance();    //怎么产生对象--->new 一个 --->new的本质就是调用构造方法
*/		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
}
