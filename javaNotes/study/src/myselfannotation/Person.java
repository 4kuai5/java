package myselfannotation;

public class Person { //domainʵ����� ���������ð�װ��
	
	private String name;
	private Integer age;
	private String sex;
	//�Զ�ע�����Ե���Ϣ---->String�ַ���  ����һ��ע��  Я����Щ��Ϣ
	@MyAnnotation({"�º���","18","��"})
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*  ����һ
 * 	@MyAnnotation({"�º���","18","��"})       //��������ֻ��һ��Ԫ��ʱ,{}����ʡ��  ; ����valueʱ,����ʡ��value
	private String  name;*/
}
