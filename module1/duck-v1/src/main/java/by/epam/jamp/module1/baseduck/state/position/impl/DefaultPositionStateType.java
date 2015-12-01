package by.epam.jamp.module1.baseduck.state.position.impl;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.position.PositionStateType;
import by.epam.jamp.module1.context.Position2D;

// переключатель положения утки в координатах
public class DefaultPositionStateType implements PositionStateType {

	private Position2D currentPosition;

	public DefaultPositionStateType(Position2D startPosition) {
		this.currentPosition = startPosition;
	}

	public void moveNorth(StatefullDuck duck) {
		currentPosition.setY(currentPosition.getY() + 1);
		logPosition();
	}

	public void moveSouth(StatefullDuck duck) {
		currentPosition.setY(currentPosition.getY() - 1);
		logPosition();
	}

	public void moveWest(StatefullDuck duck) {
		currentPosition.setX(currentPosition.getX() - 1);
		logPosition();
	}

	public void moveEast(StatefullDuck duck) {
		currentPosition.setX(currentPosition.getX() + 1);
		logPosition();
	}

	private void logPosition() {
		System.out.println("position = [" + currentPosition.getX() + ", " + currentPosition.getY() + "]");
	}
}
