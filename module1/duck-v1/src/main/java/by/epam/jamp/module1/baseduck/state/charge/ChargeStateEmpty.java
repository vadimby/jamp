package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class ChargeStateEmpty extends ChargeState {

	@Override
	public void stateEnter(StatefullDuck duck) {
		System.out.println("*** поведение изменено на голодное ***");
		duck.setCurrentBehaviours(duck.getStateBehaviours().getStatesBehaviours().get(duck.getCurrentState()));
	}

}