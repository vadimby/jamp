package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.state.charge.ChargeStateOptions;
import by.epam.jamp.module1.baseduck.state.position.PositionStateOptions;

public interface StateOptions {

	ChargeStateOptions getChargeStateOptions();

	DuckStates getInitialStates();

	PositionStateOptions getPositionStateOptions();

}
