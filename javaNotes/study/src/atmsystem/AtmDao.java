package atmsystem;

import java.util.HashMap;


//���Ͳ�������
public class AtmDao {
	
	//DAO��Ϊһ�����----->�־ò�   ��������    �����д����
	//dao�л���һ��С��  ��������ļ�  �����ļ�����
	private FileLoaderAndCommit flac =new FileLoaderAndCommit("src\\atmsystem\\User.txt");
	//�������(���ļ���Ϣ�Ž��ڴ�ȥ)
	//���ֵ�¼�ķ��� ÿһ�ε��ö���Ҫ�������ܵ�      ��ȡ�ļ���Ϣ
	//�ڴ��в�����¼��ҵ����ļ�����һ���ط�--->��ȡ�Ĺ��̺���
	//�뵽һ��������� ����һ��map(�̶���һ��������ѭ��)����(�ɸı��С)�䵱����;���ļ��е�����ȫ��������,��һ��
	//�����Ժ�login���˾Ϳ���ȥmap����,�ȽϷ���
	
	//һ�м�¼  ����һ�����������;   һ����--->һ������--->��������
	//���ϳ��˿��Գ䵱����     ��ǿִ����������  ������������¼���޸�
	private HashMap<String,User> userBox = flac.loadFile();//ǰ����Ѱ����������ͷ������(������������);��������������Ϣ������
	
	//���һ������ Ŀ����Ϊ���ҵ�����ҵ�����
	//�в���(�˺���)     ����ֵ(һ������user)
	public User selectOne(String aname){
		return  userBox.get(aname);               //ÿ�������ﶼ��Ҫ�ȵ�������������뵽������
	}
	//���һ������  Ŀ����Ϊ�˽�ĳһ���޸���ϵĶ�����뼯��
	
	public void update(User user){
		userBox.put(user.getAname(), user);       //���������޸�
		flac.commit(userBox);                    //����ʱ���������õ�д���ļ�
	}
}
