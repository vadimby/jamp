package by.epam.jamp.module1.baseduck.behaviours.move.impl;

import by.epam.jamp.module1.baseduck.behaviours.move.MoveBehaviour;

public class MoveBehaviourNoCharge implements MoveBehaviour{

	public void move() {
		System.out.println("*** не хватает энергии на движение ***");
	}

}
