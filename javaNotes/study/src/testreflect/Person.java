package testreflect;

public class Person extends Animal{
	private String name;
	public String age;
	public Person(){
		System.out.println("����Person�޲������췽��");
	}
	public Person(String s){
		System.out.println("����Person��String�������췽��");
	}
	

	public String toString(){
		return "{"+name+","+age+"}";
	}
	
	public void eat(){
		System.out.println("����person�ķ���");	
	}
	public 	String eat(String s){
		System.out.println("����Person�������ķ���");
		return s;
	}
	private void testPrivate(){
		System.out.println("����˽�е�");
	}
	
	
}
