package by.epam.jamp.module1.baseduck.state.impl;

import by.epam.jamp.module1.baseduck.state.DuckStateType;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;
import by.epam.jamp.module1.baseduck.state.position.PositionStateType;

// дефолтная реализация адаптер объектов изменяющий состояние
public class DuckStateTypeDefault implements DuckStateType {

	// возможные состояния
	private final ChargeStateType chargeStateType;
	private final EnvironmentStateType environmentStateType;
	private final PositionStateType positionStateType;

	public DuckStateTypeDefault(ChargeStateType chargeStateType, EnvironmentStateType environmentStateType,
			PositionStateType positionStateType) {
		this.chargeStateType = chargeStateType;
		this.environmentStateType = environmentStateType;
		this.positionStateType = positionStateType;
	}

	public void toAir(StatefullDuck duck) {
		environmentStateType.toAir(duck);
	}

	public void toGround(StatefullDuck duck) {
		environmentStateType.toGround(duck);
	}

	public void toWater(StatefullDuck duck) {
		environmentStateType.toWater(duck);
	}

	public void recharge(StatefullDuck duck) {
		chargeStateType.recharge(duck);
	}

	public void moveWest(StatefullDuck duck) {
		chargeStateType.decreaseChargeLevel(duck);
		positionStateType.moveWest(duck);
	}

	public void moveEast(StatefullDuck duck) {
		chargeStateType.decreaseChargeLevel(duck);
		positionStateType.moveEast(duck);
	}

	public void moveNorth(StatefullDuck duck) {
		chargeStateType.decreaseChargeLevel(duck);
		positionStateType.moveNorth(duck);
	}

	public void moveSouth(StatefullDuck duck) {
		chargeStateType.decreaseChargeLevel(duck);
		positionStateType.moveSouth(duck);
	}

}
