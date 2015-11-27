package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.Duck;

public class ChargeStateType {

	private ChargeState state;
	private final Duck duck;

	public ChargeStateType(Duck duck) {
		this.duck = duck;
		this.state = ChargeState.full;
	}

	public void setState(ChargeState newState) {
		state.stateExit(this);
		this.state = newState;
		state.stateEnter(this);
	}

	public Duck getDuck() {
		return duck;
	}
	
	

}
