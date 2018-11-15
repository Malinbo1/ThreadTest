package com.qixin.test;

public class User {

	private String name;
	private int money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public User(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public void addmoney(int count) {
		this.money=money+count;
	}
	
	public void flymoney(int count) {
		this.money=money-count;
	}

}
