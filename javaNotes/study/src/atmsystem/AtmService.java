package atmsystem;


//���Ͳ���ҵ��
public class AtmService {
	//��һ���඼�Ǹ�����ҵ���߼��ģ�������Ҫ�ײ����ݵ�֧��
	private AtmDao dao =new AtmDao();
	//�������е�ҵ��                                                   
	//���е�ҵ�񷽷�  ��������֮ǰ���Ż��ṹ���
	//ֻ��ҵ���߼�----->�ж�  �Ƚ�  ����ȵ�
	//�������κ����ݵĲ���  ���Ķ�������� �����Ķ�
	//���һ��ҵ�񷽷�---��¼
	public String login(String aname,String apassword){          //��¼
		User user = dao.selectOne(aname);
		if(user!=null&&user.getApassword().equals(apassword)){
			return "���ѳɹ���½";
		}
		return "�û������������";
	}
	
	//���һ��ҵ�񷽷�         ��ѯ���
	public Float queryBalance(String aname){
		User user =dao.selectOne(aname);                 //���ü�ȥ�����������
		return user.getAbalance();
	}
	//���һ��ҵ�񷽷�       ���
	public void deposit(String aname, Float depositMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User user =dao.selectOne(aname);                 //�Ҹ��˰���Ҫ�����Ķ�������
		user.setAbalance(user.getAbalance()+depositMoney);
		dao.update(user);                                //���Ҹ��˰��Ҳ���������ٴ��ȥ
			
	}
	//���һ��ҵ�񷽷�       ȡ��
	public void withdrawal(String aname, Float withdrawalMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User user =dao.selectOne(aname);                 //�Ҹ��˰���Ҫ�����Ķ�������
		if(user.getAbalance()>withdrawalMoney){
			user.setAbalance(user.getAbalance()-withdrawalMoney);
			dao.update(user);                           //���Ҹ��˰��Ҳ���������ٴ��ȥ
		}else{
			System.out.println("�Բ���,�𾴵�"+aname+"������������");
		}	
	}
	//���һ��ҵ�񷽷�       ת��
	public void transfer(String outName,String inName, Float transferMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User outUser =dao.selectOne(outName);                 //�Ҹ��˰���Ҫ�����Ķ�������
		if(outUser.getAbalance()>transferMoney){
			User inUser = dao.selectOne(inName);
			if(inUser!=null){ //ת����˻��Ǵ��ڵ�
				outUser.setAbalance(outUser.getAbalance()-transferMoney);
				inUser.setAbalance(inUser.getAbalance()+transferMoney);
				dao.update(outUser);                           //���Ҹ��˰��Ҳ���������ٴ��ȥ
				dao.update(inUser);
			
			}else{
				System.out.println("�Բ�����������˻�������");
			}	
		}else{
			System.out.println("�Բ���,�𾴵�"+outUser+"������������");
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*//�������(���ļ���Ϣ�Ž��ڴ�ȥ)
	//���ֵ�¼�ķ��� ÿһ�ε��ö���Ҫ�������ܵ�      ��ȡ�ļ���Ϣ
	//�ڴ��в�����¼��ҵ����ļ�����һ���ط�--->��ȡ�Ĺ��̺���
	//�뵽һ��������� ����һ��map(�̶���һ��������ѭ��)����(�ɸı��С)�䵱����;���ļ��е�����ȫ��������,��һ��
	//�����Ժ�login���˾Ϳ���ȥmap����,�ȽϷ���
	
	//һ�м�¼  ����һ�����������;   һ����--->һ������--->��������
	//���ϳ��˿��Գ䵱����     ��ǿִ����������  ������������¼���޸�
	private HashMap<String,User> userBox = new HashMap<String,User>();//ǰ����Ѱ����������ͷ������(������������);��������������Ϣ������
	FileReader fileReader=null;
	BufferedReader bufferedReader=null;
	//������Ŀ��:�ڶ��󴴽�֮ǰ �����Ͻ��и�ֵ����
	{
		try {
			//����һ��������  ��ȡ��ʵ�ļ��ļ�¼
			File file=new File("src\\atmsystem\\User.txt");         
			fileReader = new FileReader(file);
		    bufferedReader=new BufferedReader(fileReader );
		    String value = bufferedReader.readLine();
		    while(value!=null){
		    	//value����Ϣ��ֳ�����  ����һ��User����  �������Ըպô洢 ������뼯����
		    	String[] userValue= value.split("-");
		    	User user = new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));//��Ϊ���Ķ�����Float���͵ģ�������Ҫ������String
		    	userBox.put(userValue[0], user);  //��������ż��������ȥ����һ������ put(��(�˺�)��user����)
		    	value = bufferedReader.readLine();
		    }
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{          // �ر���
			try {
				if(fileReader!=null){         //�ж����Ƿ񴴽��ɹ�(�ɹ��͹���)
				fileReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{          // �ر���
				try {
					if(bufferedReader!=null){         //�ж����Ƿ񴴽��ɹ�(�ɹ��͹���)
					bufferedReader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
	
	
	//���һ������ Ŀ����Ϊ���ҵ�����ҵ�����
	//�в���(�˺���)     ����ֵ(һ������user)
	public User selectOne(String aname){
		return  userBox.get(aname);               //ÿ�������ﶼ��Ҫ�ȵ�������������뵽������
	}
	//���һ������  Ŀ����Ϊ�˽�ĳһ���޸���ϵĶ�����뼯��
	
	public void update(User user){
		userBox.put(user.getAname(), user); //���������޸�
		this.commit();                      //����ʱ���������õ�д���ļ�
	}
	
	//��������������յ�����ȫ��д���ļ��� �ļ��ڵ����������滻��
	public void commit(){
		FileWriter fileWriter=null;                       
		BufferedWriter bufferedWriter=null;            //��������Ҫ�ر���(�����ó���)
		try {
			//����һ���ַ����ļ������
			File file =new File("src\\atmsystem\\User.txt");
			fileWriter = new FileWriter(file);
			//FileWriter�ǵͼ���
		    //��һ�д洢������,������BufferedWriter--->������(�߼���)��Ҫ�ͼ����Ĺ���
			bufferedWriter =new BufferedWriter(fileWriter);
			Iterator<String> names = userBox.keySet().iterator(); //������  ����ѭ������   ; <���м�������>
			while(names.hasNext()){
				String name = names.next();  //�����ڻ�ȡ��ĳһ������; Ϊ����Ҫ������Ӧ�Ķ���
				User user = userBox.get(name);  //��¼һ���˵���ʵ����
				//��user�����е���ʵ����ƴ�ӳ�һ���ַ���
				StringBuilder builder =new StringBuilder(user.getAname());
				builder.append("-");
				builder.append(user.getApassword());
				builder.append("-");
				builder.append(user.getAbalance());
				//�ַ��͵��ļ��������ƴ�Ӻõ�builderд���ļ�
				bufferedWriter.write(builder.toString());
				bufferedWriter.newLine();      // д��ȥһ����֮��  ����д��һ����
				bufferedWriter.flush();        //ѹ��ȥ
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ //�ر���       ����Ҫ�����ó�ȥ
			try {
				if(fileWriter!=null){
					fileWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(bufferedWriter!=null){
					bufferedWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
	}
	----------------------------------------------------------------------------------
	----------------------------------------------------------------------------------
	//�������е�ҵ��                                                   �ڶ����Ż�����
	//���һ��ҵ�񷽷�---��¼
	public String login(String aname,String apassword){          //��¼
		User user = this.selectOne(aname);
		if(user!=null && user.getApassword().equals(apassword)){
			return "��¼�ɹ�";
		}
		return "�û������������";
	}
	
	//���һ��ҵ�񷽷�         ��ѯ���
	public Float queryBalance(String aname){
		User user =this.selectOne(aname);                 //���ü�ȥ�����������
		return user.getAbalance();
	}
	//���һ��ҵ�񷽷�       ���
	public void deposit(String aname, Float depositMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User user =this.selectOne(aname);                 //�Ҹ��˰���Ҫ�����Ķ�������
		user.setAbalance(user.getAbalance()+depositMoney);
		this.update(user);                       //���Ҹ��˰��Ҳ���������ٴ��ȥ
		this.commit();                      //����ʱ���������õ�д���ļ�
			
	}
	//���һ��ҵ�񷽷�       ȡ��
	public void withdrawal(String aname, Float withdrawalMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User user =this.selectOne(aname);                 //�Ҹ��˰���Ҫ�����Ķ�������
		if(user.getAbalance()>withdrawalMoney){
			user.setAbalance(user.getAbalance()-withdrawalMoney);
			this.update(user);                           //���Ҹ��˰��Ҳ���������ٴ��ȥ
			this.commit();                      //����ʱ���������õ�д���ļ�
		}else{
			System.out.println("�Բ���,�𾴵�"+aname+"������������");
		}	
	}
	//���һ��ҵ�񷽷�       ת��
	public void transfer(String outName,String inName, Float transferMoney){
		 //�Ƚ������ڵ����������޸�     �ҵ�ĳһ��user����  �����е�balance�����޸�
		User outUser =this.selectOne(outName);                 //�Ҹ��˰���Ҫ�����Ķ�������
		if(outUser.getAbalance()>transferMoney){
			User inUser = this.selectOne(inName);
			if(inUser!=null){ //ת����˻��Ǵ��ڵ�
				outUser.setAbalance(outUser.getAbalance()-transferMoney);
				inUser.setAbalance(inUser.getAbalance()+transferMoney);
				this.update(outUser);                           //���Ҹ��˰��Ҳ���������ٴ��ȥ
				this.update(inUser);
				this.commit();                      //����ʱ���������õ�д���ļ�
			}else{
				System.out.println("�Բ�����������˻�������");
			}	
		}else{
			System.out.println("�Բ���,�𾴵�"+outUser+"������������");
		}	
	}
*/	
	
	
	
	/*//�������е�ҵ��           ��һ�ּ��׷���
	//���һ��ҵ�񷽷�---��¼
	public String login(String aname,String apassword){          //��¼
		try {
			//����һ��������  ��ȡ��ʵ�ļ��ļ�¼
			File file=new File("src\\atmsystem\\User.txt");          //���·��(û���̷�)
			FileReader fileReader = new FileReader(file);            //FileReader�ǵͼ���
		    //��һ�д洢������,������BufferedReader--->������(�߼���)��Ҫ�ͼ����Ĺ���
            BufferedReader bufferedReader=new BufferedReader(fileReader);
        
            String value = bufferedReader.readLine();                //readLine():����һ��һ�ж�; value��ʾһ���˵�������Ϣ
            while(value!=null){                                      //�ж�һ���Ƿ������Ϣ
            	String[] user = value.split("-");                    //spilt():���չ�����; user����洢��һ���˵���Ϣ
            	if(user[0].equals(aname)){
            		if(user[1].equals(apassword)){
            			return "��½�ɹ�";
            		}
            	}
            	value = bufferedReader.readLine();                  //������������㣬�������һ�еıȽ�
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "�û������������";
	}*/

}
