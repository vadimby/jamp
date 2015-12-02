package by.epam.jamp.module1.simpleduck;

import java.util.Map;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.DuckStates;
import by.epam.jamp.module1.baseduck.state.StateOptions;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviours;

public class SimpleDuckStatesBehaviours extends StatefullDuckBehaviours {

	public SimpleDuckStatesBehaviours(Map<DuckStates, DuckBehaviours> statesBehaviours, StateOptions options) {
		super(statesBehaviours, options, statesBehaviours.get(options.getInitialStates()));
	}

}
