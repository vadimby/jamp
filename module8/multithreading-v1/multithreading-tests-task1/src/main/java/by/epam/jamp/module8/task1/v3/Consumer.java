package by.epam.jamp.module8.task1.v3;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {

	private final static Logger LOG = Logger.getLogger(Consumer.class);

	private final SharedResource sharedResource;
	private final int consumerId;

	public Consumer(int consumerId, SharedResource sharedResource) {
		this.consumerId = consumerId;
		this.sharedResource = sharedResource;
	}

	public void run() {
		while (true) {
			sharedResource.getLock().lock();
			try {
				while (sharedResource.getMinSize() >= sharedResource.getData().size()) {
					LOG.debug("Consumer [ " + consumerId + " ] - \twaiting for product - \t queue size:"
							+ sharedResource.getData().size());
					try {
						sharedResource.getQueueNotFull().await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Integer id = sharedResource.getData().poll();
				LOG.debug("Consumer [ " + consumerId + " ] - take the product with id: " + id + "\t queue size:"
						+ sharedResource.getData().size());
				sharedResource.getQueueNotEmpty().signalAll();
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				sharedResource.getLock().unlock();
			}

		}
	}

}
