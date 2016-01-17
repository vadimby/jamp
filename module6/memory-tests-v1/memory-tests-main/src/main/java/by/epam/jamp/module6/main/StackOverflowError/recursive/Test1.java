package by.epam.jamp.module6.main.StackOverflowError.recursive;

public class Test1 {
	
	private int frameIndex;

	public void test() {
		frameIndex++;
		System.out.println("Frame:" + frameIndex);
		test();
	}
	
	
}
