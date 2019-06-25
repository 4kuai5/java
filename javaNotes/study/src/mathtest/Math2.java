package mathtest;
//第一题:设计一个方法  用来交换一个数据(头尾互换)
public class Math2 {
	
	public void changeTest(int[] array){
		//2.将数组内部的元素头尾进行互换
		for(int i=0;i<array.length/2;i++){
			int temp=array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=temp;
		}
		
	}
	public static void main(String[] args) {
		//创建对象
		Math2 m= new Math2();
		//1.有一个数组
		int[] x=new int[]{1,2,3,4,5,6};
		//调用对象
		m.changeTest(x);
		//3.验证看一下结果
		for(int v:x){
			System.out.print(v);
		}
	}
}
