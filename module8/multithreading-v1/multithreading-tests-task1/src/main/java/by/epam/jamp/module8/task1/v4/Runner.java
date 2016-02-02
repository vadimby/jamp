package by.epam.jamp.module8.task1.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		SharedResource sharedResource = new SharedResource(new ArrayBlockingQueue<Integer>(10, true), 5);

		List<Thread> t = new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			t.add(new Thread(new Consumer(i, sharedResource)));
			t.add(new Thread(new Producer(i, sharedResource)));
		}

		for (Thread thread : t) {
			thread.start();
		}

	}

}
