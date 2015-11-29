package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class ChargeStateFull extends ChargeState {
	
	@Override
	public void stateEnter(StatefullDuck duck) {
		System.out.println("*** поведение изменено на сытое ***");
		duck.setCurrentBehaviours(duck.getStateBehaviours().getStatesBehaviours().get(duck.getCurrentState()));
	}
	
	
}