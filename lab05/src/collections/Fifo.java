package collections;

import java.util.LinkedList;

public class Fifo {
	
	private LinkedList<String> list = new LinkedList<>();
	
	public Fifo() {
		
	}
	
	public void put(String param) throws InterruptedException {
		synchronized (list) {
			System.out.println("put " + Thread.currentThread().getName());
			while (list.size() < 10) {
				list.push(param);
				list.notify();
				return;
			}
			list.wait();
		}
	}
	
	public String get() throws InterruptedException {
		synchronized (list) {
			System.out.println("get " + Thread.currentThread().getName());
			while (list.size() == 0) {
				list.wait();
			}
			list.notify();
			return list.pollLast();
		}
	}
}