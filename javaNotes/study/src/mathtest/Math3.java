package mathtest;
//第三题:设计一个方法 用来寻找元素是否在数组内存在(Scanner输入一个)
import java.util.Scanner;

public class Math3 {
	
	public String test(int[] array,int element){//参数:数组和目标元素          返回值:是否找到
		//3.循环方式找寻是否存在
		//4.做个标记查看是否找到
		String result="对不起没找到";
		//Boolean b=false;               //优化
		for(int i=0;i<=array.length;i++){
			if(array[i]==element){
				//b=true;                //优化
				result = "恭喜您找到了";   //return "恭喜您找到了";
				break;                   //找到了立即退出
			}
		}
		/*if(!b){                        //优化
			result = "对不起没找到";       //return "对不起没找到";
		}*/
		return result;                   //方法设计了返回值类型  就必须给返回值   名词:编译检测的悲观性原则12
	}	
	public static void main(String[] args) {
		//1.创建数组
		int[] s=new int[]{1,2,3,4,5,6,7,8,9};
		//2.创建对象
		Math3 m =new Math3();
		//5.写一个输入框
		Scanner sc=new Scanner(System.in);
		int e = sc.nextInt(); 
		String r = m.test(s, e);
		System.out.println(r);


	}

}
