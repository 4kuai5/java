package student;

public class MachineRoom {

	//机房--电脑:聚合关系    机房内有电脑   
	//机房内有5电脑   先来个数组类型的
	public Computer[] computers = new Computer[5];
	
	//程序块   在构造方法之前想做点事情，这功夫就可以用了
	{                                                            //第二种方法     在构造方法之前你new对象的时候就会自动进行调用
		for(int i=0;i<computers.length;i++){
			computers[i]=new Computer(i+1);     //赋值
		}
	}
	/*//设计一个方法  用来给电脑进行初始化赋值                                                     第一种方法
	public void init(){
		for(int i=0;i<computers.length;i++){
			computers[i]=new Computer(i+1);     //赋值
		}
	}
	//赋值之后需要调用一下          不调用就会引发空指针异常
	public MachineRoom(){
		this.init();
	}*/
	public void welcome(Student s){
		String name=s.getName();
		System.out.println("欢迎"+name+"进入机房");
		//学生进来之后开始找寻电脑
		for(int i=0;i<computers.length;i++){
			boolean computersState = computers[i].isUsed();      //需要判断当前电脑的状态
			if(computersState==false){//表示当前电脑无人使用
				s.useComputer(computers[i]);
				break;
			}
		}	
	}
}
