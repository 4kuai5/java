package mathtest;
//�ڶ���: ����Ѱ�������еļ�ֵ(���ֵ �� ��Сֵ)
public class Math4 {
	
	public int test(int[] array,boolean flag){//true��ʾ�����ֵ,flase��ʾ��Сֵ
		//2.��һ������������ֵ
		int temp=array[0];
		//3.���ñ�������ķ�ʽ������max�Ƚ�
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
		//��������
		Math4 m=new Math4();
		//1.����һ������
		int[] s=new int[]{2,5,4,6,1,9};
		int value = m.test(s,false);
		//4.������
		System.out.println("����������ֵΪ"+value);
		

	}

}
