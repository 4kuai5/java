package dao;

import util.UserFileReader;
import domain.User;

//�־ò�               ���ݵĳ־û�
//ֻ�������ݵĶ�   д           ���������߼�
//�ֽ׶ο����ķ����ڲ�       ͨ�����ǰ�����I/O
//�Ժ������εķ����������ڲ����붼��JDBC
public class UserDao {
	
	//�����ѯһ���˵���Ϣ
	//�����˺�    ����ֵdomain
	public User selectOne(String account){
		
		return UserFileReader.getUser(account);
		/*User user = null;
		try {
			FileReader fr = new FileReader("src//dbfile//User.txt");
			BufferedReader reader = new BufferedReader(fr);
			String message = reader.readLine();
			while(message!=null){
			String[] values = message.split("-");
			if(values[0].equals(account)){
				user =new User(values[0],values[1]);  //����ҵ���,�Ͱ��������ݷ�װ��һ���¶����������
				break;
			}
			message = reader.readLine();
			}
			fr.close();
			reader.close();                           //���±����ǹ���
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;*/
	}
	
	
	//���ǵ������ϵͳ,����ͬʱӦ��ʱ,���������ͱȽ�����,����һ�ξ�Ҫȥ����һ��
	//��������----->  ���� ---- �����(�ڴ���) -------- �洢�ļ��е�������Ϣ
	
	
	
	
	
	
	
	
}
