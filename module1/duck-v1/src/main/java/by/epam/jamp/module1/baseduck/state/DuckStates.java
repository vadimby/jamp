package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.state.charge.ChargeState;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentState;

// опрделяет текущий стейт утрки который может состоять из нескольких подтипов
// является ключем мапы поэтому переопределены hashCode и equals
public class DuckStates {

	private ChargeState chargeState;
	private EnvironmentState environmentState;

	public DuckStates(ChargeState chargeState, EnvironmentState environmentState) {
		this.chargeState = chargeState;
		this.environmentState = environmentState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chargeState == null) ? 0 : chargeState.hashCode());
		result = prime * result + ((environmentState == null) ? 0 : environmentState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DuckStates other = (DuckStates) obj;
		if (chargeState == null) {
			if (other.chargeState != null)
				return false;
		} else if (!chargeState.equals(other.chargeState))
			return false;
		if (environmentState == null) {
			if (other.environmentState != null)
				return false;
		} else if (!environmentState.equals(other.environmentState))
			return false;
		return true;
	}

	public ChargeState getChargeState() {
		return chargeState;
	}

	public void setChargeState(ChargeState chargeState) {
		this.chargeState = chargeState;
	}

	public EnvironmentState getEnvironmentState() {
		return environmentState;
	}

	public void setEnvironmentState(EnvironmentState environmentState) {
		this.environmentState = environmentState;
	}

}
