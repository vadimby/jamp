package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.BaseDuck;

public class SimpleDuck extends BaseDuck {

	public SimpleDuck(int powerReserve) {
		super(powerReserve);
		setDuckBehaviour(new SimpleDuckBehaviourNormal(this));
		setChargeLevel(powerReserve);
	}

	public void walk() {
		getDuckBehaviour().walk();
	}

	public void swim() {
		getDuckBehaviour().swim();
	}

	public void fly() {
		getDuckBehaviour().fly();
	}

	public void quack() {
		getDuckBehaviour().quack();
	}

	public void renew() {
		getDuckBehaviour().renew();
	}

}
