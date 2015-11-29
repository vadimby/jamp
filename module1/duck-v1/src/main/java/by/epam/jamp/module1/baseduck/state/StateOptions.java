package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.state.charge.ChargeStateOptions;

public interface StateOptions {

	ChargeStateOptions getChargeStateOptions();

	DuckStates getInitialStates();

}
