package by.epam.jamp.module8.task1.v4;

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
			Integer id;
			try {
				id = sharedResource.getData().take();
				LOG.debug("Consumer [ " + consumerId + " ] - take the product with id: " + id + "\t queue size:"
						+ sharedResource.getData().size());
				Thread.sleep(2);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
