package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviours;

// базавая имплиментация стейтфул утки
public class SimpleDuck extends StatefullDuck {

	public SimpleDuck(StatefullDuckBehaviours duckBehaviours) {
		super(duckBehaviours);
	}

}
