package util;

//以后有数据库了就用不上了,因为数据库底层有缓存,到时候我们调用指令就好了
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import domain.User;


//类的目的是为了增加一个缓存机制
//程序启动的时候将User.txt文件中的所有信息  一次性读出来
//以后做查询直接读取缓存中的数据    提高读取的性能
public class UserFileReader {
	
	//创建一个集合--->充当一个缓存
	private static HashMap<String,User>  userBox = new HashMap<String,User>();   //<名字的类型,整个对象>    这里的static是为了让这个集合是唯一的
	
	
	public static User getUser(String account){                  //这个static是为了不用创建对象,用类名.方法
		return userBox.get(account);
	}
	
	//在当前类加载的时候先执行
	//这里用static修饰的原因   : 全是静态的就不用创建对象 ,普通的方法块是在调用构造方法之前执行的,而不创建对象就调用不了构造方法     
	static {                                                      //这里static是为了这个类加载的时候就执行这个过程
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src//dbfile//User.txt"));
			String message = reader.readLine();
			while(message!=null){
			String[] values = message.split("-");
			/*this.*/userBox.put(values[0], new User(values[0],values[1]));  //this和super与static冲突
			message = reader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
