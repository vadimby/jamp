package by.epam.jamp.module1.baseduck.state;

import by.epam.jamp.module1.baseduck.DuckBehaviours;

public abstract class StatefullDuckBehaviors {

	private final DuckBehaviours curentBehaviours;
	private final DuckBehaviours fullBehaviours;
	private final DuckBehaviours emptyBehaviours;
	private final DuckBehaviours groundBehaviours;
	private final DuckBehaviours waterBehaviours;
	private final DuckBehaviours airBehaviours;

	public StatefullDuckBehaviors(DuckBehaviours curentBehaviours, DuckBehaviours fullBehaviours,
			DuckBehaviours emptyBehaviours, DuckBehaviours groundBehaviours, DuckBehaviours waterBehaviours,
			DuckBehaviours airBehaviors) {
		this.curentBehaviours = curentBehaviours;
		this.fullBehaviours = fullBehaviours;
		this.emptyBehaviours = emptyBehaviours;
		this.groundBehaviours = groundBehaviours;
		this.waterBehaviours = waterBehaviours;
		this.airBehaviours = airBehaviors;
	}

	public DuckBehaviours getCurentBehaviours() {
		return curentBehaviours;
	}

	public DuckBehaviours getFullBehaviours() {
		return fullBehaviours;
	}

	public DuckBehaviours getEmptyBehaviours() {
		return emptyBehaviours;
	}

	public DuckBehaviours getGroundBehaviours() {
		return groundBehaviours;
	}

	public DuckBehaviours getWaterBehaviours() {
		return waterBehaviours;
	}

	public DuckBehaviours getAirBehaviours() {
		return airBehaviours;
	}

}
