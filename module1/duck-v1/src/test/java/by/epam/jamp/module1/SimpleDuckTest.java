package by.epam.jamp.module1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourBirdsStyle;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourWaiveWings;
import by.epam.jamp.module1.baseduck.behaviours.quack.impl.QuackBehaviourDefault;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourChangeBattery;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEat;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourDuck;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourKeepOnWater;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourCharged;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviors;
import by.epam.jamp.module1.simpleduck.SimpleDuck;
import by.epam.jamp.module1.simpleduck.SimpleDuckBehaviours;
import by.epam.jamp.module1.simpleduck.SimpleDuckStatesBehaviours;
import by.epam.jamp.module1.toyduck.ToyDuck;
import by.epam.jamp.module1.toyduck.ToyDuckBehaviours;
import by.epam.jamp.module1.toyduck.ToyDuckStatesBehaviours;

public class SimpleDuckTest {

	@Test
	public void testSimpleDuck() {

		List<Duck> ducks = new ArrayList<Duck>();

		DuckBehaviours simpleDuckBehaviours = new SimpleDuckBehaviours();
		simpleDuckBehaviours.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		simpleDuckBehaviours.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours.setRechargeBehaviour(new RechargeBehaviourEat());
		simpleDuckBehaviours.setWalkBehaviour(new WalkBehaviourCharged());
		simpleDuckBehaviours.setSwimBehaviour(new SwimBehaviourDuck());

		StatefullDuckBehaviors statefullSimpleDuckBehaviors = new SimpleDuckStatesBehaviours(simpleDuckBehaviours,
				simpleDuckBehaviours, simpleDuckBehaviours, simpleDuckBehaviours, simpleDuckBehaviours,
				simpleDuckBehaviours);

		ducks.add(new SimpleDuck(statefullSimpleDuckBehaviors));

		DuckBehaviours toyDuckBehaviours = new ToyDuckBehaviours();
		toyDuckBehaviours.setFlyBehaviour(new FlyBehaviourWaiveWings());
		toyDuckBehaviours.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours.setWalkBehaviour(new WalkBehaviourCharged());
		toyDuckBehaviours.setSwimBehaviour(new SwimBehaviourKeepOnWater());

		StatefullDuckBehaviors statefullToyDuckBehaviors = new ToyDuckStatesBehaviours(toyDuckBehaviours,
				toyDuckBehaviours, toyDuckBehaviours, toyDuckBehaviours, toyDuckBehaviours, toyDuckBehaviours);

		ducks.add(new ToyDuck(statefullToyDuckBehaviors));

		for (Duck duck : ducks) {
			for (int i = 0; i < 11; i++) {
				duck.walk();
			}

			duck.recharge();
			duck.walk();

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
