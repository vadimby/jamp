package by.epam.jamp.module1.baseduck.state.charge.impl;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeState;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;

public class DefaultChargeStateType implements ChargeStateType {

	private static final int MIN_CHARGE_LEVEL = 0;
	private int maxChargeLevel;
	private int currentChargeLevel;

	public DefaultChargeStateType(int maxChargeLevel) {
		this.maxChargeLevel = maxChargeLevel;
		this.currentChargeLevel = maxChargeLevel;
	}

	private final void setState(ChargeState newState, StatefullDuck duck) {
		duck.getCurrentState().setChargeState(newState);
		duck.getCurrentState().getChargeState().stateEnter(duck);
	}

	public void decreaseChargeLevel(StatefullDuck duck) {
		if (currentChargeLevel > MIN_CHARGE_LEVEL) {
			this.currentChargeLevel--;
		} else {
			setState(ChargeState.EMPTY, duck);
		}
	}

	public void recharge(StatefullDuck duck) {
		this.currentChargeLevel = this.maxChargeLevel;
		setState(ChargeState.FULL, duck);
	}
}
