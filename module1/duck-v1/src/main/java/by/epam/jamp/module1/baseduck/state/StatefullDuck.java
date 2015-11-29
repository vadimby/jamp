package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;
import by.epam.jamp.module1.baseduck.state.position.PositionStateType;

public abstract class StatefullDuck extends Duck {

	private StatefullDuckBehaviours stateBehaviors;
	private DuckStates currentState;
	private ChargeStateType chargeStateType;
	private EnvironmentStateType environmentStateType;
	private PositionStateType positionStateType;

	public StatefullDuck(StatefullDuckBehaviours stateBehaviors) {
		super(stateBehaviors.getStatesBehaviours().get(stateBehaviors.getOptions().getInitialStates()));
		currentState = stateBehaviors.getOptions().getInitialStates();
		this.stateBehaviors = stateBehaviors;

		chargeStateType = new ChargeStateType(this);
		environmentStateType = new EnvironmentStateType(this);
		positionStateType = new PositionStateType(this);
	}

	@Override
	public void fly() {
		environmentStateType.toAir();
	}

	@Override
	public void walk() {
		environmentStateType.toGround();
	}

	@Override
	public void swim() {
		environmentStateType.toWater();
	}

	@Override
	public void recharge() {
		super.recharge();
		chargeStateType.recharge();
	}

	public DuckStates getCurrentState() {
		return currentState;
	}

	public StatefullDuckBehaviours getStateBehaviours() {
		return stateBehaviors;
	}

	public void moveWest() {
		chargeStateType.decreaseChargeLevel();
		positionStateType.moveWest();
		super.move();
	}

	public void moveEast() {
		chargeStateType.decreaseChargeLevel();
		positionStateType.moveEast();
		super.move();
	}

	public void moveNorth() {
		chargeStateType.decreaseChargeLevel();
		positionStateType.moveNorth();
		super.move();
	}

	public void moveSouth() {
		chargeStateType.decreaseChargeLevel();
		positionStateType.moveSouth();
		super.move();
	}

}
