package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import util.MySpring;
import util.QuestionFileReader;

import domain.Question;

//������ļ�
//�������һ���Ծ�
//���10����Ŀ
//�����Ծ�5��
//���һ������:�Ƿ���Ҫ������---->5��
//     �Ƿ���Ҫ����ֵ��--->Ҫ--->һ�����һ������--->����5�����ü���--->5������Ҫһ��һ����������--->ArrayList<Question>��װ
public class QuestionDao{
	
	
	//��ȡ�������
	private QuestionFileReader reader = MySpring.getBean("util.QuestionFileReader");
	//�������еļ�����ʱ��Ϊlist����    �����ѰԪ�ص�ʱ�����λ��
	//���� :���ɵ���Ҫ�����,����HashSet�������----->���԰�HashSet��ļ�����ArrayList����ȥ�洢
	private ArrayList<Question> questionBank = new ArrayList(reader.getQuestionBox());
	
	public ArrayList<Question> getPaper(int count){
		HashSet<Question> paper = new HashSet<Question>();  //  ��ȡ�������֮��,������Ͼ��������洢���յ��Ծ���Ŀ
		while(paper.size()!=count){
			Random r = new Random(); //����������������     0-9
			int index = r.nextInt(this.questionBank.size());    // ���������һ����Ŀ����λ�� ----�����ܳ���
			paper.add(this.questionBank.get(index));
		}
		return new ArrayList<Question>(paper);
	/*	try {
		//1.����һ���ļ������� ��ȡ�ļ�(���)  һ��һ�е�
			BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
			String message = reader.readLine();
		//2.������ȡ������Ŀ   ����һ��Question����
		//����1 : ��ͷ��ȡ   ��������ظ� ÿһ���˵��Ծ�һ�� -------->���
		//����2 : ��ȡ���ܺ��� ---------------------------------->Я��һ���������
			while(message!=null){
				String[] values = message.split("#");  //������������  ���  ��
				Question question = new Question(values[0], values[1]); // ��װ��������
		//3.�ó�ȡ����Ŀû���ظ�-->Set����(�ص�:�������ظ�)   ��Question����ArrayList
				paper.add(question);
				if(paper.size()!=5){
					message = reader.readLine();
				}
		//Set���Ϸ�Ϊ1.HashSet(equals hashCode)�Ƚ����ֵ��Code����ͬ,�ڶ����Ͳ����������
		//          2.TreeSet(compareTo)�Ƚ������������ֵ����0,�ڶ����Ͳ����������
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}