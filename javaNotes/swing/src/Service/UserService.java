package Service;

import util.MySpring;
import dao.UserDao;
import domain.User;

//Service业务层
//负责处理读到的数据
//负责处理业务逻辑产生的新数据
public class UserService {
	
	//包含一个dao对象作为属性
	//private UserDao dao = new UserDao();  可以这么写(下面写的是底层技术)
	private UserDao dao =/*(UserDao)*/MySpring.getBean("dao.UserDao");     //改成<T>T之后就可以把泛型去掉了
	//相当于创建UserDao对象交给了MySpring类
	
	//设计一个方法 ---- 负责登录
	public String login (String account ,String password){
		User user = dao.selectOne(account);
		if(user!=null){
			
			if(user.getPassword().equals(password)){
				
				return "恭喜你登录成功";
			}
		}
		return "用户名或密码错误";
		
		
		/*if(account.equals("张三")&&password.endsWith("333")){
			return "恭喜你登录成功";
		}
		return "登陆失败";*/
		
	}

}
