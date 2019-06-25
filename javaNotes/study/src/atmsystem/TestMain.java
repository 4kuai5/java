package atmsystem;

import java.util.Scanner;

public class TestMain {
	/*1.ʵ��һ������ҵ��ϵͳ
	2.Ҫ�������¹���
		��¼
		��ѯ���
		���
		ȡ��
		ת��
		����
		����
	3.��¼���е��û���Ϣ
		�˺�-����-���               BufferedReader  readLine*/
	public static void main(String[] args) {
		
		AtmService service = new AtmService();
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭʹ��������������ϵͳ\n�������˺�");
		String aname = input.nextLine();
		System.out.println("����������");
		String apassword = input.nextLine();
		String loginResult = service.login(aname,apassword);
		if(loginResult.equals("���ѳɹ���½")){
			System.out.println("��ϲ����½�ɹ�,�����������");
			System.out.println("��ѯ���������1\n���������2\nȡ��������3\nת��������4\n�˳�������5");
			String option =input.nextLine();
			int op=Integer.parseInt(option);
			switch(op){        //JDK�汾����
				case 1:
					Float abalance = service.queryBalance(aname);
					System.out.println("�𾴵�"+aname+"�û������Ŀ������Ϊ"+abalance);
					break;
				case 2:       //���
					System.out.println("��������Ҫ���Ľ��");
					String s =input.nextLine();
					Float f = Float.parseFloat(s);
					service.deposit(aname, f);
					if(f<=20000&&f>0){
					System.out.println("����ɹ�");
					}else{
						System.out.println("�𾴵�"+aname+"�û�,���Ĳ�������,����������!");
					}
					break;
				case 3:     //ȡ��
					System.out.println("��������Ҫȡ��Ľ��");
					String q =input.nextLine();
					Float qk = Float.parseFloat(q);
					service.withdrawal(aname, qk);
					System.out.println("�����ɹ�");
					break;
				case 4:    //ת��
					System.out.println("��������������");
					String out =input.nextLine();
					System.out.println("��������������");
					String in =input.nextLine();
					System.out.println("��������Ҫת��Ľ��");
					String zz =input.nextLine();
					Float je = Float.parseFloat(zz);
					service.transfer(out, in, je);
					System.out.println("�����ɹ�");
					break;
				case 5:   //�˳�
					System.out.println("��л����ʹ���ټ�");
					break;
			}
		}else{
			System.out.println("�Բ���,"+loginResult);
		}

	}

}
