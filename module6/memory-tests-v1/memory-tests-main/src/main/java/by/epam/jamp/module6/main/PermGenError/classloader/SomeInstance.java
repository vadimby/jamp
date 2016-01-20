package by.epam.jamp.module6.main.PermGenError.classloader;

public class SomeInstance implements SomeInterface {

	private int counter;
	private Leak leak;

	private static final long[] SOME_BIG_DATA = new long[3000000];

	public Leak leak() {
		return new Leak(leak);
	}

	public SomeInterface copy(SomeInterface someInterface) {
		if (someInterface != null) {
			counter = someInterface.counter();
			leak = someInterface.leak();

		}
		return this;
	}

	public int counter() {
		return counter++;
	}

}
