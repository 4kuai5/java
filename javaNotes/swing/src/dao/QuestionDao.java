package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import util.MySpring;
import util.QuestionFileReader;

import domain.Question;

//负责读文件
//随机生成一套试卷
//题库10道题目
//生成试卷5道
//设计一个方法:是否需要参数？---->5道
//     是否需要返回值？--->要--->一道题就一个对象--->所以5道题用集合--->5道题需要一道一道遍历出来--->ArrayList<Question>封装
public class QuestionDao{
	
	
	//获取缓存对象
	private QuestionFileReader reader = MySpring.getBean("util.QuestionFileReader");
	//将缓存中的集合临时改为list集合    随机找寻元素的时候存在位置
	//本质 :生成的题要随机的,但是HashSet是有序的----->所以把HashSet里的集合让ArrayList集合去存储
	private ArrayList<Question> questionBank = new ArrayList(reader.getQuestionBox());
	
	public ArrayList<Question> getPaper(int count){
		HashSet<Question> paper = new HashSet<Question>();  //  获取缓存对象之后,这个集合就是用来存储最终的试卷题目
		while(paper.size()!=count){
			Random r = new Random(); //生成随机随机数对象     0-9
			int index = r.nextInt(this.questionBank.size());    // 随机产生的一个题目索引位置 ----题库的总长度
			paper.add(this.questionBank.get(index));
		}
		return new ArrayList<Question>(paper);
	/*	try {
		//1.创建一个文件输入流 读取文件(题库)  一行一行的
			BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
			String message = reader.readLine();
		//2.解析读取到的题目   创建一个Question对象
		//问题1 : 从头读取   不会出现重复 每一个人的试卷都一样 -------->随机
		//问题2 : 读取性能很慢 ---------------------------------->携带一个缓存机制
			while(message!=null){
				String[] values = message.split("#");  //数组连个长度  题干  答案
				Question question = new Question(values[0], values[1]); // 封装到对象里
		//3.让抽取的题目没有重复-->Set集合(特点:无需无重复)   存Question返回ArrayList
				paper.add(question);
				if(paper.size()!=5){
					message = reader.readLine();
				}
		//Set集合分为1.HashSet(equals hashCode)比较如果值和Code码相同,第二个就不往里面存了
		//          2.TreeSet(compareTo)比较如果两个返回值都是0,第二个就不往里面存了
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}