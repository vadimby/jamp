package by.epam.jamp.module8.task1.v1;

public class Runner {

	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource(5, 10);
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Consumer(i, sharedResource)).start();
			new Thread(new Producer(i, sharedResource)).start();
		}
		
	}

}
