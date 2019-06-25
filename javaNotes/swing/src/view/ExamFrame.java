package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.Question;

import Service.QuestionService;

import util.BaseFrame;
import util.MySpring;


public class ExamFrame extends BaseFrame{
	//获取QuestionService对象
	QuestionService service = MySpring.getBean("Service.QuestionService");
	//通过service调用getPaper方法获取一套随机生成的试卷              个数我们可以自己定义
	ArrayList<Question> paper = service.getPaper(5);
	//创建一个用于存储学生选择的答案的容器             String[] 长度与paper一致
	private char[] answers = new char[paper.size()];
	
	
	//创建几个变量  分别控制右侧message个数
	private int nowNum = 0;  //记录当前题目序号
	private int totalCount = paper.size(); //记录总数
	private int answerCount = 0; //记录已经回答完毕的题目数量
	private int unanswerCount = totalCount;//记录还没有回答的问题
	
	
	//创建一个线程对象  控制时间变化
	private TimeControlThread timeControlThread = new TimeControlThread();
	/*//创建一个变量 用来记录整数
	private int time = 60;*/
	//创建一个变量  用来记录时间(分钟为单位)
	private int time = 1; 
	
	//=====================================================
	//添加构造方法
	public ExamFrame(){
		this.init();
	}
	public ExamFrame(String title){
		super(title);
		this.init();
	}

	//添加三个panel  区域的分割
	private JPanel mainPanel = new JPanel(); //负责答题主页面的展示
	private JPanel messagePanel = new JPanel(); //负责右侧信息的展示
	private JPanel buttonPanel = new JPanel(); //负责下方按钮的展示
	private JTextArea examArea = new JTextArea(); //考试文本域  展示题目
	private JScrollPane scrollPane = new JScrollPane(examArea); //滚动条
	//添加右侧信息的组件
	private JLabel pictureLable = new JLabel(); //展示图片信息
	private JLabel nowNumLable = new JLabel("当前题号:"); //提示当前的题号
	private JLabel totalCountLable = new JLabel("题目总数:"); //提示当前题目的总数
	private JLabel answerCountLable = new JLabel("已答题数:"); //提示已经答过的题目数量
	private JLabel unanswerCountLable = new JLabel("未答题数:"); //提示未答题数量
	private JTextField nowNumFiled = new JTextField(); // 展示题号
	private JTextField totalCountFiled = new JTextField(); //展示总数
	private JTextField answerCountFiled = new JTextField(); //展示已答数
	private JTextField unanswerCountFiled = new JTextField(); //展示未答数
	private JLabel timeLable = new JLabel("剩余答题时间"); //提示剩余时间
	private JLabel realTimeLable = new JLabel("00;00:00"); //倒计时真实时间
	//添加下方下面的组件
	private JButton aButton = new JButton("A"); // a按钮
	private JButton bButton = new JButton("B"); // b按钮
	private JButton cButton = new JButton("C"); // c按钮
	private JButton dButton = new JButton("D"); // d按钮
	private JButton prevButton = new JButton("上一题"); // 上一题
	private JButton nextButton = new JButton("下一题"); // 下一题
	private JButton submitButton = new JButton("提交试卷"); // 提交按钮
	
	
	protected void set() {	
		//设置panel布局管理 ---->自定义
		mainPanel.setLayout(null);
		messagePanel.setLayout(null);
		buttonPanel.setLayout(null);
		//手动设置每一个组件的位置  字体  背景
		mainPanel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(16, 10, 650, 450);//滚动条
		examArea.setFont(new Font("黑体",Font.BOLD,34));
		examArea.setEnabled(false);//文本域中的文字不能编辑            //去掉就可以在文本域中打字了
		
		//validate();  //从新生成组件
		
		messagePanel.setBounds(680, 10, 300, 550);
		messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // 右侧的面板边框
		
		buttonPanel.setBounds(16, 470, 650, 90);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //下面的面板边框
		
		//设置p2区域中每一个组件的位置 大小 颜色
		pictureLable.setBounds(10, 10, 280, 230);
		pictureLable.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		
		//picture.setIcon(null);//展示图片信息
		nowNumLable.setBounds(40, 270, 100, 30);
		nowNumLable.setFont(new Font("黑体",Font.PLAIN,20));
		nowNumFiled.setBounds(150, 270, 100, 30);
		nowNumFiled.setFont(new Font("黑体",Font.BOLD,20));
		nowNumFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		nowNumFiled.setEnabled(false);
		nowNumFiled.setHorizontalAlignment(JTextField.CENTER);//设置题里数字居中
		
		totalCountLable.setBounds(40, 310, 100, 30);
		totalCountLable.setFont(new Font("黑体",Font.PLAIN,20));
		totalCountFiled.setBounds(150, 310, 100, 30);
		totalCountFiled.setFont(new Font("黑体",Font.BOLD,20));
		totalCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		totalCountFiled.setEnabled(false);
		totalCountFiled.setHorizontalAlignment(JTextField.CENTER);//设置题里数字居中
		
		answerCountLable.setBounds(40, 350, 100, 30);
		answerCountLable.setFont(new Font("黑体",Font.PLAIN,20));
		answerCountFiled.setBounds(150, 350, 100, 30);
		answerCountFiled.setFont(new Font("黑体",Font.BOLD,20));
		answerCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		answerCountFiled.setEnabled(false);
		answerCountFiled.setHorizontalAlignment(JTextField.CENTER);//设置题里数字居中
		
		unanswerCountLable.setBounds(40, 390, 100, 30);
		unanswerCountLable.setFont(new Font("黑体",Font.PLAIN,20));
		unanswerCountFiled.setBounds(150, 390, 100, 30);
		unanswerCountFiled.setFont(new Font("黑体",Font.BOLD,20));
		unanswerCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		unanswerCountFiled.setEnabled(false);
		unanswerCountFiled.setHorizontalAlignment(JTextField.CENTER);//设置题里数字居中
		
		timeLable.setBounds(90, 460, 150, 30);
		timeLable.setFont(new Font("黑体",Font.PLAIN,20));
		timeLable.setForeground(Color.blue);
		
		realTimeLable.setBounds(108, 490, 150, 30);
		realTimeLable.setFont(new Font("黑体",Font.BOLD,20));
		realTimeLable.setForeground(Color.blue);
		
		

		aButton.setBounds(40, 10, 120, 30);
		aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //放上去成为一个小手
		bButton.setBounds(190, 10, 120, 30);
		bButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cButton.setBounds(340, 10, 120, 30);
		cButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dButton.setBounds(490, 10, 120, 30);
		dButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
		prevButton.setBounds(40, 50, 100, 30);
		prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextButton.setBounds(510, 50, 100, 30);
		nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.setBounds(276, 50, 100, 30);
		submitButton.setForeground(Color.RED); //字体颜色
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//--------------------------------------------------------------------------
		//展示考试题目(第一道)
		this.showQuestion();
		//重新设置右侧message中的组件值----用变量控制
		nowNumFiled.setText(nowNum+1+"");              //拼空串是因为要的返回值类型是String类型的
		totalCountFiled.setText(totalCount+"");
		answerCountFiled.setText(answerCount+"");
		unanswerCountFiled.setText(unanswerCount+"");
		
		realTimeLable.setText(time+"");
		//--------------------------------------------------------------------------
	}
	protected void addElement() {
		
		messagePanel.add(pictureLable);
		messagePanel.add(nowNumLable);
		messagePanel.add(nowNumFiled);
		
		messagePanel.add(totalCountLable);
		messagePanel.add(totalCountFiled);
		
		messagePanel.add(answerCountLable);
		messagePanel.add(answerCountFiled);
		
		messagePanel.add(unanswerCountLable);
		messagePanel.add(unanswerCountFiled);
		
		messagePanel.add(timeLable);
		messagePanel.add(realTimeLable);
		
		
		buttonPanel.add(aButton);
		buttonPanel.add(bButton);
		buttonPanel.add(cButton);
		buttonPanel.add(dButton);
		
		
		buttonPanel.add(prevButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(submitButton);
		

		mainPanel.add(scrollPane);
		mainPanel.add(messagePanel);
		mainPanel.add(buttonPanel);
		this.add(mainPanel);
		
	
	}

	protected void addListener() {
		//创建一个监听器对象   用于提交按钮
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//0.提交之前显示一个警告框,是否做完了才提交
				//JOptionPane.showMessageDialog(parentComponent, message);  消息框
				//确认框 ------> 是-0; 否-1; 取消-2  ------>通过返回值确定
				int value = JOptionPane.showConfirmDialog(ExamFrame.this, "是否确认提交试卷");   //确认框（当前弹出框口的父亲框,当前框口的文字）
				if(value==0){
					
					//1.倒计时时间停止   ----让线程结束
					//timeControlThread.stop(); //废弃了 不建议用
					timeControlThread.setFlag(false);  //切换了线程的状态
					//2.所有按钮失效
					ExamFrame.this.setOptionButtonEnabled(false);  //所有选项失效
					prevButton.setEnabled(false);
					nextButton.setEnabled(false);
					//3.让颜色回归本色
					ExamFrame.this.clearOptionButtonColor();
					//4.最终成绩的计算        展示在中间的文本域中
					float score = ExamFrame.this.checkPaper();
					examArea.setText("考试结束\n您的成绩为:"+score);
				}
			}
		});
		
		//创建一个监听器对象  用于上一题按钮
		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//还原4个选项按钮的状态  让他们变成可用的
				ExamFrame.this.setOptionButtonEnabled(true);
				//设置下一题按钮    变成可用
				nextButton.setEnabled(true);
				//当前题目序号减少一个
				nowNum--;
				if(nowNum==0){   //如果当前题号为0 已经到达第一题  让上一题按钮禁用
					prevButton.setEnabled(false);
				}else{
					//还得还原这道题之前选择的是哪一个选项
					ExamFrame.this.restorButton();
					//显示题目
					ExamFrame.this.showQuestion();
					//修改右侧题号   已答题  未答题
					nowNumFiled.setText(nowNum+1+"");
					answerCountFiled.setText(--answerCount+"");
					unanswerCountFiled.setText(++unanswerCount+"");
				}
				
				
			}
		});
		
		//创建一个监听器对象   用于下一题按钮
		nextButton.addActionListener(new ActionListener() {              //()里对象是一个匿名子类
			@Override
			public void actionPerformed(ActionEvent e) {
				//先清除所有选项按钮的颜色
				ExamFrame.this.clearOptionButtonColor();
				//当前题目序号增加一个
				nowNum++;
				//当前的题目是否到达最后
				if(nowNum==totalCount){  //到达最后一题了
					examArea.setText("全部题目已经回答完毕\n请点击下方红色提交按钮");
					//全部题目已经回答完毕  让下一个题目按钮失效
					nextButton.setEnabled(false);
					//让全部选项按钮失效
					ExamFrame.this.setOptionButtonEnabled(false);
				}else{  //还没到
					//调用自己封装的方法显示下一个题目和图片
					ExamFrame.this.showQuestion();
					//修改右侧当前的题号
					nowNumFiled.setText(nowNum+1+"");
				}
				//修改右侧已答题和未答题数目
				answerCountFiled.setText(++answerCount+"");
				unanswerCountFiled.setText(--unanswerCount+"");
			}
		});
		
		
		
		
		
		
		
		//创建一个监听器对象  用于四个选项按钮
		ActionListener  optionListrner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.清除所有的选项按钮颜色
				ExamFrame.this.clearOptionButtonColor();           //这里面是一个匿名内部类
				//2.获取到哪一个按钮颜色变化一下
				JButton button =(JButton)e.getSource();//
				//3.让当前按钮颜色变化一下
				button.setBackground(Color.GREEN);
				//4.将当前按钮的选项存储在answers数组中0 
				answers[nowNum] = button.getText().charAt(0);            //获取选项中的文字
				
			}
		};
		//将这个监听器对象绑定在四个选项按钮身上
		aButton.addActionListener(optionListrner);
		bButton.addActionListener(optionListrner);
		cButton.addActionListener(optionListrner);
		dButton.addActionListener(optionListrner);
	}
	
	protected void setFrameSelf() {
		this.setBounds(260, 180, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); //不想让窗体拖拽大小
		this.setVisible(true);  //最终展示整个窗体
		
		timeControlThread.start();//启动自己定义的线程对象   进入到就绪状态  时间处理
	}
	
	//1.添加好多属性---->各种组件
	
	//2.方法---->属性设置   字体  背景  位置  布局  等等
	
	//3.方法---->互相添加在一起
	
	//4.方法---->添加时间监听
	
	//5.方法---->窗体自己的信息
	//============================================================
	//设计一个方法  用来处理图片展示
	private ImageIcon drawImage(String path){
		//通过给定的路径创建一个icon对象
		ImageIcon imageIcon = new ImageIcon(path);
		//设置imageIcon对象内的image属性
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 230, Image.SCALE_DEFAULT));
		//将设置好的imageIcon对象返回
		return imageIcon;
	}
	
	//设计一个方法  用来展示一道题目
	private void showQuestion(){
		//从paper中获取当前的一道题目
		Question question = paper.get(nowNum); //三个属性  题干 答案 图片路径(有可能是null)
		//获取当前question中图片的路径
		String picture = question.getPicture(); //图片路径
		if(picture!=null){  //有图片路径的信息
			pictureLable.setIcon(this.drawImage("src//img//"+picture));
		}else{  //没有图片信息
			pictureLable.setIcon(null);
		}
		
		//处理一个题目中的标记<br>表示换行
		examArea.setText((nowNum+1)+"."+question.getTitle().replace("<br>", "\n   "));
	}

	//设计一个方法 清除所有的选项按钮颜色
	private void clearOptionButtonColor(){
		aButton.setBackground(null);
		bButton.setBackground(null);
		cButton.setBackground(null);
		dButton.setBackground(null);
	}
	//设计一个方法   让所有选项按钮失效
	private void setOptionButtonEnabled(boolean key){  //失不失效由参数决定
		aButton.setEnabled(key);
		bButton.setEnabled(key);
		cButton.setEnabled(key);
		dButton.setEnabled(key);
		
	}
	//设计一个方法   负责还原上一题的选项
	private void restorButton(){
		//获取当前题目的答案(学生选择的那个)
		char answer = answers[nowNum];
		if(answer=='\0'){
			return ;
		}
		switch(answer){
			case 'A' :
				aButton.setBackground(Color.GREEN);
				break;
			case 'B' :
				bButton.setBackground(Color.GREEN);
				break;
			case 'C' :
				cButton.setBackground(Color.GREEN);
				break;
			case 'D' :
				dButton.setBackground(Color.GREEN);
				break;
			default :
				this.clearOptionButtonColor();
				break;
		}
			
		}

	//设计一个内部类  为了处理时间倒计时的问题--------->线程
	private class TimeControlThread extends Thread{
		private boolean flag = true; //此时正常执行线程处理
		public void setFlag(boolean flag){
			this.flag=flag;
		}
		
		public void run(){
			//先把time进行转化     小时:分钟:秒
			int hour = time/60;
			int minute = time%60;
			int second = 0;
			while(flag){
				//将三个变量存储的数字进行拼串处理
				StringBuilder timeString = new StringBuilder();
				//处理小时
				if(hour>=0&&hour<10){
					timeString.append("0");
					
				}
				timeString.append(hour);
				timeString.append(":");
				//处理分钟
				if(minute>=0&&minute<10){
					timeString.append("0");
					
				}
				timeString.append(minute);
				timeString.append(":");
				//处理秒
				if(second>=0&&second<10){
					timeString.append("0");
					
				}
				timeString.append(second);
				//操作realTimeLable   展示一下拼接以后的时间字符串
				/*SwingUtilities.invokeLater(new Runnable(){     //系统不一样，如果下面不好使,可以这样写
					public void run(){
						realTimeLable.setText(timeString.toString());
					}
				});*/
				realTimeLable.setText(timeString.toString());
				try {
					Thread.sleep(1000);   //毫秒值
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				//改变
				if(second>0){
					second--;
				}else{           //秒数为0
					if(minute>0){
						minute--;
						second=59;
					}else{
						if(hour>0){
							hour--;
							minute=59;
							second=59;
						}else{
							System.out.println("时间截止");
							//时间显示为红色
							realTimeLable.setForeground(Color.RED);
							//所有按钮不能操作
							ExamFrame.this.setOptionButtonEnabled(false);
							prevButton.setEnabled(false);
							nextButton.setEnabled(false);
							//弹出一个消息框   告诉考试结束  
							JOptionPane.showMessageDialog(ExamFrame.this,"考试结束,请提交");
							break;
						}
					}
				}
			}
		}
		
		
		/*else if(answer=="A"){
			aButton.setBackground(Color.GREEN);
		}else if(answer=="B"){
			bButton.setBackground(Color.GREEN);
		}else if(answer=="C"){
			cButton.setBackground(Color.GREEN);
		}else if(answer=="D"){
			dButton.setBackground(Color.GREEN);
		}else{
			this.clearOptionButtonColor();
		}*/
	}

	//设计一个方法 负责计算最终的成绩
	private float checkPaper(){
		float score = 100;
		int size = paper.size();
		for(int i=0;i<size;i++){  //paper是一个ArrayList<Question>   titel  answer  picture
			Question question = paper.get(i);  //得到一份卷子
			String realAnswer = question.getAnswer();
			if(realAnswer.equals(answers[i])){
				score-=(100/size);
			}
		}
		return score;
	}
}

