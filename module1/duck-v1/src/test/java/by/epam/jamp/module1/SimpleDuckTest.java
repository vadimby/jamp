package by.epam.jamp.module1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.simpleduck.SimpleDuck;
import by.epam.jamp.module1.toyduck.ToyDuck;

public class SimpleDuckTest {

	@Test
	public void testSimpleDuck() {
		
		List<Duck> ducks = new ArrayList<Duck>();
		
		ducks.add(new SimpleDuck());
		ducks.add(new ToyDuck());

		for (Duck duck : ducks) {
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
			duck.recharge();

			duck.swim();
			duck.recharge();

			duck.fly();

			duck.quack();

			duck.recharge();
			duck.walk();
			duck.walk();
			duck.walk();
			duck.walk();

			duck.swim();

			duck.fly();

			duck.quack();

			duck.recharge();
			
			System.out.println("=============================");
		}
		

	}

}
