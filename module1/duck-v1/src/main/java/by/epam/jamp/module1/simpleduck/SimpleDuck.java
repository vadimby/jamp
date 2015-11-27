package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourBirdsStyle;
import by.epam.jamp.module1.baseduck.behaviours.quack.impl.QuackBehaviourDefault;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEat;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourDuck;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourCharged;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class SimpleDuck extends StatefullDuck {

	public SimpleDuck() {
		setFlyBehaviour(new FlyBehaviourBirdsStyle());
		setQuackBehaviour(new QuackBehaviourDefault());
		setRechargeBehaviour(new RechargeBehaviourEat());
		setSwimBehaviour(new SwimBehaviourDuck());
		setWalkBehaviour(new WalkBehaviourCharged());
	}

}
