package by.epam.jamp.module1.baseduck.behaviours.move.impl;

import by.epam.jamp.module1.baseduck.behaviours.move.MoveBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.quack.QuackBehaviour;

public class MoveBehaviourLowBattery implements MoveBehaviour {

	private QuackBehaviour quackBehaviour;
	private int quackTimes;

	public MoveBehaviourLowBattery(QuackBehaviour quackBehaviour, int quackTimes) {
		this.quackBehaviour = quackBehaviour;
		this.quackTimes = quackTimes;
	}

	public void move() {
		System.out.println("*** сели батарейки ***");
		for (int i = 0; i < quackTimes; i++) {
			quackBehaviour.quack();
		}
	}

}
