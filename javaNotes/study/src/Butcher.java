
public class Butcher {
	public void killPig(Pig pig){
		System.out.println("����ִ����ɱ��ķ���");
		int pigweight=pig.getWeight();
		String pigname=pig.getName();
		System.out.println(pigname+"��������"+pigweight);
		pig.killed();
	}

}
