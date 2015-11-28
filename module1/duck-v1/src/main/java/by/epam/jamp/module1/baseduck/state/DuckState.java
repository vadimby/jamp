package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;

public interface DuckState {

	ChargeStateType getChargeStateType();

	EnvironmentStateType getEnvironmentStateType();

	void setChargeStateType(ChargeStateType chargeStateType);

	void setEnvironmentStateType(EnvironmentStateType environmentStateType);
}
