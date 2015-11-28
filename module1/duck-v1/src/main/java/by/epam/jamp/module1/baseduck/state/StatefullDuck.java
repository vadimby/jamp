package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public abstract class StatefullDuck extends Duck {

	private DuckState currentState;
	private final ChargeStateType chargeStateType;
	private final EnvironmentStateType environmentStateType;

	public StatefullDuck(DuckBehaviours duckBehaviours, DuckState currentState) {
		super(duckBehaviours);
		this.chargeStateType = new ChargeStateType(this);
		this.environmentStateType = new EnvironmentStateType(this);
	}

	public ChargeStateType getChargeStateType() {
		return chargeStateType;
	}

	public EnvironmentStateType getEnvironmentStateType() {
		return environmentStateType;
	}

	@Override
	public void fly() {
		environmentStateType.toAir();
		super.fly();
	}
	
	@Override
	public void walk() {
		environmentStateType.toEarth();
		super.walk();
	}
	
	
	@Override
	public void swim() {
		environmentStateType.toWater();
		super.swim();
	}

	public DuckState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(DuckState currentState) {
		this.currentState = currentState;
	}

}
