package by.epam.jamp.module8.task1.v2;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

	private final Queue<Integer> data = new LinkedList<Integer>();
	private final int minSize;
	private final int maxSize;
	private final Object lock = new Object();

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

	public Object getLock() {
		return lock;
	}

}
