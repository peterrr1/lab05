package producer;

import collections.Fifo;

public class Producer implements Runnable {
	
	private String message;
	private int number;
	private Fifo fifo;
	private long timemillis;
	
	public Producer(Fifo fifo, String message, long timemillis) {
		this.message = message;
		this.number = 0;
		this.fifo = fifo;
		this.timemillis = timemillis;
	}
	
	public void run() {
		
		while (true) {
			try {
				fifo.put(this.message + " " + this.number);
				System.out.println("produced " + this.message + " " + this.number++ + " " + System.currentTimeMillis());
				Thread.sleep(timemillis);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
