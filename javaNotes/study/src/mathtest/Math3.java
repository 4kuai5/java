package mathtest;
//������:���һ������ ����Ѱ��Ԫ���Ƿ��������ڴ���(Scanner����һ��)
import java.util.Scanner;

public class Math3 {
	
	public String test(int[] array,int element){//����:�����Ŀ��Ԫ��          ����ֵ:�Ƿ��ҵ�
		//3.ѭ����ʽ��Ѱ�Ƿ����
		//4.������ǲ鿴�Ƿ��ҵ�
		String result="�Բ���û�ҵ�";
		//Boolean b=false;               //�Ż�
		for(int i=0;i<=array.length;i++){
			if(array[i]==element){
				//b=true;                //�Ż�
				result = "��ϲ���ҵ���";   //return "��ϲ���ҵ���";
				break;                   //�ҵ��������˳�
			}
		}
		/*if(!b){                        //�Ż�
			result = "�Բ���û�ҵ�";       //return "�Բ���û�ҵ�";
		}*/
		return result;                   //��������˷���ֵ����  �ͱ��������ֵ   ����:������ı�����ԭ��12
	}	
	public static void main(String[] args) {
		//1.��������
		int[] s=new int[]{1,2,3,4,5,6,7,8,9};
		//2.��������
		Math3 m =new Math3();
		//5.дһ�������
		Scanner sc=new Scanner(System.in);
		int e = sc.nextInt(); 
		String r = m.test(s, e);
		System.out.println(r);


	}

}
