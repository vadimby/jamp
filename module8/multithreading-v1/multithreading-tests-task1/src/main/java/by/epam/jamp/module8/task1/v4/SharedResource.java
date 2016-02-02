package by.epam.jamp.module8.task1.v4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	private final BlockingQueue<Integer> data;
	private final int minSize;
	private final Lock lock = new ReentrantLock();
	private final Condition moreThanMinSize = getLock().newCondition();

	public SharedResource(BlockingQueue<Integer> data, final int minSize) {
		this.data = data;
		this.minSize = minSize;
	}

	public BlockingQueue<Integer> getData() {
		return data;
	}

	public int getMinSize() {
		return minSize;
	}

	public Lock getLock() {
		return lock;
	}

	public Condition getMoreThanMinSize() {
		return moreThanMinSize;
	}

}
