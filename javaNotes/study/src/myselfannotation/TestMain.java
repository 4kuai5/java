package myselfannotation;

public class TestMain {
	
	public static void main(String[] args){
		
		//获取一个Person对象         不用自己赋值           跟别人要     MySpring
		//对象的创建权利反转(IOC)     赋值(自动DI)     别人处理
		MySpring  ms = new MySpring();//管理者    帮我们创建对象    自动赋值
		Person p = (Person)ms.getBean("myselfannotation.Person");
		System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
		
		/*try {
			//解析Person类中，属性上面的注解信息  需要用到反射技术
			//1.获取Person对应的类Class
			Class clazz = Person.class;
			//2.通过clazz获取里面的属性
			Field field = clazz.getDeclaredField("name");
			//3.通过field获取上面的注解对象
			Annotation a =field.getAnnotation(MyAnnotation.class);  //(注解的类型); a相当于@MyAnnotation({})
			//4.利用反射执行a中的value方法
			Class aclazz = a.getClass();//a对象获取它对应的Class
			//5.通过aclazz获取里面value方法
			Method amethod = aclazz.getMethod("value");
			//6.执行value的方法,获取传递的信息
			String[] values =(String[])amethod.invoke(a); //所属的对象,方法执行时需要的参数;invoke是Object通用形需要
			//7.展示一下values内的信息
			for(String value:values){
				System.out.println(value);
			}*/
			
			//这是正常对象调用执行过程
			/*//3.通过field获取上面的注解对象
			Annotation a =field.getAnnotation(MyAnnotation.class);  //(注解的类型); a相当于@MyAnnotation({})
			//正常是上面那样写,但是上面是一个多态的效果，父类是.不出来子类的私有方法的----->所以需要造型
			MyAnnotation a =(MyAnnotation)field.getAnnotation(MyAnnotation.class);
			//4.利用a对象执行一下value的方法   帮我们搬运过来了
			String[] values =a.value();
			System.out.println(values[0]);*/
			
			
		/*	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//3.
	}
}
