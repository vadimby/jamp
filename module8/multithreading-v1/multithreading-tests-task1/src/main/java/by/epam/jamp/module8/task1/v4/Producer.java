package by.epam.jamp.module8.task1.v4;

import org.apache.log4j.Logger;

public class Producer implements Runnable {

	private final static Logger LOG = Logger.getLogger(Producer.class);

	private static final String CONSOLE_PREFIX = "Producer [ %s ]";
	private static final String MESSAGE_FORMAT = " - %-50s";

	private static volatile int counter = 0;

	private final SharedResource sharedResource;
	private final int producerId;
	private final String postfix;

	public Producer(int producerId, SharedResource sharedResource) {
		this.producerId = producerId;
		this.sharedResource = sharedResource;
		this.postfix = getPostfix(producerId);
	}

	public void run() {
		while (true) {
			try {
				int id = counter++;
				LOG.debug(getLogMessage("trying to produce the product with ID: " + id));
				sharedResource.getData().put(id);
				LOG.debug(getLogMessage("produce the product with ID: " + id));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedResource.getLock().lock();
			try {
				sharedResource.getMoreThanMinSize().signalAll();
			} finally {
				sharedResource.getLock().unlock();
			}
		}

	}

	private String getPostfix(int producerId) {
		return String.format("| %" + (producerId * 4 + 1) + "s", " ") + producerId + "> %s";
	}

	private String getLogMessage(String message) {
		return String.format(CONSOLE_PREFIX, producerId) + String.format(MESSAGE_FORMAT, message)
				+ String.format(postfix, getDataSize());
	}

	private int getDataSize() {
		return sharedResource.getData().size();
	}

}
