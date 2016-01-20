package by.epam.jamp.module6.main.PermGenError.classloader;

public class Leak {

	private Leak leak;

	public Leak(Leak leak) {
		this.leak = leak;
	}

}
