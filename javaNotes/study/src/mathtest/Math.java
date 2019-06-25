package mathtest;

public class Math {

	public static void main(String[] args) {
		// \转义字符:将身后的一个字符意思发生转换   比如\n 换行; \r回车;\t制表符(跟空格相似)
		System.out.println("\"helloword\"");
		//9*9 乘法表
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(j*i)+" ");
			}
			System.out.println("");
		}
	}
}
