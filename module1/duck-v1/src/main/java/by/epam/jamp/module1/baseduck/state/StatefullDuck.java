package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public abstract class StatefullDuck extends Duck {

	private final ChargeStateType chargeStateType;
	private final EnvironmentStateType environmentStateType;

	public StatefullDuck(StatefullDuckBehaviors duckBehaviors) {
		super(duckBehaviors.getCurentBehaviours());
		this.chargeStateType = new ChargeStateType(this, duckBehaviors.getFullBehaviours(),
				duckBehaviors.getEmptyBehaviours());
		this.environmentStateType = new EnvironmentStateType(this, duckBehaviors.getGroundBehaviours(),
				duckBehaviors.getWaterBehaviours(), duckBehaviors.getAirBehaviours());
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

}
