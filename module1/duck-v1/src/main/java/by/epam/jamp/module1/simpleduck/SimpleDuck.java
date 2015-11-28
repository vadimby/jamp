package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.DuckState;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class SimpleDuck extends StatefullDuck {

	public SimpleDuck(DuckBehaviours duckBehaviours, DuckState duckStates) {
		super(duckBehaviours, duckStates);
	}

}
