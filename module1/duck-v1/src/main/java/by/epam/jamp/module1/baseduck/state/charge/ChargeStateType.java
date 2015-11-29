package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class ChargeStateType {

	private int maxChargeLevel;
	private int currentChargeLevel;
	private final StatefullDuck duck;

	public ChargeStateType(StatefullDuck duck) {
		this.duck = duck;

		this.maxChargeLevel = duck.getStateBehaviours().getOptions().getChargeStateOptions().getMaxChargeLevel();
		this.currentChargeLevel = maxChargeLevel;
	}

	private final void setState(ChargeState newState) {
		duck.getCurrentState().setChargeState(newState);
		duck.getCurrentState().getChargeState().stateEnter(duck);
	}

	public void decreaseChargeLevel() {
		if (currentChargeLevel > 0) {
			this.currentChargeLevel--;
		} else {
			setState(ChargeState.EMPTY);
		}
	}

	public void recharge() {
		this.currentChargeLevel = this.maxChargeLevel;
		setState(ChargeState.FULL);
	}
}
