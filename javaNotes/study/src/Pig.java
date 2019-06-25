
public class Pig {
	public String name;
	public int weight;
	
	public void killed(){
		System.out.println(this.name+"说轻点捅，疼死我了");
	}
	public void gropUp(int month){
		for(int i=1;i<=month;i++){
			this.weight=i*2;
		}
	}
	public int getWeight(){
		return this.weight;
	}
	public String getName(){
		return this.name;
	}
}
