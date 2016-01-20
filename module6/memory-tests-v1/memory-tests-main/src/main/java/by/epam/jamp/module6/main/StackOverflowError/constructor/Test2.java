package by.epam.jamp.module6.main.StackOverflowError.constructor;

public class Test2 {
	
	private static int frameIndex;

	public Test2() {
		frameIndex++;
		System.out.println("Frame:" + frameIndex);
		new Test2();
	}
	
}
