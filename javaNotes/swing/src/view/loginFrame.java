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
	
	public loginFrame(String title){ //title�Ǵ�������
		
		super(title);   //��ǰû�취����title--->�ø���ȥ����
		this.init();
	}
	
	
	
	
	/*//����һ������   ======��ǰ�����
	final JFrame frame = new JFrame("��¼����");*/
	
	//����һ�����
	private JPanel mainpanel = new JPanel();
	//����title��ʾ����
	private JLabel titleLable = new JLabel("�� �� �� �� ϵ ͳ");
	//�����˺ź�����ı���
	private JLabel accuntLable = new JLabel("�� ��:");
	private JLabel passwordLable = new JLabel("�� ��:");
	//���������˺ź�������ı���/�����
	private final JTextField accuntFiled = new JTextField();
	private final JPasswordField passwordFiled = new JPasswordField();
	
	//����������ť
	private JButton loginButton = new JButton("��¼");
	private JButton exitButton = new JButton("�˳�");
	
	//����ÿһ�������λ��  ��С ���� ���ֵȵ�
	protected void set(){
		
		//���������λ��----------���ֹ���
		//�߽�ʽ(����������)BorderLayout(JFrame)         ��ʽ(����)FlowLayout(JPanel)
		//����ʽGridLayout                 �Զ���(null)
		
		//����panel���ֹ���Ϊ�Զ��巽ʽ
		mainpanel.setLayout(null);
		mainpanel.setBackground(Color.white);
		//����ÿһ�������λ��
		
		titleLable.setBounds(120,40,340,35);
		//���������С
		titleLable.setFont(new Font("����",Font.BOLD,34));
		//�����û���lable��λ�ú������С
		accuntLable.setBounds(94, 124, 90,30);
		accuntLable.setFont(new Font("����",Font.BOLD,24));
		//�����û���field��λ�ú������С
		accuntFiled.setBounds(204, 124, 260, 30);
		accuntFiled.setFont(new Font("����",Font.BOLD,24));
		//��������lable��λ�ú������С
		passwordLable.setBounds(94, 174, 90, 30);
		passwordLable.setFont(new Font("����",Font.BOLD,24));
		//��������field��λ�ú������С
		passwordFiled.setBounds(204, 174, 260, 30);
		passwordFiled.setFont(new Font("����",Font.BOLD,24));
		
		//���õ�¼��ť��λ�úʹ�С
		loginButton.setBounds(154, 234, 100, 30);
		loginButton.setFont(new Font("����",Font.BOLD,22));
		//�����˳���ť��λ�úʹ�С
		exitButton.setBounds(304, 234, 100, 30);
		exitButton.setFont(new Font("����",Font.BOLD,22));
		
	}
	//�����е��������ڴ�����
	protected void addElement(){
		
		//�����е���������������
		mainpanel.add(titleLable);
		mainpanel.add(accuntLable);
		mainpanel.add(accuntFiled);
		mainpanel.add(passwordLable);
		mainpanel.add(passwordFiled);
		mainpanel.add(loginButton);
		mainpanel.add(exitButton);
		this.add(mainpanel);
	}
	
	//���¼��ļ���
	protected void addListener(){
		//���¼�������
		//new������� --->���췽��˽��  ���췽�����е���û���޲�����   �������ӿ�
		/*ActionListener listener = new ImplListener();  //��̬��Ӧ��(��ʱ��Ҫ������newһ�µ����޲����Ĺ��췽��,����ActionListener�ǽӿ�)
		loginButton.addActionListener(listener);//�۲���ģʽ*/		
		
		//�����ڲ���
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//1.��ȡ�û�������˺ź�����
				//�ӵ�¼�����ϵ�����ڻ�ȡ   �ı���  �����
				//2.����֮ǰ��service��ĵ�½����
				String account = accuntFiled.getText();
				char[] value = passwordFiled.getPassword();  //���ַ����������
				String password = new String(value);         //���������ַ���
				UserService service =MySpring.getBean("Service.UserService"); //new UserService();
				String result = service.login(account,password);
				//3.�ж����յĽ��
				if(result.equals("��ϲ���¼�ɹ�")){
					//�����µĿ��Խ���
					new ExamFrame(account+"�Ŀ��Դ���");
				}else{
					//����һ�������
					JOptionPane.showMessageDialog(loginFrame.this, result); //(��ǰ���ڵĸ��࣬�����������)
					//�����ı����������ֵΪ��
					accuntFiled.setText("");
					passwordFiled.setText("");
				}
			}
			
		};  
		loginButton.addActionListener(listener);
	}

	//�����Լ���״̬
	protected void setFrameSelf(){

		//���ô�����ʼλ�úʹ�С
		this.setBounds(600, 280, 600, 380);
		//���õ���ر��˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С������ק
		this.setResizable(false);
		//���ô�����ʾ״̬
		this.setVisible(true);
	}
	
}
