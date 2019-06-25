package util;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.HashSet;

import domain.Question;

public class QuestionFileReader {

	//����ִ��ʱ,���ļ���������Ŀ һ���Զ���ȡ����
	private HashSet<Question> questionBox = new HashSet<Question>();
	
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
			String message = reader.readLine();
			while(message!=null){
				String[] values = message.split("#");  //������������  ���  ��
				if(values.length==2){   //ֻ����ɺʹ�
					questionBox.add(new Question(values[0],values[1])); // ��װ��������
				}else if(values.length==3){  //������ͼƬ��Ϣ
					questionBox.add(new Question(values[0],values[1],values[2])); // ��װ��������
				}
				message = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HashSet<Question> getQuestionBox(){      //������˽�з���,дһ�����еķ������
		return questionBox;
	}
}
