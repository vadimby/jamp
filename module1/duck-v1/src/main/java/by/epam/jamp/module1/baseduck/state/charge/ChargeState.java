package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public abstract class ChargeState {

	public static final ChargeState FULL = new ChargeStateFull();
	public static final ChargeState EMPTY = new ChargeStateEmpty();

	public abstract void stateEnter(StatefullDuck duck);

}
