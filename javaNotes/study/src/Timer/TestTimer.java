package Timer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class TestTimer {
	private int count=1;             //记录次数
	
	//属性 集合  存储所有人的电话号
	private ArrayList<String> userBox=new ArrayList<String>();
	{
		userBox.add("a");userBox.add("b");userBox.add("c");userBox.add("d");
	}
	//设计一个方法  做点坏事   垃圾短信
	//每隔一段时间  发送一些数据
	public void test() throws ParseException{
		System.out.println("要来了准备好");
		Timer timer=new Timer();  //启动一个小线程  做记录  每隔一段时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       //时间格式
		Date firstTimer=sdf.parse("2019-4-12 17:21:00");                        //转化时间
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("第"+count+++"次执行");
				for(int i=0;i<userBox.size();i++){
					System.out.println("给"+userBox.get(i)+"发送了一条消息：[黄东雪很美！！！]");
				}
				System.out.println("说了点实话真开心");
			}}, firstTimer, 3000);             //task 任务 ；time 时间 ；delay 多长时间以后；period 时间周期(毫秒)
	}
	public static void main(String[] args){
		TestTimer t1=new TestTimer();
		try {
			t1.test();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
