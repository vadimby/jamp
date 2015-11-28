package by.epam.jamp.module1.toyduck;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.DuckState;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;

public class ToyDuck extends StatefullDuck {
	public ToyDuck(DuckBehaviours duckBehaviours, DuckState duckStates) {
		super(duckBehaviours, duckStates);
	}

}
