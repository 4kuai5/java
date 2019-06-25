package student;

public class Computer {
	
	//有5台电脑，所有编一个序号
	private int number;
	//电脑的状态
	private boolean state=false;
	//创建构造方法
	public Computer(){}
	public Computer(int number){
		this.number=number;
	}
	//获取电脑的编号
	public int getNumber(){
		return this.number;
	}
	//获取电脑的状态
	public boolean isUsed(){
		return this.state;
	}
	
	public void open(){ 
		this.state=true;
		System.out.println(this.number+"号电脑打开了");
		
	}
	public void use(){
		System.out.println(this.number+"号电脑使用中");
		
	}
	public void close(){
		this.state=false;
		System.out.println(this.number+"号电脑关闭了");
		
	}
}
