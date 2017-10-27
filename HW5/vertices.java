package HW5;

import java.util.ArrayList;

public class vertices {
	private int dt;
	private int id;
	private ArrayList<vertice> arr = new ArrayList<vertice>();
	public void setDt(int delayTime){
		dt = delayTime;
	}
	public void setID(int id){
		this.id = id;
	}
	public void addList(vertice v){
		arr.add(v);
	}
	public int getListLength(){
		return arr.size();
	}
	public int getId(){
		return id;
	}
	public int getArrEleID(int index){
		return arr.get(index).getId();
	}
	public int getArrEleDT(int index){
		return arr.get(index).getDelayTime();
	}
	public int getDelayTime(){
		return dt;
	}
	public vertice getVertice(int index){
		return arr.get(index);
	}
}
