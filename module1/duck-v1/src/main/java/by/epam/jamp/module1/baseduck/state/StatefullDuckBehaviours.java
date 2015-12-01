package by.epam.jamp.module1.baseduck.state;

import java.util.Map;

import by.epam.jamp.module1.baseduck.DuckBehaviours;

public abstract class StatefullDuckBehaviours {

	private final Map<DuckStates, DuckBehaviours> statesBehaviours;
	private final DuckBehaviours deafultDuckBehaviours;
	private final StateOptions options;

	public StatefullDuckBehaviours(Map<DuckStates, DuckBehaviours> statesBehaviours, StateOptions options,
			DuckBehaviours deafultDuckBehaviours) {
		this.statesBehaviours = statesBehaviours;
		this.options = options;
		this.deafultDuckBehaviours = deafultDuckBehaviours;
	}

	public Map<DuckStates, DuckBehaviours> getStatesBehaviours() {
		return statesBehaviours;
	}

	public StateOptions getOptions() {
		return options;
	}

	public DuckBehaviours getDeafultDuckBehaviours() {
		return deafultDuckBehaviours;
	}

}
