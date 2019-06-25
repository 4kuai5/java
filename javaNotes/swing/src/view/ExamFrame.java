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
	//��ȡQuestionService����
	QuestionService service = MySpring.getBean("Service.QuestionService");
	//ͨ��service����getPaper������ȡһ��������ɵ��Ծ�              �������ǿ����Լ�����
	ArrayList<Question> paper = service.getPaper(5);
	//����һ�����ڴ洢ѧ��ѡ��Ĵ𰸵�����             String[] ������paperһ��
	private char[] answers = new char[paper.size()];
	
	
	//������������  �ֱ�����Ҳ�message����
	private int nowNum = 0;  //��¼��ǰ��Ŀ���
	private int totalCount = paper.size(); //��¼����
	private int answerCount = 0; //��¼�Ѿ��ش���ϵ���Ŀ����
	private int unanswerCount = totalCount;//��¼��û�лش������
	
	
	//����һ���̶߳���  ����ʱ��仯
	private TimeControlThread timeControlThread = new TimeControlThread();
	/*//����һ������ ������¼����
	private int time = 60;*/
	//����һ������  ������¼ʱ��(����Ϊ��λ)
	private int time = 1; 
	
	//=====================================================
	//��ӹ��췽��
	public ExamFrame(){
		this.init();
	}
	public ExamFrame(String title){
		super(title);
		this.init();
	}

	//�������panel  ����ķָ�
	private JPanel mainPanel = new JPanel(); //���������ҳ���չʾ
	private JPanel messagePanel = new JPanel(); //�����Ҳ���Ϣ��չʾ
	private JPanel buttonPanel = new JPanel(); //�����·���ť��չʾ
	private JTextArea examArea = new JTextArea(); //�����ı���  չʾ��Ŀ
	private JScrollPane scrollPane = new JScrollPane(examArea); //������
	//����Ҳ���Ϣ�����
	private JLabel pictureLable = new JLabel(); //չʾͼƬ��Ϣ
	private JLabel nowNumLable = new JLabel("��ǰ���:"); //��ʾ��ǰ�����
	private JLabel totalCountLable = new JLabel("��Ŀ����:"); //��ʾ��ǰ��Ŀ������
	private JLabel answerCountLable = new JLabel("�Ѵ�����:"); //��ʾ�Ѿ��������Ŀ����
	private JLabel unanswerCountLable = new JLabel("δ������:"); //��ʾδ��������
	private JTextField nowNumFiled = new JTextField(); // չʾ���
	private JTextField totalCountFiled = new JTextField(); //չʾ����
	private JTextField answerCountFiled = new JTextField(); //չʾ�Ѵ���
	private JTextField unanswerCountFiled = new JTextField(); //չʾδ����
	private JLabel timeLable = new JLabel("ʣ�����ʱ��"); //��ʾʣ��ʱ��
	private JLabel realTimeLable = new JLabel("00;00:00"); //����ʱ��ʵʱ��
	//����·���������
	private JButton aButton = new JButton("A"); // a��ť
	private JButton bButton = new JButton("B"); // b��ť
	private JButton cButton = new JButton("C"); // c��ť
	private JButton dButton = new JButton("D"); // d��ť
	private JButton prevButton = new JButton("��һ��"); // ��һ��
	private JButton nextButton = new JButton("��һ��"); // ��һ��
	private JButton submitButton = new JButton("�ύ�Ծ�"); // �ύ��ť
	
	
	protected void set() {	
		//����panel���ֹ��� ---->�Զ���
		mainPanel.setLayout(null);
		messagePanel.setLayout(null);
		buttonPanel.setLayout(null);
		//�ֶ�����ÿһ�������λ��  ����  ����
		mainPanel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(16, 10, 650, 450);//������
		examArea.setFont(new Font("����",Font.BOLD,34));
		examArea.setEnabled(false);//�ı����е����ֲ��ܱ༭            //ȥ���Ϳ������ı����д�����
		
		//validate();  //�����������
		
		messagePanel.setBounds(680, 10, 300, 550);
		messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // �Ҳ�����߿�
		
		buttonPanel.setBounds(16, 470, 650, 90);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //��������߿�
		
		//����p2������ÿһ�������λ�� ��С ��ɫ
		pictureLable.setBounds(10, 10, 280, 230);
		pictureLable.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		
		//picture.setIcon(null);//չʾͼƬ��Ϣ
		nowNumLable.setBounds(40, 270, 100, 30);
		nowNumLable.setFont(new Font("����",Font.PLAIN,20));
		nowNumFiled.setBounds(150, 270, 100, 30);
		nowNumFiled.setFont(new Font("����",Font.BOLD,20));
		nowNumFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		nowNumFiled.setEnabled(false);
		nowNumFiled.setHorizontalAlignment(JTextField.CENTER);//�����������־���
		
		totalCountLable.setBounds(40, 310, 100, 30);
		totalCountLable.setFont(new Font("����",Font.PLAIN,20));
		totalCountFiled.setBounds(150, 310, 100, 30);
		totalCountFiled.setFont(new Font("����",Font.BOLD,20));
		totalCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		totalCountFiled.setEnabled(false);
		totalCountFiled.setHorizontalAlignment(JTextField.CENTER);//�����������־���
		
		answerCountLable.setBounds(40, 350, 100, 30);
		answerCountLable.setFont(new Font("����",Font.PLAIN,20));
		answerCountFiled.setBounds(150, 350, 100, 30);
		answerCountFiled.setFont(new Font("����",Font.BOLD,20));
		answerCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		answerCountFiled.setEnabled(false);
		answerCountFiled.setHorizontalAlignment(JTextField.CENTER);//�����������־���
		
		unanswerCountLable.setBounds(40, 390, 100, 30);
		unanswerCountLable.setFont(new Font("����",Font.PLAIN,20));
		unanswerCountFiled.setBounds(150, 390, 100, 30);
		unanswerCountFiled.setFont(new Font("����",Font.BOLD,20));
		unanswerCountFiled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		unanswerCountFiled.setEnabled(false);
		unanswerCountFiled.setHorizontalAlignment(JTextField.CENTER);//�����������־���
		
		timeLable.setBounds(90, 460, 150, 30);
		timeLable.setFont(new Font("����",Font.PLAIN,20));
		timeLable.setForeground(Color.blue);
		
		realTimeLable.setBounds(108, 490, 150, 30);
		realTimeLable.setFont(new Font("����",Font.BOLD,20));
		realTimeLable.setForeground(Color.blue);
		
		

		aButton.setBounds(40, 10, 120, 30);
		aButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //����ȥ��Ϊһ��С��
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
		submitButton.setForeground(Color.RED); //������ɫ
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//--------------------------------------------------------------------------
		//չʾ������Ŀ(��һ��)
		this.showQuestion();
		//���������Ҳ�message�е����ֵ----�ñ�������
		nowNumFiled.setText(nowNum+1+"");              //ƴ�մ�����ΪҪ�ķ���ֵ������String���͵�
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
		//����һ������������   �����ύ��ť
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//0.�ύ֮ǰ��ʾһ�������,�Ƿ������˲��ύ
				//JOptionPane.showMessageDialog(parentComponent, message);  ��Ϣ��
				//ȷ�Ͽ� ------> ��-0; ��-1; ȡ��-2  ------>ͨ������ֵȷ��
				int value = JOptionPane.showConfirmDialog(ExamFrame.this, "�Ƿ�ȷ���ύ�Ծ�");   //ȷ�Ͽ򣨵�ǰ������ڵĸ��׿�,��ǰ��ڵ����֣�
				if(value==0){
					
					//1.����ʱʱ��ֹͣ   ----���߳̽���
					//timeControlThread.stop(); //������ ��������
					timeControlThread.setFlag(false);  //�л����̵߳�״̬
					//2.���а�ťʧЧ
					ExamFrame.this.setOptionButtonEnabled(false);  //����ѡ��ʧЧ
					prevButton.setEnabled(false);
					nextButton.setEnabled(false);
					//3.����ɫ�ع鱾ɫ
					ExamFrame.this.clearOptionButtonColor();
					//4.���ճɼ��ļ���        չʾ���м���ı�����
					float score = ExamFrame.this.checkPaper();
					examArea.setText("���Խ���\n���ĳɼ�Ϊ:"+score);
				}
			}
		});
		
		//����һ������������  ������һ�ⰴť
		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ԭ4��ѡ�ť��״̬  �����Ǳ�ɿ��õ�
				ExamFrame.this.setOptionButtonEnabled(true);
				//������һ�ⰴť    ��ɿ���
				nextButton.setEnabled(true);
				//��ǰ��Ŀ��ż���һ��
				nowNum--;
				if(nowNum==0){   //�����ǰ���Ϊ0 �Ѿ������һ��  ����һ�ⰴť����
					prevButton.setEnabled(false);
				}else{
					//���û�ԭ�����֮ǰѡ�������һ��ѡ��
					ExamFrame.this.restorButton();
					//��ʾ��Ŀ
					ExamFrame.this.showQuestion();
					//�޸��Ҳ����   �Ѵ���  δ����
					nowNumFiled.setText(nowNum+1+"");
					answerCountFiled.setText(--answerCount+"");
					unanswerCountFiled.setText(++unanswerCount+"");
				}
				
				
			}
		});
		
		//����һ������������   ������һ�ⰴť
		nextButton.addActionListener(new ActionListener() {              //()�������һ����������
			@Override
			public void actionPerformed(ActionEvent e) {
				//���������ѡ�ť����ɫ
				ExamFrame.this.clearOptionButtonColor();
				//��ǰ��Ŀ�������һ��
				nowNum++;
				//��ǰ����Ŀ�Ƿ񵽴����
				if(nowNum==totalCount){  //�������һ����
					examArea.setText("ȫ����Ŀ�Ѿ��ش����\n�����·���ɫ�ύ��ť");
					//ȫ����Ŀ�Ѿ��ش����  ����һ����Ŀ��ťʧЧ
					nextButton.setEnabled(false);
					//��ȫ��ѡ�ťʧЧ
					ExamFrame.this.setOptionButtonEnabled(false);
				}else{  //��û��
					//�����Լ���װ�ķ�����ʾ��һ����Ŀ��ͼƬ
					ExamFrame.this.showQuestion();
					//�޸��Ҳ൱ǰ�����
					nowNumFiled.setText(nowNum+1+"");
				}
				//�޸��Ҳ��Ѵ����δ������Ŀ
				answerCountFiled.setText(++answerCount+"");
				unanswerCountFiled.setText(--unanswerCount+"");
			}
		});
		
		
		
		
		
		
		
		//����һ������������  �����ĸ�ѡ�ť
		ActionListener  optionListrner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.������е�ѡ�ť��ɫ
				ExamFrame.this.clearOptionButtonColor();           //��������һ�������ڲ���
				//2.��ȡ����һ����ť��ɫ�仯һ��
				JButton button =(JButton)e.getSource();//
				//3.�õ�ǰ��ť��ɫ�仯һ��
				button.setBackground(Color.GREEN);
				//4.����ǰ��ť��ѡ��洢��answers������0 
				answers[nowNum] = button.getText().charAt(0);            //��ȡѡ���е�����
				
			}
		};
		//�������������������ĸ�ѡ�ť����
		aButton.addActionListener(optionListrner);
		bButton.addActionListener(optionListrner);
		cButton.addActionListener(optionListrner);
		dButton.addActionListener(optionListrner);
	}
	
	protected void setFrameSelf() {
		this.setBounds(260, 180, 1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); //�����ô�����ק��С
		this.setVisible(true);  //����չʾ��������
		
		timeControlThread.start();//�����Լ�������̶߳���   ���뵽����״̬  ʱ�䴦��
	}
	
	//1.��Ӻö�����---->�������
	
	//2.����---->��������   ����  ����  λ��  ����  �ȵ�
	
	//3.����---->���������һ��
	
	//4.����---->���ʱ�����
	
	//5.����---->�����Լ�����Ϣ
	//============================================================
	//���һ������  ��������ͼƬչʾ
	private ImageIcon drawImage(String path){
		//ͨ��������·������һ��icon����
		ImageIcon imageIcon = new ImageIcon(path);
		//����imageIcon�����ڵ�image����
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(280, 230, Image.SCALE_DEFAULT));
		//�����úõ�imageIcon���󷵻�
		return imageIcon;
	}
	
	//���һ������  ����չʾһ����Ŀ
	private void showQuestion(){
		//��paper�л�ȡ��ǰ��һ����Ŀ
		Question question = paper.get(nowNum); //��������  ��� �� ͼƬ·��(�п�����null)
		//��ȡ��ǰquestion��ͼƬ��·��
		String picture = question.getPicture(); //ͼƬ·��
		if(picture!=null){  //��ͼƬ·������Ϣ
			pictureLable.setIcon(this.drawImage("src//img//"+picture));
		}else{  //û��ͼƬ��Ϣ
			pictureLable.setIcon(null);
		}
		
		//����һ����Ŀ�еı��<br>��ʾ����
		examArea.setText((nowNum+1)+"."+question.getTitle().replace("<br>", "\n   "));
	}

	//���һ������ ������е�ѡ�ť��ɫ
	private void clearOptionButtonColor(){
		aButton.setBackground(null);
		bButton.setBackground(null);
		cButton.setBackground(null);
		dButton.setBackground(null);
	}
	//���һ������   ������ѡ�ťʧЧ
	private void setOptionButtonEnabled(boolean key){  //ʧ��ʧЧ�ɲ�������
		aButton.setEnabled(key);
		bButton.setEnabled(key);
		cButton.setEnabled(key);
		dButton.setEnabled(key);
		
	}
	//���һ������   ����ԭ��һ���ѡ��
	private void restorButton(){
		//��ȡ��ǰ��Ŀ�Ĵ�(ѧ��ѡ����Ǹ�)
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

	//���һ���ڲ���  Ϊ�˴���ʱ�䵹��ʱ������--------->�߳�
	private class TimeControlThread extends Thread{
		private boolean flag = true; //��ʱ����ִ���̴߳���
		public void setFlag(boolean flag){
			this.flag=flag;
		}
		
		public void run(){
			//�Ȱ�time����ת��     Сʱ:����:��
			int hour = time/60;
			int minute = time%60;
			int second = 0;
			while(flag){
				//�����������洢�����ֽ���ƴ������
				StringBuilder timeString = new StringBuilder();
				//����Сʱ
				if(hour>=0&&hour<10){
					timeString.append("0");
					
				}
				timeString.append(hour);
				timeString.append(":");
				//�������
				if(minute>=0&&minute<10){
					timeString.append("0");
					
				}
				timeString.append(minute);
				timeString.append(":");
				//������
				if(second>=0&&second<10){
					timeString.append("0");
					
				}
				timeString.append(second);
				//����realTimeLable   չʾһ��ƴ���Ժ��ʱ���ַ���
				/*SwingUtilities.invokeLater(new Runnable(){     //ϵͳ��һ����������治��ʹ,��������д
					public void run(){
						realTimeLable.setText(timeString.toString());
					}
				});*/
				realTimeLable.setText(timeString.toString());
				try {
					Thread.sleep(1000);   //����ֵ
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				//�ı�
				if(second>0){
					second--;
				}else{           //����Ϊ0
					if(minute>0){
						minute--;
						second=59;
					}else{
						if(hour>0){
							hour--;
							minute=59;
							second=59;
						}else{
							System.out.println("ʱ���ֹ");
							//ʱ����ʾΪ��ɫ
							realTimeLable.setForeground(Color.RED);
							//���а�ť���ܲ���
							ExamFrame.this.setOptionButtonEnabled(false);
							prevButton.setEnabled(false);
							nextButton.setEnabled(false);
							//����һ����Ϣ��   ���߿��Խ���  
							JOptionPane.showMessageDialog(ExamFrame.this,"���Խ���,���ύ");
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

	//���һ������ ����������յĳɼ�
	private float checkPaper(){
		float score = 100;
		int size = paper.size();
		for(int i=0;i<size;i++){  //paper��һ��ArrayList<Question>   titel  answer  picture
			Question question = paper.get(i);  //�õ�һ�ݾ���
			String realAnswer = question.getAnswer();
			if(realAnswer.equals(answers[i])){
				score-=(100/size);
			}
		}
		return score;
	}
}

