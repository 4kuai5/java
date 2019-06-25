package testreflect;

public class Person extends Animal{
	private String name;
	public String age;
	public Person(){
		System.out.println("我是Person无参数构造方法");
	}
	public Person(String s){
		System.out.println("我是Person有String参数构造方法");
	}
	

	public String toString(){
		return "{"+name+","+age+"}";
	}
	
	public void eat(){
		System.out.println("我是person的方法");	
	}
	public 	String eat(String s){
		System.out.println("我是Person带参数的方法");
		return s;
	}
	private void testPrivate(){
		System.out.println("我是私有的");
	}
	
	
}
