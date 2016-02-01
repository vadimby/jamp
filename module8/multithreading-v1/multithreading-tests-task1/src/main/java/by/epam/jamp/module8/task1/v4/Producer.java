package by.epam.jamp.module8.task1.v4;

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
			try {

				int id = counter++;
				sharedResource.getData().put(id);
				LOG.debug("Producer [ " + producerId + " ] - produce product with ID: " + id + "\t queue size:"
						+ sharedResource.getData().size());
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
