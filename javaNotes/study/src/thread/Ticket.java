package thread;

public class Ticket {

	private String start;//��ʼվ��
	private String end;//�յ�վ��
	private Float price;//Ʊ��
	
	public Ticket(){}
	public Ticket(String start,String end,Float price){
		
		this.start=start;
		this.end=end;
		this.price=price;
	}
	
	//Ϊ���ô�ӡ��ʱ���÷��㣬��ӡһ������Ϳ�����(�൱��ʡ����ticket.getStart......)
	//��дtoString����
	public String toString(){
		StringBuilder builder =new StringBuilder("[");       //��StringBuilderƴ��
		builder.append(this.start);                          //append׷��
		builder.append("-->");
		builder.append(this.end);
		builder.append(":");
		builder.append(this.price);
		builder.append("]");
		return builder.toString();                          //��builder������toString����ȥ
		
	}
	public String getStart() {//Ϊ��˽�����Ը�ֵ����
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
}
