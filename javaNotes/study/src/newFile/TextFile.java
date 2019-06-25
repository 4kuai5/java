package newFile;

public class TextFile {
	public void testOne(){
		this.testTwo();
		System.out.println("方法一");
	}
	public void testTwo(){
		this.testThree();
		System.out.println("2");
	}
	public void testThree(){
		System.out.println("3");
	}
//递归-------->本质是方法的调用
//练习          盖宝塔
//public void buildTower(int floor){
	//for (int i=1;i<=floor;i++){
		//System.out.println("盖到"+floor+"层宝塔啦");
	 //}
//}
//递归的想法                    想让我做事，我要求让别人把之前的事情做好
//1. 让别人先做事        2. 我自己做事
public void BuildTower(int floor){//5
	//所以判断当前是否为1层，不是就找别人干活
	//找一个别人干活干第4层
	if(floor>1){
	this.BuildTower(floor-1);
	//我自己做事
	}
	System.out.println("盖到"+floor+"层宝塔啦");
}
//public void BuildTower(int floor){//4
	//找一个别人干活干第3层
	//this.BuildTower(floor-1);
	//我自己做事
	//System.out.println("盖到"+floor+"层宝塔啦");
//}
//public void BuildTower(int floor){//3
	//找一个别人干活干第2层
	//this.BuildTower(floor-1);
	//我自己做事
	//System.out.println("盖到"+floor+"层宝塔啦");
//}
//public void BuildTower(int floor){//2
	//找一个别人干活干第1层
	//this.BuildTower(floor-1);
	//我自己做事
	//System.out.println("盖到"+floor+"层宝塔啦");
//}
//public void BuildTower(int floor){//1
	//System.out.println("盖到"+floor+"层宝塔啦");
//}



public static void main (String[] args){
    TextFile tf = new TextFile();
    tf.testOne();
    tf.BuildTower(5);
}



















}







