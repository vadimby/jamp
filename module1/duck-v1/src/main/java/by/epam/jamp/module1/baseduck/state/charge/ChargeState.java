package by.epam.jamp.module1.baseduck.state.charge;

abstract class ChargeState {
	static ChargeState initialState;
	static final ChargeState full = new ChargeStateFull();
	static final ChargeState empty = new ChargeStateEmpty();

	protected ChargeState() {
		if (initialState == null)
			initialState = this;
	}

	abstract void stateExit(ChargeStateType owner);

	abstract void stateEnter(ChargeStateType owner);
}
