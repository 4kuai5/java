package mathtest;

public class Math1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//找寻2-100之间的素数(质数)   只能被1和本身整除的数字 2 3 5 7 11
		//先把1和自身这两个数刨除掉
		for(int num=2;num<=100;num++){
		boolean x=false;   //做个标记   boolean类型占用内存空间小
		for(int i=2;i<=num-1;i++){     //优化可以写成num/2
			if(num%i==0){
				System.out.println(num+"不是素数");
				x=true;
				break; //不是中断if,当满足if条件的时候中断循环
			}
			
		}
		if(x==false){  //上面那个循环执行完毕,里面的if从来没有执行过
			System.out.println(num+"是素数");
		}
	}
	}		
}
