package by.epam.jamp.module8.task1.v4;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		SharedResource sharedResource = new SharedResource(5, 10);

		Thread.sleep(200);
		List<Thread> c = new ArrayList<Thread>();
		List<Thread> p = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			c.add(new Thread(new Consumer(i, sharedResource)));
			p.add(new Thread(new Producer(i, sharedResource)));
		}

		Thread.sleep(200);
		
		for (Thread thread : p) {
			thread.start();
		}

		for (Thread thread : c) {
			thread.start();
		}

	}

}
