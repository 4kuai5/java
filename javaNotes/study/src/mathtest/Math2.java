package mathtest;
//��һ��:���һ������  ��������һ������(ͷβ����)
public class Math2 {
	
	public void changeTest(int[] array){
		//2.�������ڲ���Ԫ��ͷβ���л���
		for(int i=0;i<array.length/2;i++){
			int temp=array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=temp;
		}
		
	}
	public static void main(String[] args) {
		//��������
		Math2 m= new Math2();
		//1.��һ������
		int[] x=new int[]{1,2,3,4,5,6};
		//���ö���
		m.changeTest(x);
		//3.��֤��һ�½��
		for(int v:x){
			System.out.print(v);
		}
	}
}
