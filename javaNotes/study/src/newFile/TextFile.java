package newFile;

public class TextFile {
	public void testOne(){
		this.testTwo();
		System.out.println("����һ");
	}
	public void testTwo(){
		this.testThree();
		System.out.println("2");
	}
	public void testThree(){
		System.out.println("3");
	}
//�ݹ�-------->�����Ƿ����ĵ���
//��ϰ          �Ǳ���
//public void buildTower(int floor){
	//for (int i=1;i<=floor;i++){
		//System.out.println("�ǵ�"+floor+"�㱦����");
	 //}
//}
//�ݹ���뷨                    ���������£���Ҫ���ñ��˰�֮ǰ����������
//1. �ñ���������        2. ���Լ�����
public void BuildTower(int floor){//5
	//�����жϵ�ǰ�Ƿ�Ϊ1�㣬���Ǿ��ұ��˸ɻ�
	//��һ�����˸ɻ�ɵ�4��
	if(floor>1){
	this.BuildTower(floor-1);
	//���Լ�����
	}
	System.out.println("�ǵ�"+floor+"�㱦����");
}
//public void BuildTower(int floor){//4
	//��һ�����˸ɻ�ɵ�3��
	//this.BuildTower(floor-1);
	//���Լ�����
	//System.out.println("�ǵ�"+floor+"�㱦����");
//}
//public void BuildTower(int floor){//3
	//��һ�����˸ɻ�ɵ�2��
	//this.BuildTower(floor-1);
	//���Լ�����
	//System.out.println("�ǵ�"+floor+"�㱦����");
//}
//public void BuildTower(int floor){//2
	//��һ�����˸ɻ�ɵ�1��
	//this.BuildTower(floor-1);
	//���Լ�����
	//System.out.println("�ǵ�"+floor+"�㱦����");
//}
//public void BuildTower(int floor){//1
	//System.out.println("�ǵ�"+floor+"�㱦����");
//}



public static void main (String[] args){
    TextFile tf = new TextFile();
    tf.testOne();
    tf.BuildTower(5);
}



















}







