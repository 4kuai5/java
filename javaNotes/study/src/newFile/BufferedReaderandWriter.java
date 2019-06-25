package newFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderandWriter {

	//设计一个方法  用来用户登录
	public String login(String username,String password){
		//真实的名字和密码，永久的存在数据库
		try {
			BufferedReader br = new BufferedReader(new FileReader("D://aaa//ddd.txt"));
			String user=br.readLine();//user表示一行记录      记录着账号和密码             readerLine:读取的有效的一行元素
			while(user!=null){
				String[] value =user.split("-");//value[0]账号    value[1]密码
				if(value[0].equals(username)){
					if(value[1].equals(password)){
						return "登陆成功";
					}
				}
				user=br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "用户名或密码错误";
	}
	public static void main(String[] args) {
		//输入流
		//BufferedReaderandWriter test=new BufferedReaderandWriter();
		//String result=test.login("陈浩天", "123");
		//System.out.println(result);
		//输出流
		try {
			BufferedWriter bw =new BufferedWriter(new FileWriter("D://aaa//ddd.txt",true));
			bw.newLine();
			bw.write("渡一教育-666");
			bw.flush();
			System.out.println("操作成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
