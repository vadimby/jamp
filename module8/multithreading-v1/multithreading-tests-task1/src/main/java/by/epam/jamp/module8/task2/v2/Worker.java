package by.epam.jamp.module8.task2.v2;

public class Worker implements Runnable {

	private MyQueue<Runnable> myQueue;

	public Worker(MyQueue<Runnable> myQueue) {
		this.myQueue = myQueue;
	}

	public void run() {
		while (true) {
			Runnable r = myQueue.dequeue();
			r.run();
		}
	}
}