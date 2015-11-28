package by.epam.jamp.module1.baseduck.state.charge;

abstract class ChargeState {
	static ChargeState initialState;
	static final ChargeState FULL = new ChargeStateFull();
	static final ChargeState EMPTY = new ChargeStateEmpty();

	protected ChargeState() {
		if (initialState == null) {
			initialState = this;
		}
	}

	abstract void stateExit(ChargeStateType owner);

	abstract void stateEnter(ChargeStateType owner);
}
