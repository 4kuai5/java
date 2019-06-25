package atmsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
//它就操作文件
public class FileLoaderAndCommit {  //文件加载和提交
	
	private String fileName = null;
	public FileLoaderAndCommit (String fileName){
		this.fileName=fileName;
	}
	
	public HashMap<String, User> loadFile(){
		HashMap<String, User> userBox = new HashMap<String, User>();
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		//程序块的目的:在对象创建之前 给集合进行赋值操作
	
		try {
			//创建一个输入流  读取真实文件的记录
			File file=new File(fileName);         
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
		return userBox;
}
	//将结合内所有最终的数据全部写入文件中 文件内的所有内容替换掉
	public void commit(HashMap<String, User> userBox){
		FileWriter fileWriter=null;                       
		BufferedWriter bufferedWriter=null;            //运行完流要关闭流(所以拿出来)
		try {
			//创建一个字符型文件输出流
			File file =new File(fileName);
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
}
