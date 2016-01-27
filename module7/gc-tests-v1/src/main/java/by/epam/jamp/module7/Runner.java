package by.epam.jamp.module7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner {

	public static void main(String[] main) throws InterruptedException {
		List<Data> data = new ArrayList<Data>();
		while (true) {
			for (int i = 0; i < new Random().nextInt(15); i++) {
				data.add(new Data());
			}
			Thread.sleep(100);
			for (int i = 0; i < new Random().nextInt(5); i++) {
				if (data.size() > 0) {
					data.remove(0);
					System.out.println(" - Data has been REMOVED.");
				}
				if (data.size() > 0) {
					data.remove(data.size() - 1);
					System.out.println(" - Data has been REMOVED.");
				}
			}
			Thread.sleep(100);

			System.out.printf(" i Current number of elements: %s\n", data.size());
		}
	}
}

class Data {

	private int[] data = new int[10 * 1024];

	public Data() {
		System.out.println(" + Data has been CREATED.");
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(" x Data has been FINALIZED.");
	}

}