package jojo.action;

public class SayHiAction {
	private String ename = "Hi~";
	
	public void setEname(String ename){
		this.ename = ename;
	}
	
	public String getEname(){
		return ename;
	}
	
	public String execute(){
		System.out.println("action3 running!!");

		return "success";
	}
}
