package student;

public class TestMain {

	/*1.ģ��һ��ѧ���ڻ�����ʹ�õ��Ե�����
		��һ������
		����̨����   �����п���/�ػ���״̬  ���Ա���  ��ʹ����  ���ر�
		ѧ���������ѡ��һ̨�رյĵ��Խ���ʹ�ã�ѧ��Ҳ��5����½���������
		*/
	public static void main(String[] args) {
		MachineRoom mr=new MachineRoom();
		Student student1=new Student("�º���");
		mr.welcome(student1);
		Student student2=new Student("�ƶ�ѩ");
		mr.welcome(student2);
		Student student3=new Student("����");
		mr.welcome(student3);
		Student student4=new Student("����");
		mr.welcome(student4);
		Student student5=new Student("�Կ���");
		mr.welcome(student5);

	}

}
