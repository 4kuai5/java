package newFile;

import java.io.File;

public class NewTestFile {

	//设计一个方法  用来展示（遍历）文件夹
	//参数---->file(代表文件或文件夹)
	
	public void showFile(File file){                            //D://aaa文件夹
		//判断如果file是一个文件夹  文件夹内有元素  找一个人来做
		//获取file的子元素     files==null 证明是一个文件        files!=null证明是个文件夹     files.length!=0证明是一个带元素的文件夹
		File[] files=file.listFiles();                          //aaa文件夹中的所有子元素
	    if(files!=null && files.length!=0){
	    	for(File f:files){
	    		this.showFile(f);
	    	}
	    }
		//做自己的显示(file是文件或是一个空的文件)
		System.out.println(file.getAbsolutePath());      //文件的绝对路径
	}
	
//设计一个方法  删除文件夹
//参数  file
    public void deleteFile(File file){
    	File[] files = file.listFiles();
    	if(files!=null&& files.length!=0){
    		for(File f:files){
	    		this.deleteFile(f);
	    	}
    	}
    	//删除file(当file是个文件或file是一个空的文件夹)
    	file.delete();
    }
	
	public static void main(String[] args) {
	
		NewTestFile ntf = new NewTestFile();
		File file=new File("D://aaa");           
		ntf.showFile(file);
		ntf.deleteFile(file);

	}

}
