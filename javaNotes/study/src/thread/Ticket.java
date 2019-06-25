package thread;

public class Ticket {

	private String start;//起始站名
	private String end;//终点站名
	private Float price;//票价
	
	public Ticket(){}
	public Ticket(String start,String end,Float price){
		
		this.start=start;
		this.end=end;
		this.price=price;
	}
	
	//为了让打印的时候变得方便，打印一个对象就可以了(相当于省略了ticket.getStart......)
	//重写toString方法
	public String toString(){
		StringBuilder builder =new StringBuilder("[");       //用StringBuilder拼接
		builder.append(this.start);                          //append追加
		builder.append("-->");
		builder.append(this.end);
		builder.append(":");
		builder.append(this.price);
		builder.append("]");
		return builder.toString();                          //把builder对象变成toString返回去
		
	}
	public String getStart() {//为了私有属性赋值方便
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
