package mathtest;
//第二题: 用来寻找数组中的极值(最大值 或 最小值)
public class Math4 {
	
	public int test(int[] array,boolean flag){//true表示找最大值,flase表示最小值
		//2.找一个变量用来存值
		int temp=array[0];
		//3.利用遍历数组的方式挨个与max比较
		for(int i=1;i<array.length;i++){
		if(flag&&array[i]>temp){
				temp = array[i];

		}else if(flag&&array[i]<temp){
				temp= array[i];
			}
		}
		return temp;	
	}
	public static void main(String[] args) {
		//创建对象
		Math4 m=new Math4();
		//1.创建一个数组
		int[] s=new int[]{2,5,4,6,1,9};
		int value = m.test(s,false);
		//4.输出结果
		System.out.println("数组里的最大值为"+value);
		

	}

}
