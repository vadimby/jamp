package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEat;

class EnvironmentStateGround extends EnvironmentState {
	
	void stateExit(EnvironmentStateType owner) {
		
	}

	void stateEnter(EnvironmentStateType owner) {
		System.out.println("*** поведение изменено на наземное ***");
		owner.getDuck().setRechargeBehaviour(new RechargeBehaviourEat());
	}

}