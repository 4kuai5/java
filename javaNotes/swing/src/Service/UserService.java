package Service;

import util.MySpring;
import dao.UserDao;
import domain.User;

//Serviceҵ���
//���������������
//������ҵ���߼�������������
public class UserService {
	
	//����һ��dao������Ϊ����
	//private UserDao dao = new UserDao();  ������ôд(����д���ǵײ㼼��)
	private UserDao dao =/*(UserDao)*/MySpring.getBean("dao.UserDao");     //�ĳ�<T>T֮��Ϳ��԰ѷ���ȥ����
	//�൱�ڴ���UserDao���󽻸���MySpring��
	
	//���һ������ ---- �����¼
	public String login (String account ,String password){
		User user = dao.selectOne(account);
		if(user!=null){
			
			if(user.getPassword().equals(password)){
				
				return "��ϲ���¼�ɹ�";
			}
		}
		return "�û������������";
		
		
		/*if(account.equals("����")&&password.endsWith("333")){
			return "��ϲ���¼�ɹ�";
		}
		return "��½ʧ��";*/
		
	}

}
