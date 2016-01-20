package by.epam.jamp.module6.main.PermGenError.classloader;

import by.epam.jamp.module6.main.MemoryTest;

public class PermGenErrorClassloader implements MemoryTest {

	private static SomeInterface class1;
	private static SomeInterface class2;

	public void runTest() {
		try {
			class1 = DynamicInstanceFactory.newInstance().copy(null);

			while (true) {
				class2 = DynamicInstanceFactory.newInstance().copy(class1);

				//Thread.currentThread().sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
