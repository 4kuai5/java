package atmsystem;


//它就操作业务
public class AtmService {
	//这一个类都是负责处理业务逻辑的，所以需要底层数据的支持
	private AtmDao dao =new AtmDao();
	//网络银行的业务                                                   
	//所有的业务方法  按照我们之前的优化结构设计
	//只有业务逻辑----->判断  比较  计算等等
	//看不见任何数据的操作  从哪儿查出来的 存在哪儿
	//设计一个业务方法---登录
	public String login(String aname,String apassword){          //登录
		User user = dao.selectOne(aname);
		if(user!=null&&user.getApassword().equals(apassword)){
			return "您已成功登陆";
		}
		return "用户名或密码错误";
	}
	
	//设计一个业务方法         查询余额
	public Float queryBalance(String aname){
		User user =dao.selectOne(aname);                 //利用键去集合里找余额
		return user.getAbalance();
	}
	//设计一个业务方法       存款
	public void deposit(String aname, Float depositMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User user =dao.selectOne(aname);                 //找个人把我要操作的对象查出来
		user.setAbalance(user.getAbalance()+depositMoney);
		dao.update(user);                                //再找个人把我操作完对象再存回去
			
	}
	//设计一个业务方法       取款
	public void withdrawal(String aname, Float withdrawalMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User user =dao.selectOne(aname);                 //找个人把我要操作的对象查出来
		if(user.getAbalance()>withdrawalMoney){
			user.setAbalance(user.getAbalance()-withdrawalMoney);
			dao.update(user);                           //再找个人把我操作完对象再存回去
		}else{
			System.out.println("对不起,尊敬的"+aname+"您的账务余额不足");
		}	
	}
	//设计一个业务方法       转账
	public void transfer(String outName,String inName, Float transferMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User outUser =dao.selectOne(outName);                 //找个人把我要操作的对象查出来
		if(outUser.getAbalance()>transferMoney){
			User inUser = dao.selectOne(inName);
			if(inUser!=null){ //转入的账户是存在的
				outUser.setAbalance(outUser.getAbalance()-transferMoney);
				inUser.setAbalance(inUser.getAbalance()+transferMoney);
				dao.update(outUser);                           //再找个人把我操作完对象再存回去
				dao.update(inUser);
			
			}else{
				System.out.println("对不起，您输入的账户不存在");
			}	
		}else{
			System.out.println("对不起,尊敬的"+outUser+"您的账务余额不足");
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*//缓存机制(把文件信息放进内存去)
	//发现登录的方法 每一次调用都需要创建流管道      读取文件信息
	//内存中操作登录的业务跟文件不在一个地方--->读取的过程很慢
	//想到一个解决方案 创建一个map(固定找一个还不用循环)集合(可改变大小)充当缓存;将文件中的数据全部读出来,读一次
	//所以以后login找人就可以去map里找,比较方便
	
	//一行记录  创建一个对象存起来;   一个人--->一个对象--->三个属性
	//集合除了可以充当缓存     增强执行性能以外  还能用来做记录的修改
	private HashMap<String,User> userBox = new HashMap<String,User>();//前面是寻找你依靠的头的类型(找人依靠姓名);后面是你整个信息的类型
	FileReader fileReader=null;
	BufferedReader bufferedReader=null;
	//程序块的目的:在对象创建之前 给集合进行赋值操作
	{
		try {
			//创建一个输入流  读取真实文件的记录
			File file=new File("src\\atmsystem\\User.txt");         
			fileReader = new FileReader(file);
		    bufferedReader=new BufferedReader(fileReader );
		    String value = bufferedReader.readLine();
		    while(value!=null){
		    	//value的信息拆分成三段  构建一个User对象  三个属性刚好存储 对象存入集合中
		    	String[] userValue= value.split("-");
		    	User user = new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));//因为余额的对象是Float类型的，所以需要构建成String
		    	userBox.put(userValue[0], user);  //拆分完对象放集合里，完事去读下一个对象 put(键(账号)，user对象)
		    	value = bufferedReader.readLine();
		    }
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{          // 关闭流
			try {
				if(fileReader!=null){         //判断流是否创建成功(成功就关了)
				fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{          // 关闭流
				try {
					if(bufferedReader!=null){         //判断流是否创建成功(成功就关了)
					bufferedReader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
	
	
	//设计一个方法 目的是为了我的所有业务服务
	//有参数(账号名)     返回值(一个对象user)
	public User selectOne(String aname){
		return  userBox.get(aname);               //每个方法里都需要先调用这个方法进入到集合里
	}
	//设计一个方法  目的是为了讲某一个修改完毕的对象存入集合
	
	public void update(User user){
		userBox.put(user.getAname(), user); //集合做了修改
		this.commit();                      //将临时的数据永久的写入文件
	}
	
	//将结合内所有最终的数据全部写入文件中 文件内的所有内容替换掉
	public void commit(){
		FileWriter fileWriter=null;                       
		BufferedWriter bufferedWriter=null;            //运行完流要关闭流(所以拿出来)
		try {
			//创建一个字符型文件输出流
			File file =new File("src\\atmsystem\\User.txt");
			fileWriter = new FileWriter(file);
			//FileWriter是低级流
		    //用一行存储的数据,所以用BufferedWriter--->缓冲流(高级流)需要低级流的构建
			bufferedWriter =new BufferedWriter(fileWriter);
			Iterator<String> names = userBox.keySet().iterator(); //迭代器  遍历循环集合   ; <所有键的类型>
			while(names.hasNext()){
				String name = names.next();  //集合内获取的某一个人名; 为的是要人名对应的对象
				User user = userBox.get(name);  //记录一个人的真实数据
				//将user对象中的真实数据拼接成一行字符串
				StringBuilder builder =new StringBuilder(user.getAname());
				builder.append("-");
				builder.append(user.getApassword());
				builder.append("-");
				builder.append(user.getAbalance());
				//字符型的文件输出流将拼接好的builder写入文件
				bufferedWriter.write(builder.toString());
				bufferedWriter.newLine();      // 写进去一个人之后  换行写下一个人
				bufferedWriter.flush();        //压进去
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ //关闭流       所以要把流拿出去
			try {
				if(fileWriter!=null){
					fileWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bufferedWriter!=null){
					bufferedWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}
	----------------------------------------------------------------------------------
	----------------------------------------------------------------------------------
	//网络银行的业务                                                   第二种优化方法
	//设计一个业务方法---登录
	public String login(String aname,String apassword){          //登录
		User user = this.selectOne(aname);
		if(user!=null && user.getApassword().equals(apassword)){
			return "登录成功";
		}
		return "用户名或密码错误";
	}
	
	//设计一个业务方法         查询余额
	public Float queryBalance(String aname){
		User user =this.selectOne(aname);                 //利用键去集合里找余额
		return user.getAbalance();
	}
	//设计一个业务方法       存款
	public void deposit(String aname, Float depositMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User user =this.selectOne(aname);                 //找个人把我要操作的对象查出来
		user.setAbalance(user.getAbalance()+depositMoney);
		this.update(user);                       //再找个人把我操作完对象再存回去
		this.commit();                      //将临时的数据永久的写入文件
			
	}
	//设计一个业务方法       取款
	public void withdrawal(String aname, Float withdrawalMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User user =this.selectOne(aname);                 //找个人把我要操作的对象查出来
		if(user.getAbalance()>withdrawalMoney){
			user.setAbalance(user.getAbalance()-withdrawalMoney);
			this.update(user);                           //再找个人把我操作完对象再存回去
			this.commit();                      //将临时的数据永久的写入文件
		}else{
			System.out.println("对不起,尊敬的"+aname+"您的账务余额不足");
		}	
	}
	//设计一个业务方法       转账
	public void transfer(String outName,String inName, Float transferMoney){
		 //先将集合内的数据做出修改     找到某一个user对象  对象中的balance属性修改
		User outUser =this.selectOne(outName);                 //找个人把我要操作的对象查出来
		if(outUser.getAbalance()>transferMoney){
			User inUser = this.selectOne(inName);
			if(inUser!=null){ //转入的账户是存在的
				outUser.setAbalance(outUser.getAbalance()-transferMoney);
				inUser.setAbalance(inUser.getAbalance()+transferMoney);
				this.update(outUser);                           //再找个人把我操作完对象再存回去
				this.update(inUser);
				this.commit();                      //将临时的数据永久的写入文件
			}else{
				System.out.println("对不起，您输入的账户不存在");
			}	
		}else{
			System.out.println("对不起,尊敬的"+outUser+"您的账务余额不足");
		}	
	}
*/	
	
	
	
	/*//网络银行的业务           第一种简易方法
	//设计一个业务方法---登录
	public String login(String aname,String apassword){          //登录
		try {
			//创建一个输入流  读取真实文件的记录
			File file=new File("src\\atmsystem\\User.txt");          //相对路径(没有盘符)
			FileReader fileReader = new FileReader(file);            //FileReader是低级流
		    //用一行存储的数据,所以用BufferedReader--->缓冲流(高级流)需要低级流的构建
            BufferedReader bufferedReader=new BufferedReader(fileReader);
        
            String value = bufferedReader.readLine();                //readLine():可以一行一行读; value表示一行人的所有信息
            while(value!=null){                                      //判断一下是否读到信息
            	String[] user = value.split("-");                    //spilt():按照规则拆分; user数组存储的一个人的信息
            	if(user[0].equals(aname)){
            		if(user[1].equals(apassword)){
            			return "登陆成功";
            		}
            	}
            	value = bufferedReader.readLine();                  //如果条件不满足，则进行下一行的比较
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "用户名或密码错误";
	}*/

}
