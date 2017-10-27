package HW5;

public class vertice {
	private int edgeDelayTime;
	private vertices v;
	private int id;
	public void setEDT(int edt){
		edgeDelayTime = edt;
	}
	public void setVertices(vertices v){
		this.v = v;
	}
	public void setID(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public int getDelayTime(){
		return edgeDelayTime;
	}
	public vertices getVertice(){
		return v;
	}
}
