package atmsystem;

import java.util.Scanner;

public class TestMain {
	/*1.实现一个银行业务系统
	2.要求有如下功能
		登录
		查询余额
		存款
		取款
		转账
		开户
		销户
	3.记录银行的用户信息
		账号-密码-余额               BufferedReader  readLine*/
	public static void main(String[] args) {
		
		AtmService service = new AtmService();
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎使用银行自助服务系统\n请输入账号");
		String aname = input.nextLine();
		System.out.println("请输入密码");
		String apassword = input.nextLine();
		String loginResult = service.login(aname,apassword);
		if(loginResult.equals("您已成功登陆")){
			System.out.println("恭喜您登陆成功,请输入操作项");
			System.out.println("查询余额请输入1\n存款请输入2\n取款请输入3\n转账请输入4\n退出请输入5");
			String option =input.nextLine();
			int op=Integer.parseInt(option);
			switch(op){        //JDK版本不够
				case 1:
					Float abalance = service.queryBalance(aname);
					System.out.println("尊敬的"+aname+"用户，您的可用余额为"+abalance);
					break;
				case 2:       //存款
					System.out.println("请输入您要存款的金额");
					String s =input.nextLine();
					Float f = Float.parseFloat(s);
					service.deposit(aname, f);
					if(f<=20000&&f>0){
					System.out.println("存入成功");
					}else{
						System.out.println("尊敬的"+aname+"用户,您的操作有误,请重新输入!");
					}
					break;
				case 3:     //取款
					System.out.println("请输入您要取款的金额");
					String q =input.nextLine();
					Float qk = Float.parseFloat(q);
					service.withdrawal(aname, qk);
					System.out.println("操作成功");
					break;
				case 4:    //转账
					System.out.println("请输入您的名字");
					String out =input.nextLine();
					System.out.println("请输入对象的名字");
					String in =input.nextLine();
					System.out.println("请输入你要转入的金额");
					String zz =input.nextLine();
					Float je = Float.parseFloat(zz);
					service.transfer(out, in, je);
					System.out.println("操作成功");
					break;
				case 5:   //退出
					System.out.println("感谢您的使用再见");
					break;
			}
		}else{
			System.out.println("对不起,"+loginResult);
		}

	}

}
