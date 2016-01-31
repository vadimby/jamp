package by.epam.jamp.module8.task1;

public class Producer implements Runnable {

	private final SharedResource sharedResource;
	private final int producerId;

	public Producer(int producerId, SharedResource sharedResource) {
		this.producerId = producerId;
		this.sharedResource = sharedResource;
	}

	public void run() {
		for (int i = 0;; i++) {
			sharedResource.produce(producerId, i);
		}

	}

	public SharedResource getSharedResource() {
		return sharedResource;
	}

}
