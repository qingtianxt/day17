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
	@Override//�����÷����Ǵӷ����ϼ̳й�����,ִ�б������ļ��
	public String toString() {
		return super.toString();
	}
	@SuppressWarnings("all")//���ƾ��� ֵ�кö�,ֻ��Ҫ֪��һ�� all  �������еľ���
	private String username;
	
	public static void main(String[] args){
		new Date().toLocaleString();
		add();
	}
	@Deprecated//���� �÷������޳�ʹ�ã��ѹ�ʱ����bug��
	public  static void add() {
		
	}
	public  static void add(int ... args) {
			
	}
	private Color RED;//ö�٣�ֻ��ʹ���Ѿ�����õĶ���
}
