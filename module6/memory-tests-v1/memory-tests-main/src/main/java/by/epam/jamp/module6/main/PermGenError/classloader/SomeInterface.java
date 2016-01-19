package by.epam.jamp.module6.main.PermGenError.classloader;

public interface SomeInterface {

	SomeInterface copy(SomeInterface someInterface);

	int counter();

	Leak leak();

}
