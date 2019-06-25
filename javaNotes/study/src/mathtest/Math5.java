package mathtest;
//合并两个数组
public class Math5 {

	public  int[] test(int[] array1,int[] array2){//需要两个数组               返回一个大的数组
		int[] s=new int[array1.length+array2.length]; //创建一个大数组
		//2.把两个数组分别存进大数组中
		for(int i=0;i<array1.length;i++){
			s[i] = array1[i];
		}
		for(int i=0;i<array2.length;i++){
			s[array1.length+i] = array2[i];
		}
		return s;
	} 
	
	public static void main(String[] args) {
		//1.创建两个小数组
		int[] a =new int[]{1,2,3,4};
		int[] b =new int[]{5,6,7,8};
		//3.创建对象
		Math5 m = new Math5();
		int[] s = m.test(a,b);                 //得到数组内的内存地址
		for(int value:s){                      //循环遍历出每个数值
			System.out.print(value);
		}
	}

}
