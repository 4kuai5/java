package mathtest;

public class Math1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��Ѱ2-100֮�������(����)   ֻ�ܱ�1�ͱ������������� 2 3 5 7 11
		//�Ȱ�1���������������ٳ���
		for(int num=2;num<=100;num++){
		boolean x=false;   //�������   boolean����ռ���ڴ�ռ�С
		for(int i=2;i<=num-1;i++){     //�Ż�����д��num/2
			if(num%i==0){
				System.out.println(num+"��������");
				x=true;
				break; //�����ж�if,������if������ʱ���ж�ѭ��
			}
			
		}
		if(x==false){  //�����Ǹ�ѭ��ִ�����,�����if����û��ִ�й�
			System.out.println(num+"������");
		}
	}
	}		
}
