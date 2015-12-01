package by.epam.jamp.module1.baseduck.state.charge.impl;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeState;

public class ChargeStateEmpty extends ChargeState {

	@Override
	public void stateEnter(StatefullDuck duck) {
		System.out.println("*** ��������� �������� �� �������� ***");
		duck.setCurrentBehaviours(duck.getStateBehaviours().getStatesBehaviours().get(duck.getCurrentState()));
	}

}