package HW7;

public class stack {
	private String[] s ;
	private int top;
	stack(){
		s = new String[100000];
		top = -1;
	}
	
	public void push(String c){
		s[++top] = c;
	}
	public String pop(){
		return s[top--];
	}
	public boolean empty(){
		if(top==-1){
			return true;
		}
		return false;
	}
	public int getTop(){
		return top;
	}
}
