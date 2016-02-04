package by.epam.jamp.module8.task2.v2;

import java.util.List;

public class QuickSort<T extends Comparable<T>> {

	private static ThreadPoolManager THREAD_POOL;
	private List<T> data;
	private int left;
	private int right;

	private volatile static int count = 1;

	public QuickSort(List<T> data, int threadsNumber) {
		THREAD_POOL = new ThreadPoolManager(threadsNumber);
		this.data = data;
		this.left = 0;
		this.right = data.size() - 1;
	}

	private QuickSort(List<T> data, int left, int right) {
		QuickSort.count++;
		this.data = data;
		this.left = left;
		this.right = right;

	}

	public void sort() {
		compute();
	}

	private void compute() {

		if (left < right) {
			final int pivotIndex = left - (left - right) / 2;
			final int newPivotIndex = partition(pivotIndex);
			THREAD_POOL.submitTask(new Runnable() {
				public void run() {
					new QuickSort<T>(data, left, newPivotIndex - 1).compute();
				}
			});
			THREAD_POOL.submitTask(new Runnable() {
				public void run() {
					new QuickSort<T>(data, newPivotIndex + 1, right).compute();
				}
			});
		}
		QuickSort.count--;
	}

	private int partition(int pivotIndex) {
		T pivotValue = data.get(pivotIndex);

		swap(pivotIndex, right);

		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (data.get(i).compareTo(pivotValue) < 0) {
				swap(i, storeIndex);
				storeIndex++;
			}
		}

		swap(storeIndex, right);

		return storeIndex;
	}

	private void swap(int i, int j) {
		if (i != j) {
			T iValue = data.get(i);

			data.set(i, data.get(j));
			data.set(j, iValue);
		}
	}

	public boolean isActive() {
		return count > 0;
	}
}