package atmsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
//���Ͳ����ļ�
public class FileLoaderAndCommit {  //�ļ����غ��ύ
	
	private String fileName = null;
	public FileLoaderAndCommit (String fileName){
		this.fileName=fileName;
	}
	
	public HashMap<String, User> loadFile(){
		HashMap<String, User> userBox = new HashMap<String, User>();
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		//������Ŀ��:�ڶ��󴴽�֮ǰ �����Ͻ��и�ֵ����
	
		try {
			//����һ��������  ��ȡ��ʵ�ļ��ļ�¼
			File file=new File(fileName);         
			fileReader = new FileReader(file);
		    bufferedReader=new BufferedReader(fileReader );
		    String value = bufferedReader.readLine();
		    while(value!=null){
		    	//value����Ϣ��ֳ�����  ����һ��User����  �������Ըպô洢 ������뼯����
		    	String[] userValue= value.split("-");
		    	User user = new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));//��Ϊ���Ķ�����Float���͵ģ�������Ҫ������String
		    	userBox.put(userValue[0], user);  //��������ż��������ȥ����һ������ put(��(�˺�)��user����)
		    	value = bufferedReader.readLine();
		    }
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{          // �ر���
			try {
				if(fileReader!=null){         //�ж����Ƿ񴴽��ɹ�(�ɹ��͹���)
				fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{          // �ر���
				try {
					if(bufferedReader!=null){         //�ж����Ƿ񴴽��ɹ�(�ɹ��͹���)
					bufferedReader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		return userBox;
}
	//��������������յ�����ȫ��д���ļ��� �ļ��ڵ����������滻��
	public void commit(HashMap<String, User> userBox){
		FileWriter fileWriter=null;                       
		BufferedWriter bufferedWriter=null;            //��������Ҫ�ر���(�����ó���)
		try {
			//����һ���ַ����ļ������
			File file =new File(fileName);
			fileWriter = new FileWriter(file);
			//FileWriter�ǵͼ���
		    //��һ�д洢������,������BufferedWriter--->������(�߼���)��Ҫ�ͼ����Ĺ���
			bufferedWriter =new BufferedWriter(fileWriter);
			Iterator<String> names = userBox.keySet().iterator(); //������  ����ѭ������   ; <���м�������>
			while(names.hasNext()){
				String name = names.next();  //�����ڻ�ȡ��ĳһ������; Ϊ����Ҫ������Ӧ�Ķ���
				User user = userBox.get(name);  //��¼һ���˵���ʵ����
				//��user�����е���ʵ����ƴ�ӳ�һ���ַ���
				StringBuilder builder =new StringBuilder(user.getAname());
				builder.append("-");
				builder.append(user.getApassword());
				builder.append("-");
				builder.append(user.getAbalance());
				//�ַ��͵��ļ��������ƴ�Ӻõ�builderд���ļ�
				bufferedWriter.write(builder.toString());
				bufferedWriter.newLine();      // д��ȥһ����֮��  ����д��һ����
				bufferedWriter.flush();        //ѹ��ȥ
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ //�ر���       ����Ҫ�����ó�ȥ
			try {
				if(fileWriter!=null){
					fileWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bufferedWriter!=null){
					bufferedWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}
}
