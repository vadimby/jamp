package by.epam.jamp.module1.baseduck.state.position;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.context.Position2D;

public class PositionStateType {

	private final Position2D startPosition;
	private final Position2D currentPosition;

	public PositionStateType(StatefullDuck duck) {
		this.startPosition = (Position2D) duck.getStateBehaviours().getOptions().getPositionStateOptions().getStartPosition();
		this.currentPosition = startPosition;
	}
	
	
	public void moveNorth() {
		currentPosition.setY(currentPosition.getY() + 1);
		logPosition();
	}

	
	public void moveSouth() {
		currentPosition.setY(currentPosition.getY() - 1);
		logPosition();
	}
	
	public void moveWest() {
		currentPosition.setX(currentPosition.getX() - 1);
		logPosition();
	}

	public void moveEast() {
		currentPosition.setX(currentPosition.getX() + 1);
		logPosition();
	}

	private void logPosition() {
		System.out.println("position = [" + currentPosition.getX() + ", " + currentPosition.getY() + "]");
	}
}
