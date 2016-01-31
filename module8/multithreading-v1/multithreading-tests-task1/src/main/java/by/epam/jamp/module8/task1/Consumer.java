package by.epam.jamp.module8.task1;

public class Consumer implements Runnable {

	private final SharedResource sharedResource;
	private final int consumerId;

	public Consumer(int consumerId, SharedResource sharedResource) {
		this.consumerId = consumerId;
		this.sharedResource = sharedResource;
	}

	public void run() {
		for (int i = 0;; i++) {
			sharedResource.consume(consumerId, i);
		}

	}

	public SharedResource getSharedResource() {
		return sharedResource;
	}

}
