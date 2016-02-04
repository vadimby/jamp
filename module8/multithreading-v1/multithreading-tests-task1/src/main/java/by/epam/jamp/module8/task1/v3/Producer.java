package by.epam.jamp.module8.task1.v3;

import org.apache.log4j.Logger;

public class Producer implements Runnable {

	private final static Logger LOG = Logger.getLogger(Producer.class);

	private static volatile int counter = 0;

	private final SharedResource sharedResource;
	private final int producerId;

	public Producer(int producerId, SharedResource sharedResource) {
		this.producerId = producerId;
		this.sharedResource = sharedResource;
	}

	public void run() {
		while (true) {
			sharedResource.getLock().lock();
			try {
				while (sharedResource.getData().size() >= sharedResource.getMaxSize()) {
					LOG.debug("Consumer [ " + producerId + " ] - \twaiting for place - \t queue size:"
							+ sharedResource.getData().size());
					try {
						sharedResource.getQueueNotEmpty().await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				counter++;
				sharedResource.getData().add(counter);
				LOG.debug("Producer [ " + producerId + " ] - produce produce with ID: " + counter + "\t queue size:"
						+ sharedResource.getData().size());
				sharedResource.getQueueNotFull().signalAll();
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
