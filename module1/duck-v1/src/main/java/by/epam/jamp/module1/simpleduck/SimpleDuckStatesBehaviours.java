package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviors;

public class SimpleDuckStatesBehaviours extends StatefullDuckBehaviors {

	public SimpleDuckStatesBehaviours(DuckBehaviours curentBehaviours, DuckBehaviours fullBehaviours,
			DuckBehaviours emptyBehaviours, DuckBehaviours groundBehaviours, DuckBehaviours waterBehaviours,
			DuckBehaviours airBehaviors) {
		super(curentBehaviours, fullBehaviours, emptyBehaviours, groundBehaviours, waterBehaviours, airBehaviors);
	}

}
