package newFile;

import java.io.File;

public class NewTestFile {

	//���һ������  ����չʾ���������ļ���
	//����---->file(�����ļ����ļ���)
	
	public void showFile(File file){                            //D://aaa�ļ���
		//�ж����file��һ���ļ���  �ļ�������Ԫ��  ��һ��������
		//��ȡfile����Ԫ��     files==null ֤����һ���ļ�        files!=null֤���Ǹ��ļ���     files.length!=0֤����һ����Ԫ�ص��ļ���
		File[] files=file.listFiles();                          //aaa�ļ����е�������Ԫ��
	    if(files!=null && files.length!=0){
	    	for(File f:files){
	    		this.showFile(f);
	    	}
	    }
		//���Լ�����ʾ(file���ļ�����һ���յ��ļ�)
		System.out.println(file.getAbsolutePath());      //�ļ��ľ���·��
	}
	
//���һ������  ɾ���ļ���
//����  file
    public void deleteFile(File file){
    	File[] files = file.listFiles();
    	if(files!=null&& files.length!=0){
    		for(File f:files){
	    		this.deleteFile(f);
	    	}
    	}
    	//ɾ��file(��file�Ǹ��ļ���file��һ���յ��ļ���)
    	file.delete();
    }
	
	public static void main(String[] args) {
	
		NewTestFile ntf = new NewTestFile();
		File file=new File("D://aaa");           
		ntf.showFile(file);
		ntf.deleteFile(file);

	}

}
