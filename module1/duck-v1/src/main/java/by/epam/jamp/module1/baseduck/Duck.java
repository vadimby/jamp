package by.epam.jamp.module1.baseduck;

import by.epam.jamp.module1.baseduck.behaviours.fly.FlyBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.quack.QuackBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.recharge.RechargeBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.swim.SwimBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.walk.WalkBehaviour;

public abstract class Duck {

	private FlyBehaviour flyBehaviour;
	private QuackBehaviour quackBehaviour;
	private SwimBehaviour swimBehaviour;
	private WalkBehaviour walkBehaviour;
	private RechargeBehaviour rechargeBehaviour;

	public void walk() {
		walkBehaviour.walk();
	}

	public void swim() {
		swimBehaviour.swim();
	}

	public void fly() {
		flyBehaviour.fly();
	}

	public void quack() {
		quackBehaviour.quack();
	}

	public void recharge() {
		rechargeBehaviour.recharge();
	}

	public FlyBehaviour getFlyBehaviour() {
		return flyBehaviour;
	}

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}

	public QuackBehaviour getQuackBehaviour() {
		return quackBehaviour;
	}

	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	public SwimBehaviour getSwimBehaviour() {
		return swimBehaviour;
	}

	public void setSwimBehaviour(SwimBehaviour swimBehaviour) {
		this.swimBehaviour = swimBehaviour;
	}

	public WalkBehaviour getWalkBehaviour() {
		return walkBehaviour;
	}

	public void setWalkBehaviour(WalkBehaviour walkBehaviour) {
		this.walkBehaviour = walkBehaviour;
	}

	public RechargeBehaviour getRechargeBehaviour() {
		return rechargeBehaviour;
	}

	public void setRechargeBehaviour(RechargeBehaviour rechargeBehaviour) {
		this.rechargeBehaviour = rechargeBehaviour;
	}

}
