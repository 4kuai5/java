package student;

public class TestMain {

	/*1.模拟一个学生在机房内使用电脑的例子
		有一个机房
		有五台电脑   电脑有开机/关机的状态  电脑被打开  被使用中  被关闭
		学生进入机房选择一台关闭的电脑进行使用，学生也有5个，陆续进入机房
		*/
	public static void main(String[] args) {
		MachineRoom mr=new MachineRoom();
		Student student1=new Student("陈浩天");
		mr.welcome(student1);
		Student student2=new Student("黄东雪");
		mr.welcome(student2);
		Student student3=new Student("刁震");
		mr.welcome(student3);
		Student student4=new Student("韩阳");
		mr.welcome(student4);
		Student student5=new Student("赵康哲");
		mr.welcome(student5);

	}

}
