package by.epam.jamp.module1.toyduck;

import java.util.Map;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.DuckStates;
import by.epam.jamp.module1.baseduck.state.StateOptions;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviours;

public class ToyDuckStatesBehaviours extends StatefullDuckBehaviours {

	public ToyDuckStatesBehaviours(Map<DuckStates, DuckBehaviours> statesBehaviours, StateOptions options,
			DuckBehaviours duckBehaviours) {
		super(statesBehaviours, options, duckBehaviours);
	}

}
