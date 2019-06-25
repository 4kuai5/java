package thread;

import java.util.Vector;

public class System12306 {

	//单例模式 ------------> 保证只有一个系统就可以了
	private System12306(){}                          //1.创建私有的构造方法(不让别人随便new)
	private static System12306 sys=new System12306();//2.自己new一下(饿汉式)  private(安全) static(唯一的一个,只初始化一次)
	public static System12306 getInstance(){//static:调之前是没有对象的,调用之后才会有对象; 没对象怎么调用呢-->通过类名.调用
		return sys;
	}
	//属性   集合  Vector:底端线程安全但是慢 ;ArrayList:底端线程不太安全但是快
	private Vector<Ticket>  tickets= new Vector<Ticket>();           //买票 两个人票不能一样，所以要安全的
	
	//当前系统创建后给tickets集合初始化赋值
	{
		for(int i=10;i<100;i++){
			tickets.add(new Ticket("北京"+i,"深圳"+i,(i%5+5)*25F));	//+i:作用是让站点名不一样
		}
	}
	
	//设计一个方法,从集合里拿票
	public Ticket getTicket(){
        try{
        	return tickets.remove(0);                 //来个人就拿走第一张(index)
        }catch (Exception e){                         //如果取没了，就会抛出越界异常   所以手动套一个try-catch
        	return null;
        }
	}
}
