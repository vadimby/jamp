package by.epam.jamp.module1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import by.epam.jamp.module1.baseduck.Duck;
import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourBirdsStyle;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourNoCharge;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourWaiveWings;
import by.epam.jamp.module1.baseduck.behaviours.quack.impl.QuackBehaviourDefault;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourChangeBattery;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourDrink;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEat;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEatInAir;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourDuck;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourKeepOnWater;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourCharged;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourUncharged;
import by.epam.jamp.module1.baseduck.state.DuckStates;
import by.epam.jamp.module1.baseduck.state.StateOptions;
import by.epam.jamp.module1.baseduck.state.StatefullDuckBehaviours;
import by.epam.jamp.module1.baseduck.state.charge.ChargeState;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateOptions;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentState;
import by.epam.jamp.module1.simpleduck.SimpleDuck;
import by.epam.jamp.module1.simpleduck.SimpleDuckBehaviours;
import by.epam.jamp.module1.simpleduck.SimpleDuckStatesBehaviours;
import by.epam.jamp.module1.toyduck.ToyDuck;
import by.epam.jamp.module1.toyduck.ToyDuckStatesBehaviours;

public class SimpleDuckTest {

	@Test
	public void testSimpleDuck() {

		List<Duck> ducks = new ArrayList<Duck>();

		DuckBehaviours simpleDuckBehaviours_full_ground = new SimpleDuckBehaviours();
		simpleDuckBehaviours_full_ground.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		simpleDuckBehaviours_full_ground.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_full_ground.setRechargeBehaviour(new RechargeBehaviourEat());
		simpleDuckBehaviours_full_ground.setWalkBehaviour(new WalkBehaviourCharged());
		simpleDuckBehaviours_full_ground.setSwimBehaviour(new SwimBehaviourDuck());
		
		DuckBehaviours simpleDuckBehaviours_empty_ground = new SimpleDuckBehaviours();
		simpleDuckBehaviours_empty_ground.setFlyBehaviour(new FlyBehaviourNoCharge());
		simpleDuckBehaviours_empty_ground.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_empty_ground.setRechargeBehaviour(new RechargeBehaviourEat());
		simpleDuckBehaviours_empty_ground.setWalkBehaviour(new WalkBehaviourUncharged());
		simpleDuckBehaviours_empty_ground.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours simpleDuckBehaviours_full_water = new SimpleDuckBehaviours();
		simpleDuckBehaviours_full_water.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		simpleDuckBehaviours_full_water.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_full_water.setRechargeBehaviour(new RechargeBehaviourDrink());
		simpleDuckBehaviours_full_water.setWalkBehaviour(new WalkBehaviourCharged());
		simpleDuckBehaviours_full_water.setSwimBehaviour(new SwimBehaviourDuck());
		
		DuckBehaviours simpleDuckBehaviours_empty_water = new SimpleDuckBehaviours();
		simpleDuckBehaviours_empty_water.setFlyBehaviour(new FlyBehaviourNoCharge());
		simpleDuckBehaviours_empty_water.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_empty_water.setRechargeBehaviour(new RechargeBehaviourDrink());
		simpleDuckBehaviours_empty_water.setWalkBehaviour(new WalkBehaviourUncharged());
		simpleDuckBehaviours_empty_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours simpleDuckBehaviours_full_air = new SimpleDuckBehaviours();
		simpleDuckBehaviours_full_air.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		simpleDuckBehaviours_full_air.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_full_air.setRechargeBehaviour(new RechargeBehaviourEatInAir());
		simpleDuckBehaviours_full_air.setWalkBehaviour(new WalkBehaviourCharged());
		simpleDuckBehaviours_full_air.setSwimBehaviour(new SwimBehaviourDuck());
		
		DuckBehaviours simpleDuckBehaviours_empty_air = new SimpleDuckBehaviours();
		simpleDuckBehaviours_empty_air.setFlyBehaviour(new FlyBehaviourNoCharge());
		simpleDuckBehaviours_empty_air.setQuackBehaviour(new QuackBehaviourDefault());
		simpleDuckBehaviours_empty_air.setRechargeBehaviour(new RechargeBehaviourEatInAir());
		simpleDuckBehaviours_empty_air.setWalkBehaviour(new WalkBehaviourUncharged());
		simpleDuckBehaviours_empty_air.setSwimBehaviour(new SwimBehaviourDuck());

		Map <DuckStates, DuckBehaviours> map1 = new HashMap<DuckStates, DuckBehaviours>();
		map1.put(new DuckStates(ChargeState.FULL, EnvironmentState.GROUND), simpleDuckBehaviours_full_ground);
		map1.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.GROUND), simpleDuckBehaviours_empty_ground);
		map1.put(new DuckStates(ChargeState.FULL, EnvironmentState.WATER), simpleDuckBehaviours_full_water);
		map1.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.WATER), simpleDuckBehaviours_empty_water);
		map1.put(new DuckStates(ChargeState.FULL, EnvironmentState.AIR), simpleDuckBehaviours_full_air);
		map1.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.AIR), simpleDuckBehaviours_empty_air);
		StateOptions options = new StateOptions() {
			
			public DuckStates getInitialStates() {
				return new DuckStates(ChargeState.FULL, EnvironmentState.GROUND);
			}
			
			public ChargeStateOptions getChargeStateOptions() {
				return new ChargeStateOptions() {
					
					public int getMaxChargeLevel() {
						return 10;
					}
				};
			}
		};
		StatefullDuckBehaviours statefullSimpleDuckBehaviors = new SimpleDuckStatesBehaviours(map1, options);

		ducks.add(new SimpleDuck(statefullSimpleDuckBehaviors));

		DuckBehaviours toyDuckBehaviours_full_ground = new SimpleDuckBehaviours();
		toyDuckBehaviours_full_ground.setFlyBehaviour(new FlyBehaviourWaiveWings());
		toyDuckBehaviours_full_ground.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_full_ground.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_full_ground.setWalkBehaviour(new WalkBehaviourCharged());
		toyDuckBehaviours_full_ground.setSwimBehaviour(new SwimBehaviourKeepOnWater());
		
		DuckBehaviours toyDuckBehaviours_empty_ground = new SimpleDuckBehaviours();
		toyDuckBehaviours_empty_ground.setFlyBehaviour(new FlyBehaviourNoCharge());
		toyDuckBehaviours_empty_ground.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_empty_ground.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_empty_ground.setWalkBehaviour(new WalkBehaviourUncharged());
		toyDuckBehaviours_empty_ground.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours toyDuckBehaviours_full_water = new SimpleDuckBehaviours();
		toyDuckBehaviours_full_water.setFlyBehaviour(new FlyBehaviourWaiveWings());
		toyDuckBehaviours_full_water.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_full_water.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_full_water.setWalkBehaviour(new WalkBehaviourCharged());
		toyDuckBehaviours_full_water.setSwimBehaviour(new SwimBehaviourDuck());
		
		DuckBehaviours toyDuckBehaviours_empty_water = new SimpleDuckBehaviours();
		toyDuckBehaviours_empty_water.setFlyBehaviour(new FlyBehaviourNoCharge());
		toyDuckBehaviours_empty_water.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_empty_water.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_empty_water.setWalkBehaviour(new WalkBehaviourUncharged());
		toyDuckBehaviours_empty_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours toyDuckBehaviours_full_air = new SimpleDuckBehaviours();
		toyDuckBehaviours_full_air.setFlyBehaviour(new FlyBehaviourWaiveWings());
		toyDuckBehaviours_full_air.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_full_air.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_full_air.setWalkBehaviour(new WalkBehaviourCharged());
		toyDuckBehaviours_full_air.setSwimBehaviour(new SwimBehaviourDuck());
		
		DuckBehaviours toyDuckBehaviours_empty_air = new SimpleDuckBehaviours();
		toyDuckBehaviours_empty_air.setFlyBehaviour(new FlyBehaviourNoCharge());
		toyDuckBehaviours_empty_air.setQuackBehaviour(new QuackBehaviourDefault());
		toyDuckBehaviours_empty_air.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		toyDuckBehaviours_empty_air.setWalkBehaviour(new WalkBehaviourUncharged());
		toyDuckBehaviours_empty_air.setSwimBehaviour(new SwimBehaviourDuck());

		Map <DuckStates, DuckBehaviours> map2 = new HashMap<DuckStates, DuckBehaviours>();
		map2.put(new DuckStates(ChargeState.FULL, EnvironmentState.GROUND), toyDuckBehaviours_full_ground);
		map2.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.GROUND), toyDuckBehaviours_empty_ground);
		map2.put(new DuckStates(ChargeState.FULL, EnvironmentState.WATER), toyDuckBehaviours_full_water);
		map2.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.WATER), toyDuckBehaviours_empty_water);
		map2.put(new DuckStates(ChargeState.FULL, EnvironmentState.AIR), toyDuckBehaviours_full_air);
		map2.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.AIR), toyDuckBehaviours_empty_air);
		
		StatefullDuckBehaviours statefullToyDuckBehaviours = new ToyDuckStatesBehaviours(map2, options);

		ducks.add(new ToyDuck(statefullToyDuckBehaviours));

		for (Duck duck : ducks) {
			for (int i = 0; i < 11; i++) {
				duck.walk();
			}

			duck.recharge();
			duck.walk();

			duck.swim();
			duck.recharge();

			duck.fly();

			duck.quack();

			duck.recharge();
			duck.walk();
			duck.walk();
			duck.walk();
			duck.walk();

			duck.swim();

			duck.fly();

			duck.quack();

			duck.recharge();

			System.out.println("=============================");
		}

	}
	

}
