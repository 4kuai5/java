package dao;

import util.UserFileReader;
import domain.User;

//持久层               数据的持久化
//只负责数据的读   写           不负责处理逻辑
//现阶段看到的方法内部       通常都是包含的I/O
//以后这个层次的方法看到的内部代码都是JDBC
public class UserDao {
	
	//负责查询一个人的信息
	//参数账号    返回值domain
	public User selectOne(String account){
		
		return UserFileReader.getUser(account);
		/*User user = null;
		try {
			FileReader fr = new FileReader("src//dbfile//User.txt");
			BufferedReader reader = new BufferedReader(fr);
			String message = reader.readLine();
			while(message!=null){
			String[] values = message.split("-");
			if(values[0].equals(account)){
				user =new User(values[0],values[1]);  //如果找到了,就把这行数据封装成一个新对象输出出来
				break;
			}
			message = reader.readLine();
			}
			fr.close();
			reader.close();                           //完事别忘记关流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;*/
	}
	
	
	//但是当上面的系统,多人同时应用时,运行起来就比较慢了,运行一次就要去遍历一次
	//所以引入----->  缓存 ---- 虚拟机(内存中) -------- 存储文件中的所有信息
	
	
	
	
	
	
	
	
}
