package by.epam.jamp.module8.task2.v2;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		final int SIZE = 1000000;

		List<Integer> myList = new ArrayList<Integer>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			int value = (int) (Math.random() * 1000);
			myList.add(value);
		}

		QuickSort<Integer> quickSort = new QuickSort<Integer>(myList, 1);

		//printArray(myList);
		System.out.println("Start");
		long currentTimeMillis = System.currentTimeMillis();
		quickSort.sort();
		while (quickSort.isActive()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// ignore
			}
		}
		
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
		//printArray(myList);

		System.out.println("Done");

	}

	private static void printArray(List<Integer> array) {
		for (Integer integer : array) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

}
