package mathtest;

public class Math {

	public static void main(String[] args) {
		// \ת���ַ�:������һ���ַ���˼����ת��   ����\n ����; \r�س�;\t�Ʊ��(���ո�����)
		System.out.println("\"helloword\"");
		//9*9 �˷���
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(j*i)+" ");
			}
			System.out.println("");
		}
	}
}
