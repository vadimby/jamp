package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEatInAir;

class EnvironmentStateAir extends EnvironmentState {
	
	void stateExit(EnvironmentStateType owner) {
	}

	void stateEnter(EnvironmentStateType owner) {
		System.out.println("*** поведение изменено на воздушное ***");
		owner.getDuck().getCurrentBehaviours().setRechargeBehaviour(new RechargeBehaviourEatInAir());
	}

}