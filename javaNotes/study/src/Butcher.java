
public class Butcher {
	public void killPig(Pig pig){
		System.out.println("屠夫执行了杀猪的方法");
		int pigweight=pig.getWeight();
		String pigname=pig.getName();
		System.out.println(pigname+"的体重是"+pigweight);
		pig.killed();
	}

}
