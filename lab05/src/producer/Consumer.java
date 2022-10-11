package producer;

import collections.Fifo;

public class Consumer extends Thread {
	
	private Fifo fifo;
	private String s;
	private int number;
	
	public Consumer(Fifo f, String s, int n) {
		this.fifo = f;
		this.s = s;
		this.number = n;
	}
	
	public void run() {
		while (true) {
			try {
				//String nameRead = fifo.get();
				System.out.println("consumed " + s + " " + fifo.get() + " " + System.currentTimeMillis());
				sleep(number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
