package student;

public class Student {
	
	private String name;
	//获取学生姓名
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
		System.out.println(this.name+"正在使用电脑");
		computer.open();
		computer.use();
		if(RP>5){
			computer.close();
			System.out.println(this.name+"人品很好关机了");
		}else{
			System.out.println(this.name+"人品不咋地！走了不关电脑");
		}
	}

}
