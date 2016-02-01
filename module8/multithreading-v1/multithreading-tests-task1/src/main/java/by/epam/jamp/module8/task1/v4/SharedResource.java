package by.epam.jamp.module8.task1.v4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedResource {

	private final BlockingQueue<Integer> data;
	private final int minSize;

	public SharedResource(final int minSize, final int maxSize) {

		data = new ArrayBlockingQueue<Integer>(maxSize, true);
		this.minSize = minSize;
	}

	public BlockingQueue<Integer> getData() {
		return data;
	}

	public int getMinSize() {
		return minSize;
	}

}
