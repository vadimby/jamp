package by.epam.jamp.module1.toyduck;

import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourNoFly;
import by.epam.jamp.module1.baseduck.behaviours.quack.impl.QuackBehaviourDefault;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourChangeBattery;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourKeepOnWater;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourCharged;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class ToyDuck extends StatefullDuck {
	public ToyDuck() {
		setFlyBehaviour(new FlyBehaviourNoFly());
		setQuackBehaviour(new QuackBehaviourDefault());
		setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		setSwimBehaviour(new SwimBehaviourKeepOnWater());
		setWalkBehaviour(new WalkBehaviourCharged());
	}
}
