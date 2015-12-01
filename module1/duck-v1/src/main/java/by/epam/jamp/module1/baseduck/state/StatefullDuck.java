package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.Duck;

// В зависимоти от состояния стейтфул утка может иметь разный набор поведений.
public abstract class StatefullDuck extends Duck {

	// возможные виды поведений
	private final StatefullDuckBehaviours stateBehaviors;
	// текущее состояние
	private DuckStates currentState;
	// объект отвечающий за изменения состояний утки
	private DuckStateType duckStateType;

	public StatefullDuck(StatefullDuckBehaviours stateBehaviors) {
		super(stateBehaviors.getDeafultDuckBehaviours());
		this.currentState = stateBehaviors.getOptions().getInitialStates();
		this.duckStateType = stateBehaviors.getOptions().getStateType();
		this.stateBehaviors = stateBehaviors;
	}

	@Override
	public void fly() {
		duckStateType.toAir(this);
	}

	@Override
	public void walk() {
		duckStateType.toGround(this);
	}

	@Override
	public void swim() {
		duckStateType.toWater(this);
	}

	@Override
	public void recharge() {
		super.recharge();
		duckStateType.recharge(this);
	}

	public void moveWest() {
		duckStateType.moveWest(this);
		super.move();
	}

	public void moveEast() {
		duckStateType.moveEast(this);
		super.move();
	}

	public void moveNorth() {
		duckStateType.moveNorth(this);
		super.move();
	}

	public void moveSouth() {
		duckStateType.moveSouth(this);
		super.move();
	}

	public DuckStates getCurrentState() {
		return currentState;
	}

	public StatefullDuckBehaviours getStateBehaviours() {
		return stateBehaviors;
	}

}
