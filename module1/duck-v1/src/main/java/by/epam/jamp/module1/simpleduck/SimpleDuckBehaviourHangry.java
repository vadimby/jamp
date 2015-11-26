package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.BaseDuck;
import by.epam.jamp.module1.baseduck.BaseDuckBehaviour;

public class SimpleDuckBehaviourHangry extends BaseDuckBehaviour {

	public SimpleDuckBehaviourHangry(BaseDuck duck) {
		super(duck);
	}

	public void walk() {
		System.out.println("голодная... не может идти.");
	}

	public void swim() {
		System.out.println("голодная... не может плыть.");
	}

	public void fly() {
		System.out.println("голодная... не может лететь.");

	}

	public void quack() {
		System.out.println("голодная... не может идти.");

	}

	public void renew() {
		getDuck().recharge();
		System.out.println("поела так то лучше");
		getDuck().setDuckBehaviour(new SimpleDuckBehaviourNormal(getDuck()));
	}

}
