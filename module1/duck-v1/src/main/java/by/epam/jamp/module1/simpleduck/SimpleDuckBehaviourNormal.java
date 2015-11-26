package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.BaseDuck;
import by.epam.jamp.module1.baseduck.BaseDuckBehaviour;

public class SimpleDuckBehaviourNormal extends BaseDuckBehaviour {

	public SimpleDuckBehaviourNormal(BaseDuck duck) {
		super(duck);
	}

	public void quack() {
		System.out.println("\" р€€€!\"");
	}

	public void walk() {
		System.out.println("—делала один шаг");
		
		getDuck().decreaseChargeLevel();
		if (getDuck().getChargeLevel() == 0) {
			getDuck().setDuckBehaviour(new SimpleDuckBehaviourHangry(getDuck()));
		}
		
	}

	public void swim() {
		System.out.println("плывет");
	}

	public void fly() {
		System.out.println("Ћетит");
	}

	public void renew() {
		System.out.println("ѕокушала");
	}

}
