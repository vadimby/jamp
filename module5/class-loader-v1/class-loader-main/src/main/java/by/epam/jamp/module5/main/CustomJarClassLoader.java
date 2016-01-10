package by.epam.jamp.module5.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

public class CustomJarClassLoader extends ClassLoader {

	private static final Logger LOG = Logger.getLogger(CustomJarClassLoader.class);

	private static final String WARNING = "Warning : No jar file found";

	private Class<?> clazz;

	public CustomJarClassLoader(String jarFilePath) {
		init(jarFilePath);
	}

	private void init(String jarFilePath) {
		try {
			JarFile jarFile = new JarFile(jarFilePath);
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry jarEntry = entries.nextElement();
				String className = jarEntry.getName().replace('/', '.');
				if (className.endsWith(".class")) {
					byte[] classData = loadClassData(jarFile, jarEntry);
					if (classData != null) {
						Class<?> clazz = defineClass(className.substring(0, className.length() - 6), classData, 0,
								classData.length);

						if (IModule.class.isAssignableFrom(clazz)) {
							this.clazz = clazz;
						}
					}
				}
			}
		} catch (IOException IOE) {
			// Просто выведем сообщение об ошибке
			LOG.debug(WARNING);
		}
	}

	public Class<?> loadClass() throws ClassNotFoundException {
		return loadClass(clazz.getName());
	}

	@Override
	public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
		if (clazz != null && clazz.getName().equals(name)) {
			return clazz;
		}
		return super.findSystemClass(name);
	}

	private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException {
		long size = jarEntry.getSize();
		if (size == -1 || size == 0) {
			return null;
		}
		byte[] data = new byte[(int) size];
		InputStream in = jarFile.getInputStream(jarEntry);
		in.read(data);
		return data;
	}

}