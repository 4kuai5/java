package swing;
import view.loginFrame;

public class TestMain {

	//����ϵͳ
	//1.��¼����     �û�������������     �ļ�
	//2.���Թ���     ������Ŀ�ʹ𰸴����� �� �ļ�
	//3.չʾ����(GUI)  ͼ���û��ӿ�
	
	//���--->�����ļ����ñ���(�ַ���)--->�ó����𿪷��ڶ����������
	public static void main(String[] args) {
		new loginFrame("��½����");
		//new ExamFrame("���Դ���");
		
		/*QuestionService service = MySpring.getBean("Service.QuestionService");
		ArrayList<Question> paper = service.getPaper(5);
		for(int i=0; i<paper.size();i++){
			Question question = paper.get(i);
			String title = question.getTitle().replace("<br>", "\n   ");
			System.out.println((i+1)+"."+title);*/
			
		
	}

}
