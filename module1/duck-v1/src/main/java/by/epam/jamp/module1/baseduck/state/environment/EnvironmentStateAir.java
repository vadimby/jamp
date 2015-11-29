package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

class EnvironmentStateAir extends EnvironmentState {
	
	public void stateEnter(StatefullDuck duck) {
		System.out.println("*** поведение изменено на воздушное ***");
		duck.setCurrentBehaviours(duck.getStateBehaviours().getStatesBehaviours().get(duck.getCurrentState()));
	}

}