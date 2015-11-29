package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public abstract class StatefullDuck extends Duck {

	private StatefullDuckBehaviours stateBehaviors;
	private DuckStates currentState;
	private ChargeStateType chargeStateType;
	private EnvironmentStateType environmentStateType;

	public StatefullDuck(StatefullDuckBehaviours stateBehaviors) {
		super(stateBehaviors.getStatesBehaviours().get(stateBehaviors.getOptions().getInitialStates()));
		currentState = stateBehaviors.getOptions().getInitialStates();
		this.stateBehaviors = stateBehaviors;

		chargeStateType = new ChargeStateType(this);
		environmentStateType = new EnvironmentStateType(this);
	}

	@Override
	public void fly() {
		environmentStateType.toAir();
		super.fly();
	}

	@Override
	public void walk() {
//		currentState.toGround();
		chargeStateType.decreaseChargeLevel();
		super.walk();
	}

	@Override
	public void swim() {
		environmentStateType.toWater();
		super.swim();
	}

	@Override
	public void quack() {
		super.quack();
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

}
