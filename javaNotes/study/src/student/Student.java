package student;

public class Student {
	
	private String name;
	//��ȡѧ������
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name){
		this.name=name;
	}
	private int RP=(int)(Math.random()*10);
	
	public void useComputer(Computer computer){
		System.out.println(this.name+"����ʹ�õ���");
		computer.open();
		computer.use();
		if(RP>5){
			computer.close();
			System.out.println(this.name+"��Ʒ�ܺùػ���");
		}else{
			System.out.println(this.name+"��Ʒ��զ�أ����˲��ص���");
		}
	}

}
