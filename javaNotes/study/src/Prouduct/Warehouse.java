package Prouduct;

import java.util.ArrayList;

public class Warehouse {

	//在仓库里创建一个集合，用来存放货物
	public ArrayList<String> list=new ArrayList<String>();//<放的是类型>
	//添加货物
	public synchronized void set(){                //synchronized 线程安全锁  一个时间点只有一个线程进行访问    锁定的是当前调用这个方法的对象
		if(list.size()<4){
			list.add("a");
		}else{
			//return;							  //让方法执行到这里就结束
			try {
				this.notifyAll();                 //相互唤醒
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//取出货物
	public synchronized void get(){
		if(list.size()>0){
			list.remove(0);                      //int index:索引位置  0为第一个
		}else{
			//return;
			try {
				this.notifyAll();                //相互唤醒
				this.wait();                     //仓库对象调用用wait  不是仓库对象等待       访问仓库的消费者线程进入等待状态
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
