package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.environment.impl.EnvironmentStateAir;
import by.epam.jamp.module1.baseduck.state.environment.impl.EnvironmentStateGround;
import by.epam.jamp.module1.baseduck.state.environment.impl.EnvironmentStateWater;

public abstract class EnvironmentState {
	
	// возможные состояния
	public static final EnvironmentState GROUND = new EnvironmentStateGround();
	public static final EnvironmentState WATER = new EnvironmentStateWater();
	public static final EnvironmentState AIR = new EnvironmentStateAir();
	
	public abstract void stateEnter(StatefullDuck duck);

}
