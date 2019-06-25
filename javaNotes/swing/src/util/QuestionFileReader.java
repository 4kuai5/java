package util;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.HashSet;

import domain.Question;

public class QuestionFileReader {

	//程序执行时,将文件的所有题目 一次性都读取出来
	private HashSet<Question> questionBox = new HashSet<Question>();
	
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
			String message = reader.readLine();
			while(message!=null){
				String[] values = message.split("#");  //数组连个长度  题干  答案
				if(values.length==2){   //只有题干和答案
					questionBox.add(new Question(values[0],values[1])); // 封装到对象里
				}else if(values.length==3){  //还含有图片信息
					questionBox.add(new Question(values[0],values[1],values[2])); // 封装到对象里
				}
				message = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HashSet<Question> getQuestionBox(){      //上面是私有方法,写一个公有的方便调用
		return questionBox;
	}
}
