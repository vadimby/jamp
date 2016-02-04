package by.epam.jamp.module8.task2.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		final int SIZE = 1000000;

		List<Integer> myList = new ArrayList<Integer>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			int value = (int) (Math.random() * 1000);
			myList.add(value);
		}

		QuickSort<Integer> quickSort = new QuickSort<Integer>(myList);

		ForkJoinPool pool = new ForkJoinPool();
		// printArray(myList);
		System.out.println("Start");
		long currentTimeMillis = System.currentTimeMillis();
		pool.invoke(quickSort);
		// printArray(myList);
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		System.out.println("Done");

	}

	private static void printArray(List<Integer> array) {
		for (Integer integer : array) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

}
