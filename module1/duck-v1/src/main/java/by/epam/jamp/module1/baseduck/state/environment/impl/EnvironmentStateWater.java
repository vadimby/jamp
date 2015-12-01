package by.epam.jamp.module1.baseduck.state.environment.impl;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentState;

public class EnvironmentStateWater extends EnvironmentState {

	public void stateEnter(StatefullDuck duck) {
		System.out.println("*** поведение изменено на наводное  ***");
		duck.setCurrentBehaviours(duck.getStateBehaviours().getStatesBehaviours().get(duck.getCurrentState()));
	}

}