package thread;

public class TestMain {

	
	public static void main(String[] args) {
		Window w1=new Window("������վ");
		Window w2=new Window("������վ");
		Window w3=new Window("������վ");
		w1.start();
		w2.start();
		w3.start();
	}

}
