package by.epam.jamp.module6.main.PermGenError.classloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicInstanceFactory {

	private static final String CLASS_NAME = "by.epam.jamp.module6.main.PermGenError.classloader.SomeInstance";

	public static SomeInterface newInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, MalformedURLException {
		URLClassLoader tmp = new URLClassLoader(new URL[] { getClasspath() }) {
			public Class loadClass(String name) throws ClassNotFoundException {
				if (CLASS_NAME.equals(name)) {
					System.out.println("1: " + name);
					return findClass(name);
				}
				System.out.println("2: " + name);
				return super.loadClass(name);
			}
		};

		return (SomeInterface) tmp.loadClass(CLASS_NAME).newInstance();
	}

	private static URL getClasspath() throws MalformedURLException {
		return new URL("file:D:\\work\\projects\\jamp\\jamp\\module6\\memory-tests-v1\\memory-tests-main\\target\\classes\\");
	}

}
