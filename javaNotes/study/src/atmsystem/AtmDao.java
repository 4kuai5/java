package atmsystem;

import java.util.HashMap;


//它就操作集合
public class AtmDao {
	
	//DAO作为一个层次----->持久层   操作数据    负责读写数据
	//dao中还有一个小弟  负责加载文件  更新文件数据
	private FileLoaderAndCommit flac =new FileLoaderAndCommit("src\\atmsystem\\User.txt");
	//缓存机制(把文件信息放进内存去)
	//发现登录的方法 每一次调用都需要创建流管道      读取文件信息
	//内存中操作登录的业务跟文件不在一个地方--->读取的过程很慢
	//想到一个解决方案 创建一个map(固定找一个还不用循环)集合(可改变大小)充当缓存;将文件中的数据全部读出来,读一次
	//所以以后login找人就可以去map里找,比较方便
	
	//一行记录  创建一个对象存起来;   一个人--->一个对象--->三个属性
	//集合除了可以充当缓存     增强执行性能以外  还能用来做记录的修改
	private HashMap<String,User> userBox = flac.loadFile();//前面是寻找你依靠的头的类型(找人依靠姓名);后面是你整个信息的类型
	
	//设计一个方法 目的是为了我的所有业务服务
	//有参数(账号名)     返回值(一个对象user)
	public User selectOne(String aname){
		return  userBox.get(aname);               //每个方法里都需要先调用这个方法进入到集合里
	}
	//设计一个方法  目的是为了讲某一个修改完毕的对象存入集合
	
	public void update(User user){
		userBox.put(user.getAname(), user);       //集合做了修改
		flac.commit(userBox);                    //将临时的数据永久的写入文件
	}
}
