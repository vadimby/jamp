package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public abstract class EnvironmentState {
	public static final EnvironmentState GROUND = new EnvironmentStateGround();
	public static final EnvironmentState WATER = new EnvironmentStateWater();
	public static final EnvironmentState AIR = new EnvironmentStateAir();
	
	public abstract void stateEnter(StatefullDuck duck);

}
