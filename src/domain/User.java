package domain;

import java.util.Date;

import myenum.Color;

public class User {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override//声明该方法是从分类上继承过来的,执行编译器的检查
	public String toString() {
		return super.toString();
	}
	@SuppressWarnings("all")//抑制警告 值有好多,只需要知道一个 all  抑制所有的警告
	private String username;
	
	public static void main(String[] args){
		new Date().toLocaleString();
		add();
	}
	@Deprecated//声明 该方法不赞成使用（已过时或有bug）
	public  static void add() {
		
	}
	public  static void add(int ... args) {
			
	}
	private Color RED;//枚举，只能使用已经定义好的东西
}
