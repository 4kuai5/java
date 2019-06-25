package swing;
import view.loginFrame;

public class TestMain {

	//考试系统
	//1.登录功能     用户和密码存在哪里？     文件
	//2.考试功能     考试题目和答案存在哪 ？ 文件
	//3.展示功能(GUI)  图形用户接口
	
	//题库--->放在文件永久保存(字符串)--->拿出来拆开放在对象的属性里
	public static void main(String[] args) {
		new loginFrame("登陆窗口");
		//new ExamFrame("考试窗口");
		
		/*QuestionService service = MySpring.getBean("Service.QuestionService");
		ArrayList<Question> paper = service.getPaper(5);
		for(int i=0; i<paper.size();i++){
			Question question = paper.get(i);
			String title = question.getTitle().replace("<br>", "\n   ");
			System.out.println((i+1)+"."+title);*/
			
		
	}

}
