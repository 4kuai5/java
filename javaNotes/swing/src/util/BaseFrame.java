package util;

import javax.swing.JFrame;

public abstract class BaseFrame extends JFrame{

	//模板模式
	
	//设计一个规则  任何窗口想要画出来   执行流程固定
	
	public BaseFrame(){}
	public BaseFrame(String title){
		super(title);
	}
	
	protected void init(){
		this.set();
		this.addElement();
		this.addListener();
		this.setFrameSelf();
	}
	
	
	//1.设置  字体  颜色  背景  布局 等等
	protected abstract void set();
	
	//2.将属性添加到窗体里
	protected abstract void addElement();
	
	//3.添加事件监听
	protected abstract void addListener();
	
	//4.设置窗体自身
	protected abstract void setFrameSelf();
}
