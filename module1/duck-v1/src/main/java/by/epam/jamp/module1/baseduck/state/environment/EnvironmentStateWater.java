package by.epam.jamp.module1.baseduck.state.environment;

class EnvironmentStateWater extends EnvironmentState {

	void stateExit(EnvironmentStateType owner) {
	}

	void stateEnter(EnvironmentStateType owner) {
		System.out.println("*** поведение изменено на наводное  ***");
		owner.getDuck().setCurrentBehaviours(owner.getWaterBehaviours());
	}

}