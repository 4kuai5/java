package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.BaseFrame;
import util.MySpring;

import Service.UserService;

public class loginFrame extends BaseFrame{
	
	public loginFrame(){
		this.init();
	}
	
	public loginFrame(String title){ //title是传过来的
		
		super(title);   //当前没办法处理title--->用父类去处理
		this.init();
	}
	
	
	
	
	/*//创建一个窗体   ======当前类就是
	final JFrame frame = new JFrame("登录窗口");*/
	
	//创建一个面板
	private JPanel mainpanel = new JPanel();
	//创建title显示标题
	private JLabel titleLable = new JLabel("在 线 考 试 系 统");
	//创建账号和密码的标题
	private JLabel accuntLable = new JLabel("账 户:");
	private JLabel passwordLable = new JLabel("密 码:");
	//创建输入账号和密码的文本框/密码框
	private final JTextField accuntFiled = new JTextField();
	private final JPasswordField passwordFiled = new JPasswordField();
	
	//创建两个按钮
	private JButton loginButton = new JButton("登录");
	private JButton exitButton = new JButton("退出");
	
	//设置每一个组件的位置  大小 字体 布局等等
	protected void set(){
		
		//设置组件的位置----------布局管理
		//边界式(上下左右中)BorderLayout(JFrame)         流式(居中)FlowLayout(JPanel)
		//网格式GridLayout                 自定义(null)
		
		//设置panel布局管理为自定义方式
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.white);
		//设置每一个组件的位置
		
		titleLable.setBounds(120,40,340,35);
		//设置字体大小
		titleLable.setFont(new Font("黑体",Font.BOLD,34));
		//设置用户名lable的位置和字体大小
		accuntLable.setBounds(94, 124, 90,30);
		accuntLable.setFont(new Font("黑体",Font.BOLD,24));
		//设置用户名field的位置和字体大小
		accuntFiled.setBounds(204, 124, 260, 30);
		accuntFiled.setFont(new Font("黑体",Font.BOLD,24));
		//设置密码lable的位置和字体大小
		passwordLable.setBounds(94, 174, 90, 30);
		passwordLable.setFont(new Font("黑体",Font.BOLD,24));
		//设置密码field的位置和字体大小
		passwordFiled.setBounds(204, 174, 260, 30);
		passwordFiled.setFont(new Font("黑体",Font.BOLD,24));
		
		//设置登录按钮的位置和大小
		loginButton.setBounds(154, 234, 100, 30);
		loginButton.setFont(new Font("黑体",Font.BOLD,22));
		//设置退出按钮的位置和大小
		exitButton.setBounds(304, 234, 100, 30);
		exitButton.setFont(new Font("黑体",Font.BOLD,22));
		
	}
	//将所有的组件添加在窗体上
	protected void addElement(){
		
		//将所有的组件添加至窗体上
		mainpanel.add(titleLable);
		mainpanel.add(accuntLable);
		mainpanel.add(accuntFiled);
		mainpanel.add(passwordLable);
		mainpanel.add(passwordFiled);
		mainpanel.add(loginButton);
		mainpanel.add(exitButton);
		this.add(mainpanel);
	}
	
	//绑定事件的监听
	protected void addListener(){
		//绑定事件监听器
		//new对象出错 --->构造方法私有  构造方法公有但是没有无参数的   抽象类或接口
		/*ActionListener listener = new ImplListener();  //多态的应用(此时需要监听器new一下调用无参数的构造方法,但是ActionListener是接口)
		loginButton.addActionListener(listener);//观察者模式*/		
		
		//匿名内部类
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//1.获取用户输入的账号和密码
				//从登录窗口上的组件内获取   文本框  密码框
				//2.调用之前的service层的登陆方法
				String account = accuntFiled.getText();
				char[] value = passwordFiled.getPassword();  //把字符串变成数组
				String password = new String(value);         //把数组变成字符串
				UserService service =MySpring.getBean("Service.UserService"); //new UserService();
				String result = service.login(account,password);
				//3.判定最终的结果
				if(result.equals("恭喜你登录成功")){
					//弹出新的考试界面
					new ExamFrame(account+"的考试窗口");
				}else{
					//弹出一个警告框
					JOptionPane.showMessageDialog(loginFrame.this, result); //(当前窗口的父类，自身的输出结果)
					//设置文本框和密码框的值为空
					accuntFiled.setText("");
					passwordFiled.setText("");
				}
			}
			
		};  
		loginButton.addActionListener(listener);
	}

	//设置自己的状态
	protected void setFrameSelf(){

		//设置窗口起始位置和大小
		this.setBounds(600, 280, 600, 380);
		//设置点击关闭退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小不可拖拽
		this.setResizable(false);
		//设置窗体显示状态
		this.setVisible(true);
	}
	
}
