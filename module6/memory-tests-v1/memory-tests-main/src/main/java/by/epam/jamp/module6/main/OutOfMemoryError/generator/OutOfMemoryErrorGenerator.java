package by.epam.jamp.module6.main.OutOfMemoryError.generator;

import java.util.ArrayList;
import java.util.List;

import by.epam.jamp.module6.main.MemoryTest;

public class OutOfMemoryErrorGenerator implements MemoryTest {

	public void runTest() {

		List<Object> objects = new ArrayList<Object>();
		for (int i = 0;; i++) {
			objects.add(new B());
			System.out.println("objects num:" + i);
		}

	}

	class B {

		private String[] array = new String[(int) (Integer.MAX_VALUE / 10)];
	}

}
