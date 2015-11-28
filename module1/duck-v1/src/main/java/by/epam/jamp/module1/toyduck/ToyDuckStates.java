package by.epam.jamp.module1.toyduck;

import by.epam.jamp.module1.baseduck.state.DuckState;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public class ToyDuckStates implements DuckState {

	private ChargeStateType chargeStateType;
	private EnvironmentStateType environmentStateType;

	public ChargeStateType getChargeStateType() {
		return chargeStateType;
	}

	public void setChargeStateType(ChargeStateType chargeStateType) {
		this.chargeStateType = chargeStateType;
	}

	public EnvironmentStateType getEnvironmentStateType() {
		return environmentStateType;
	}

	public void setEnvironmentStateType(EnvironmentStateType environmentStateType) {
		this.environmentStateType = environmentStateType;
	}

}
