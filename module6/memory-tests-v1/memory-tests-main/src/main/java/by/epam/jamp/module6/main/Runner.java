package by.epam.jamp.module6.main;

import by.epam.jamp.module6.main.StackOverflowError.constructor.StackOverflowErrorConstructor;
import by.epam.jamp.module6.main.StackOverflowError.recursive.StackOverflowErrorRecursive;
import by.epam.jamp.module6.main.StackOverflowError.reflection.StackOverflowErrorReflection;

public class Runner {

	public static void main(String[] args) {
		MemoryTest t1;
		
		int key = 2;
		switch (key) {
		case 1:
			t1 = new StackOverflowErrorConstructor();
			break;
		case 2:
			t1 = new StackOverflowErrorReflection();
			break;
		case 0:
		default:
			t1 = new StackOverflowErrorRecursive();
			break;
		}
		t1.runTest();

	}

}
