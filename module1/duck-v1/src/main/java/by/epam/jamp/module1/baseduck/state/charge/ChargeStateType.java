package by.epam.jamp.module1.baseduck.state.charge;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public interface ChargeStateType {

	void decreaseChargeLevel(StatefullDuck duck);

	void recharge(StatefullDuck duck);
}
