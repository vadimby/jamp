package by.epam.jamp.module8.task2.v2;

public class ThreadPoolManager {

	private final int capacity;
	private final MyQueue<Runnable> myQueue = new MyQueue<Runnable>();

	public ThreadPoolManager(int capacity) {
		this.capacity = capacity;
		initAllConsumers();
	}

	private void initAllConsumers() {
		for (Integer i = 0; i < capacity; i++) {
			Thread thread = new Thread(new Worker(myQueue));
			thread.setDaemon(true);
			thread.start();
		}
	}

	public void submitTask(Runnable r) {
		myQueue.enqueue(r);
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return myQueue.size();
	}

}