package myselfannotation;

public class Person { //domain实体对象 建议大家利用包装类
	
	private String name;
	private Integer age;
	private String sex;
	//自动注入属性的信息---->String字符串  产生一个注解  携带这些信息
	@MyAnnotation({"陈浩天","18","男"})
	public Person(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*  方法一
 * 	@MyAnnotation({"陈浩天","18","男"})       //当数组里只有一个元素时,{}可以省略  ; 当是value时,可以省略value
	private String  name;*/
}
