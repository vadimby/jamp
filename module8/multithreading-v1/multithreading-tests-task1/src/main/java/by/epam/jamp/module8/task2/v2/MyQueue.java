package by.epam.jamp.module8.task2.v2;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<E> implements CustomQueue<E> {

	private Queue<E> queue = new LinkedList<E>();

	public synchronized void enqueue(E e) {
		queue.add(e);
		notifyAll();
	}

	public synchronized E dequeue() {
		E e = null;

		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e1) {
				return e;
			}
		}
		e = queue.remove();
		return e;
	}

	public int size() {
		return queue.size();
	}
}