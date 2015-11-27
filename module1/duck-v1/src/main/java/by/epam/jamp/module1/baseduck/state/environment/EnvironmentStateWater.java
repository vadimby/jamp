package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourDrink;

class EnvironmentStateWater extends EnvironmentState {

	void stateExit(EnvironmentStateType owner) {
	}

	void stateEnter(EnvironmentStateType owner) {
		System.out.println("*** ��������� �������� �� ��������  ***");
		owner.getDuck().setRechargeBehaviour(new RechargeBehaviourDrink());
	}

}