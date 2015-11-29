package by.epam.jamp.module1.baseduck.state;

import java.util.Map;

import by.epam.jamp.module1.baseduck.DuckBehaviours;

public class StatefullDuckBehaviours {
	
	private final Map<DuckStates, DuckBehaviours> statesBehaviours;
	private final StateOptions options;
	
	public StatefullDuckBehaviours(Map<DuckStates, DuckBehaviours> statesBehaviours, StateOptions options) {
		this.statesBehaviours = statesBehaviours;
		this.options = options;
	}

	public Map<DuckStates, DuckBehaviours> getStatesBehaviours() {
		return statesBehaviours;
	}

	public StateOptions getOptions() {
		return options;
	}

}
