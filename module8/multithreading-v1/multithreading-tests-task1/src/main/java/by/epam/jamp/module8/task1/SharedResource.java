package by.epam.jamp.module8.task1;

import org.apache.log4j.Logger;

public class SharedResource {

	private final static Logger LOG = Logger.getLogger(SharedResource.class);
	private final int maxValue;
	private final int minValue;

	private int value;
	private final Object lock = new Object();

	public SharedResource(int initValue, int minValue, int maxValue) {
		this.value = initValue;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public int getValue() {
		return value;
	}

	public void consume(int consumerId, int i) {
		// LOG.debug("consume(c"+consumerId+ "," + i +",1):" + value);
		synchronized (lock) {
			if (minValue < value) {
				value--;
			} 
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("consume(c");
			stringBuilder.append(consumerId);
			stringBuilder.append(",");
			stringBuilder.append(i);
			stringBuilder.append(",\t2)   ");
			for (int j = 0; j < 15 + consumerId; j++) {
				stringBuilder.append("   ");
			}
			stringBuilder.append("<<");
			stringBuilder.append(value);
			LOG.debug(stringBuilder.toString());
		}

		sleep();

	}

	public void produce(int producerId, int i) {
		// LOG.debug("produce(p"+producerId+ "," + i +",1):" + value);
		synchronized (lock) {
			if (value < maxValue) {
				value++;
			}
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("produce(c");
			stringBuilder.append(producerId);
			stringBuilder.append(",");
			stringBuilder.append(i);
			stringBuilder.append(",\t2)   ");
			for (int j = 0; j < producerId; j++) {
				stringBuilder.append("   ");
			}
			stringBuilder.append(">>");
			stringBuilder.append(value);
			LOG.debug(stringBuilder.toString());
		}
		sleep();

	}

	private void sleep() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
