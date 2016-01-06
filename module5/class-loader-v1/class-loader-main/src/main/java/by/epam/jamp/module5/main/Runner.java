package by.epam.jamp.module5.main;

public class Runner {

	public static void main(String[] args) {
		
		try {
			Class<?> loadClass = Thread.currentThread().getContextClassLoader().loadClass("by.epam.jamp.module5.main.SomeClass");
			Object newInstance = loadClass.newInstance();
			System.out.println(newInstance.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
