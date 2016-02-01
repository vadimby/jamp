package by.epam.jamp.module8.task1.v3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	private final Queue<Integer> data = new LinkedList<Integer>();
	private final int minSize;
	private final int maxSize;
	private final Lock lock = new ReentrantLock();
	private final Condition queueNotFull = getLock().newCondition();
	private final Condition queueNotEmpty = getLock().newCondition();

	public SharedResource(final int minSize, final int maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}

	public Queue<Integer> getData() {
		return data;
	}

	public int getMinSize() {
		return minSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public Lock getLock() {
		return lock;
	}

	public Condition getQueueNotFull() {
		return queueNotFull;
	}

	public Condition getQueueNotEmpty() {
		return queueNotEmpty;
	}

}
