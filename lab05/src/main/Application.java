package main;

import collections.Fifo;
import producer.Consumer;
import producer.Producer;

public class Application {

	public static void main(String[] args) {
		
		Fifo f1 = new Fifo();
		
		Producer p1 = new Producer(f1, "demo_p1", 1000);
		Producer p2 = new Producer(f1, "demo_p1", 1000);
		
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		
		Consumer c1 = new Consumer(f1, "demo_c1", 2000);
		Consumer c2 = new Consumer(f1, "demo_c1", 2000);
		
		t1.start();
		t2.start();
		
		c1.start();
		c2.start();
		
	
	}
}
