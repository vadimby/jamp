package by.epam.jamp.module1.baseduck.state.environment;

class EnvironmentStateGround extends EnvironmentState {
	
	void stateExit(EnvironmentStateType owner) {
		
	}

	void stateEnter(EnvironmentStateType owner) {
		System.out.println("*** ��������� �������� �� �������� ***");
		owner.getDuck().setCurrentBehaviours(owner.getGroundBehaviours());
	}

}