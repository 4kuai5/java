package util;

//�Ժ������ݿ��˾��ò�����,��Ϊ���ݿ�ײ��л���,��ʱ�����ǵ���ָ��ͺ���
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import domain.User;


//���Ŀ����Ϊ������һ���������
//����������ʱ��User.txt�ļ��е�������Ϣ  һ���Զ�����
//�Ժ�����ѯֱ�Ӷ�ȡ�����е�����    ��߶�ȡ������
public class UserFileReader {
	
	//����һ������--->�䵱һ������
	private static HashMap<String,User>  userBox = new HashMap<String,User>();   //<���ֵ�����,��������>    �����static��Ϊ�������������Ψһ��
	
	
	public static User getUser(String account){                  //���static��Ϊ�˲��ô�������,������.����
		return userBox.get(account);
	}
	
	//�ڵ�ǰ����ص�ʱ����ִ��
	//������static���ε�ԭ��   : ȫ�Ǿ�̬�ľͲ��ô������� ,��ͨ�ķ��������ڵ��ù��췽��֮ǰִ�е�,������������͵��ò��˹��췽��     
	static {                                                      //����static��Ϊ���������ص�ʱ���ִ���������
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src//dbfile//User.txt"));
			String message = reader.readLine();
			while(message!=null){
			String[] values = message.split("-");
			/*this.*/userBox.put(values[0], new User(values[0],values[1]));  //this��super��static��ͻ
			message = reader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
