package by.epam.jamp.module8.task1.v4;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {

	private final static Logger LOG = Logger.getLogger(Consumer.class);

	private static final String CONSOLE_PREFIX = "Consumer [ %s ]";
	private static final String MESSAGE_FORMAT = " - %-50s";

	private final SharedResource sharedResource;
	private final int consumerId;

	private final String postfix;

	public Consumer(int consumerId, SharedResource sharedResource) {
		this.consumerId = consumerId;
		this.sharedResource = sharedResource;
		this.postfix = getPostfix(consumerId);
	}

	public void run() {
		while (true) {
			sharedResource.getLock().lock();
			try {
				while (sharedResource.getMinSize() + 1 > getDataSize()) {
					LOG.debug(getLogMessage("waiting for product"));
					sharedResource.getMoreThanMinSize().await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				sharedResource.getLock().unlock();
			}

			try {
				LOG.debug(getLogMessage("trying to take a product"));
				Integer id = sharedResource.getData().take();
				LOG.debug(getLogMessage("take the product with id: " + id));
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}

	private String getPostfix(int consumerId) {
		return String.format("| %" + (consumerId * 4 + 45) + "s", " ") + consumerId + "< %s";
	}

	private String getLogMessage(String message) {
		return String.format(CONSOLE_PREFIX, consumerId) + String.format(MESSAGE_FORMAT, message)
				+ String.format(postfix, getDataSize());
	}

	private int getDataSize() {
		return sharedResource.getData().size();
	}

}
