package mathtest;
//�ϲ���������
public class Math5 {

	public  int[] test(int[] array1,int[] array2){//��Ҫ��������               ����һ���������
		int[] s=new int[array1.length+array2.length]; //����һ��������
		//2.����������ֱ�����������
		for(int i=0;i<array1.length;i++){
			s[i] = array1[i];
		}
		for(int i=0;i<array2.length;i++){
			s[array1.length+i] = array2[i];
		}
		return s;
	} 
	
	public static void main(String[] args) {
		//1.��������С����
		int[] a =new int[]{1,2,3,4};
		int[] b =new int[]{5,6,7,8};
		//3.��������
		Math5 m = new Math5();
		int[] s = m.test(a,b);                 //�õ������ڵ��ڴ��ַ
		for(int value:s){                      //ѭ��������ÿ����ֵ
			System.out.print(value);
		}
	}

}
