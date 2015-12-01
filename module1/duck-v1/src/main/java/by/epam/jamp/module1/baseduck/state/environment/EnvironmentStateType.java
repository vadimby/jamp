package by.epam.jamp.module1.baseduck.state.environment;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public interface EnvironmentStateType {

	void toAir(StatefullDuck duck);

	void toGround(StatefullDuck duck);

	void toWater(StatefullDuck duck);

}
