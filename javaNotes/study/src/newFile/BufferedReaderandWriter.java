package newFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderandWriter {

	//���һ������  �����û���¼
	public String login(String username,String password){
		//��ʵ�����ֺ����룬���õĴ������ݿ�
		try {
			BufferedReader br = new BufferedReader(new FileReader("D://aaa//ddd.txt"));
			String user=br.readLine();//user��ʾһ�м�¼      ��¼���˺ź�����             readerLine:��ȡ����Ч��һ��Ԫ��
			while(user!=null){
				String[] value =user.split("-");//value[0]�˺�    value[1]����
				if(value[0].equals(username)){
					if(value[1].equals(password)){
						return "��½�ɹ�";
					}
				}
				user=br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "�û������������";
	}
	public static void main(String[] args) {
		//������
		//BufferedReaderandWriter test=new BufferedReaderandWriter();
		//String result=test.login("�º���", "123");
		//System.out.println(result);
		//�����
		try {
			BufferedWriter bw =new BufferedWriter(new FileWriter("D://aaa//ddd.txt",true));
			bw.newLine();
			bw.write("��һ����-666");
			bw.flush();
			System.out.println("�����ɹ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
