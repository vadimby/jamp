package by.epam.jamp.module1;

import org.junit.Test;

import by.epam.jamp.module1.baseduck.BaseDuck;
import by.epam.jamp.module1.simpleduck.SimpleDuck;

public class SimpleDuckTest {

	@Test
	public void testSimpleDuck() {
		BaseDuck duck = new SimpleDuck(10);
		
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		
		duck.swim();
		
		duck.fly();
		
		duck.quack();
		
		duck.renew();
		duck.walk();
		duck.walk();
		duck.walk();
		duck.walk();
		
		duck.swim();
		
		duck.fly();
		
		duck.quack();
		
		duck.renew();
		
	}
	

}
