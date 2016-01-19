package by.epam.jamp.module6.main;

import by.epam.jamp.module6.main.OutOfMemoryError.generator.OutOfMemoryErrorGenerator;
import by.epam.jamp.module6.main.PermGenError.generotor.PermGenErrorGenerator;
import by.epam.jamp.module6.main.StackOverflowError.constructor.StackOverflowErrorConstructor;
import by.epam.jamp.module6.main.StackOverflowError.recursive.StackOverflowErrorRecursive;

public class Runner {

	private static final int STACKOVERFLOW_WITH_RECURSION = 1;
	private static final int STACKOVERFLOW_WITH_CONSTRUCTOR = 2;
	private static final int OUTOFMEMORY_WITH_OBJECT_GENERATOR = 3;
	private static final int PERMGEN_WITH = 4;

	private static final int DEFAULT_TEST_INDEX = PERMGEN_WITH;

	public static void main(String[] args) {

		MemoryTest test = getMemoryTest(getTestNumberFromArgs(args));
		test.runTest();

	}

	private static MemoryTest getMemoryTest(int index) {
		MemoryTest test;
		switch (index) {
		case STACKOVERFLOW_WITH_CONSTRUCTOR:
			test = new StackOverflowErrorConstructor();
			break;
		case OUTOFMEMORY_WITH_OBJECT_GENERATOR:
			test = new OutOfMemoryErrorGenerator();
			break;
		case PERMGEN_WITH:
			test = new PermGenErrorGenerator();
			break;
		case STACKOVERFLOW_WITH_RECURSION:
		default:
			test = new StackOverflowErrorRecursive();
			break;
		}
		return test;
	}

	private static int getTestNumberFromArgs(String[] args) {
		int result = DEFAULT_TEST_INDEX;

		if (args == null || args.length == 0 || args[0] == null) {
			return result;
		}

		try {
			result = Integer.parseInt(args[0]);
		} catch (Exception e) {

		}

		return result;
	}

}
