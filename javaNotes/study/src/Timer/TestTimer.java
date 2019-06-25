package Timer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class TestTimer {
	private int count=1;             //��¼����
	
	//���� ����  �洢�����˵ĵ绰��
	private ArrayList<String> userBox=new ArrayList<String>();
	{
		userBox.add("a");userBox.add("b");userBox.add("c");userBox.add("d");
	}
	//���һ������  ���㻵��   ��������
	//ÿ��һ��ʱ��  ����һЩ����
	public void test() throws ParseException{
		System.out.println("Ҫ����׼����");
		Timer timer=new Timer();  //����һ��С�߳�  ����¼  ÿ��һ��ʱ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       //ʱ���ʽ
		Date firstTimer=sdf.parse("2019-4-12 17:21:00");                        //ת��ʱ��
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("��"+count+++"��ִ��");
				for(int i=0;i<userBox.size();i++){
					System.out.println("��"+userBox.get(i)+"������һ����Ϣ��[�ƶ�ѩ����������]");
				}
				System.out.println("˵�˵�ʵ���濪��");
			}}, firstTimer, 3000);             //task ���� ��time ʱ�� ��delay �೤ʱ���Ժ�period ʱ������(����)
	}
	public static void main(String[] args){
		TestTimer t1=new TestTimer();
		try {
			t1.test();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
