package domain;

public class Question {

	//domain实体  存储文件中的题目  增强可读性
	
	private String title;         //储存题干
	private String answer;        //储存答案
	private String picture;       //储存图片路径
	
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
	
	//重写Question类中的两个方法       equals      hashCode
	//想要将Question对象存入HashSet集合内     让set集合帮助我们去掉重复元素
	public boolean equals(Object obj){   //重写父类方法

		if(this==obj){   //判断地址是否一样---->一样就是相同的题
			return true;
		}
		if(obj instanceof Question){  //判断类型是不是一样的
			Question anotherQuestion = (Question)obj;   //obj是Object类型的所以需要造型
			String thisTitle = this.title.substring(0,this.title.indexOf("<br>")); //substring截取;indexof:第一次出现()的位置
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
