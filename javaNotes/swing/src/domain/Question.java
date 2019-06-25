package domain;

public class Question {

	//domainʵ��  �洢�ļ��е���Ŀ  ��ǿ�ɶ���
	
	private String title;         //�������
	private String answer;        //�����
	private String picture;       //����ͼƬ·��
	
	public Question(){}
	public Question(String title,String answer){
		this.answer = answer;
		this.title = title;
	}
	public Question(String title,String answer,String picture){
		this.answer = answer;
		this.title = title;
		this.picture = picture;
	}
	
	//��дQuestion���е���������       equals      hashCode
	//��Ҫ��Question�������HashSet������     ��set���ϰ�������ȥ���ظ�Ԫ��
	public boolean equals(Object obj){   //��д���෽��

		if(this==obj){   //�жϵ�ַ�Ƿ�һ��---->һ��������ͬ����
			return true;
		}
		if(obj instanceof Question){  //�ж������ǲ���һ����
			Question anotherQuestion = (Question)obj;   //obj��Object���͵�������Ҫ����
			String thisTitle = this.title.substring(0,this.title.indexOf("<br>")); //substring��ȡ;indexof:��һ�γ���()��λ��
			String anotherTitle = anotherQuestion.title.substring(0,anotherQuestion.title.indexOf("<br>"));
			if(thisTitle.equals(anotherTitle)){  
				return true;
			}
			
		}
		return false;
		
	}
	
	public int hashCode(){
		String thisTitle = this.title.substring(0,this.title.indexOf("<br>"));
		return thisTitle.hashCode();
	}
	
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
