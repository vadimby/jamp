package by.epam.jamp.module1.baseduck.state.position;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public interface PositionStateType {

	void moveNorth(StatefullDuck duck);

	void moveSouth(StatefullDuck duck);

	void moveWest(StatefullDuck duck);

	void moveEast(StatefullDuck duck);

}
