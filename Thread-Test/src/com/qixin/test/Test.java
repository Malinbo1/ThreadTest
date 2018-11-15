package com.qixin.test;

public class Test {

	public static void main(String[] args) {
		User from = new User("张三", 20000);
		User to = new User("李四", 20000);
		Object obj = new Object();
		int fromHash = System.identityHashCode(from);
		int toHash = System.identityHashCode(to);
		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				if(fromHash<toHash) {
					synchronized (from) {
						System.out.println("get from....");
						synchronized (to) {
							System.out.println("get to....");
							from.flymoney(2000);
							to.addmoney(2000);
							System.out.println(from.getMoney());
						}
					}
				}else if (fromHash>toHash) {
					synchronized (to) {
						System.out.println("get to....");
						synchronized (from) {
							System.out.println("get from....");
							from.flymoney(4000);
							to.addmoney(4000);
							System.out.println(from.getMoney());
						}
					}
				}else {
					synchronized (obj) {
						synchronized (from) {
							System.out.println("get from....");
							synchronized (to) {
								System.out.println("get to....");
								from.flymoney(2000);
								to.addmoney(2000);
								System.out.println(from.getMoney());
							}
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				if(fromHash<toHash) {
					synchronized (from) {
						System.out.println("get from....");
						synchronized (to) {
							System.out.println("get to....");
							from.flymoney(2000);
							to.addmoney(2000);
							System.out.println(from.getMoney());
						}
					}
				}else if (fromHash>toHash) {
					synchronized (to) {
						System.out.println("get to....");
						synchronized (from) {
							System.out.println("get from....");
							from.addmoney(6000);
							to.flymoney(6000);
							System.out.println(from.getMoney());
						}
					}
				}else {
					synchronized (obj) {
						synchronized (from) {
							System.out.println("get from....");
							synchronized (to) {
								System.out.println("get to....");
								from.flymoney(2000);
								to.addmoney(2000);
								System.out.println(from.getMoney());
							}
						}
					}
				}
			}
		}).start();
	}
}
