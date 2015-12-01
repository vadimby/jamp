package by.epam.jamp.module1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import by.epam.jamp.module1.baseduck.DuckBehaviours;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourBirdsStyle;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourNoCharge;
import by.epam.jamp.module1.baseduck.behaviours.fly.impl.FlyBehaviourWaiveWings;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourFlyAsBirds;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourLowBattery;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourNoCharge;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourSwimAsBirds;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourSwimAsToy;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourWalk;
import by.epam.jamp.module1.baseduck.behaviours.move.impl.MoveBehaviourWalkWaiveWings;
import by.epam.jamp.module1.baseduck.behaviours.quack.impl.QuackBehaviourDefault;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourChangeBattery;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourDrink;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEat;
import by.epam.jamp.module1.baseduck.behaviours.recharge.impl.RechargeBehaviourEatInAir;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourDuck;
import by.epam.jamp.module1.baseduck.behaviours.swim.impl.SwimBehaviourKeepOnWater;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourCharged;
import by.epam.jamp.module1.baseduck.behaviours.walk.impl.WalkBehaviourUncharged;
import by.epam.jamp.module1.baseduck.comands.Command;
import by.epam.jamp.module1.baseduck.comands.move.MoveEastCommand;
import by.epam.jamp.module1.baseduck.comands.move.MoveNorthCommand;
import by.epam.jamp.module1.baseduck.comands.move.MoveSouthCommand;
import by.epam.jamp.module1.baseduck.comands.state.LandCommand;
import by.epam.jamp.module1.baseduck.comands.state.RechargeCommand;
import by.epam.jamp.module1.baseduck.comands.state.TakeOffCommand;
import by.epam.jamp.module1.baseduck.state.DuckStateType;
import by.epam.jamp.module1.baseduck.state.DuckStates;
import by.epam.jamp.module1.baseduck.state.StateOptions;
import by.epam.jamp.module1.baseduck.state.StatefullDuck;
import by.epam.jamp.module1.baseduck.state.charge.ChargeState;
import by.epam.jamp.module1.baseduck.state.charge.ChargeStateType;
import by.epam.jamp.module1.baseduck.state.charge.impl.DefaultChargeStateType;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentState;
import by.epam.jamp.module1.baseduck.state.environment.EnvironmentStateType;
import by.epam.jamp.module1.baseduck.state.environment.impl.DefaultEnvironmentStateType;
import by.epam.jamp.module1.baseduck.state.impl.DuckStateTypeDefault;
import by.epam.jamp.module1.baseduck.state.position.PositionStateType;
import by.epam.jamp.module1.baseduck.state.position.impl.DefaultPositionStateType;
import by.epam.jamp.module1.context.Position2D;
import by.epam.jamp.module1.simpleduck.SimpleDuck;
import by.epam.jamp.module1.simpleduck.SimpleDuckBehaviours;
import by.epam.jamp.module1.simpleduck.SimpleDuckStatesBehaviours;

public class SimpleDuckTest {

	@Test
	public void testSimpleDuck() {

		List<StatefullDuck> ducks = new ArrayList<StatefullDuck>();

		int maxChargeLevel = 10;
		int initialX = 0;
		int initialY = 10;
		int quackTimes = 5;

		StateOptions options = getOptions(maxChargeLevel, initialX, initialY);
		ducks.add(new SimpleDuck(new SimpleDuckStatesBehaviours(getSimpleDuckConfig(), options)));
		ducks.add(new SimpleDuck(new SimpleDuckStatesBehaviours(getToyDuckConfig(quackTimes), options)));

		for (StatefullDuck duck : ducks) {
			executeFlow(duck);

			System.out.println("=============================");
		}

	}

	private void executeFlow(StatefullDuck duck) {
		for (Command command : getCommandList(duck)) {
			command.execute();
		}
	}

	private List<Command> getCommandList(StatefullDuck duck) {
		List<Command> commands = new ArrayList<Command>();
		for (int i = 0; i < 2; i++) {
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveSouthCommand(duck));
			commands.add(new TakeOffCommand(duck));
			commands.add(new MoveSouthCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new LandCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveNorthCommand(duck));
			commands.add(new MoveNorthCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveSouthCommand(duck));
			commands.add(new RechargeCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new MoveNorthCommand(duck));
			commands.add(new MoveNorthCommand(duck));
			commands.add(new MoveEastCommand(duck));
			commands.add(new TakeOffCommand(duck));
		}

		return commands;
	}

	private Map<DuckStates, DuckBehaviours> getToyDuckConfig(int quackTimes) {
		DuckBehaviours behaviours_full_ground = new SimpleDuckBehaviours();
		behaviours_full_ground.setFlyBehaviour(new FlyBehaviourWaiveWings());
		behaviours_full_ground.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_ground.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_full_ground.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_ground.setSwimBehaviour(new SwimBehaviourKeepOnWater());

		DuckBehaviours behaviours_empty_ground = new SimpleDuckBehaviours();
		behaviours_empty_ground.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_ground.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_ground.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_empty_ground.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_ground.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_full_water = new SimpleDuckBehaviours();
		behaviours_full_water.setFlyBehaviour(new FlyBehaviourWaiveWings());
		behaviours_full_water.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_water.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_full_water.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_empty_water = new SimpleDuckBehaviours();
		behaviours_empty_water.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_water.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_water.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_empty_water.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_full_air = new SimpleDuckBehaviours();
		behaviours_full_air.setFlyBehaviour(new FlyBehaviourWaiveWings());
		behaviours_full_air.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_air.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_full_air.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_air.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_empty_air = new SimpleDuckBehaviours();
		behaviours_empty_air.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_air.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_air.setRechargeBehaviour(new RechargeBehaviourChangeBattery());
		behaviours_empty_air.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_air.setSwimBehaviour(new SwimBehaviourDuck());

		behaviours_full_ground.setMoveBehaviour(new MoveBehaviourWalk());
		behaviours_empty_ground.setMoveBehaviour(new MoveBehaviourLowBattery(new QuackBehaviourDefault(), quackTimes));
		behaviours_full_water.setMoveBehaviour(new MoveBehaviourSwimAsToy());
		behaviours_empty_water.setMoveBehaviour(new MoveBehaviourNoCharge());
		behaviours_full_air.setMoveBehaviour(new MoveBehaviourWalkWaiveWings());
		behaviours_empty_air.setMoveBehaviour(new MoveBehaviourNoCharge());

		Map<DuckStates, DuckBehaviours> map = new HashMap<DuckStates, DuckBehaviours>();
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.GROUND), behaviours_full_ground);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.GROUND), behaviours_empty_ground);
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.WATER), behaviours_full_water);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.WATER), behaviours_empty_water);
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.AIR), behaviours_full_air);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.AIR), behaviours_empty_air);
		return map;
	}

	private Map<DuckStates, DuckBehaviours> getSimpleDuckConfig() {
		DuckBehaviours behaviours_full_ground = new SimpleDuckBehaviours();
		behaviours_full_ground.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		behaviours_full_ground.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_ground.setRechargeBehaviour(new RechargeBehaviourEat());
		behaviours_full_ground.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_ground.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_empty_ground = new SimpleDuckBehaviours();
		behaviours_empty_ground.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_ground.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_ground.setRechargeBehaviour(new RechargeBehaviourEat());
		behaviours_empty_ground.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_ground.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_full_water = new SimpleDuckBehaviours();
		behaviours_full_water.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		behaviours_full_water.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_water.setRechargeBehaviour(new RechargeBehaviourDrink());
		behaviours_full_water.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_empty_water = new SimpleDuckBehaviours();
		behaviours_empty_water.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_water.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_water.setRechargeBehaviour(new RechargeBehaviourDrink());
		behaviours_empty_water.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_water.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_full_air = new SimpleDuckBehaviours();
		behaviours_full_air.setFlyBehaviour(new FlyBehaviourBirdsStyle());
		behaviours_full_air.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_full_air.setRechargeBehaviour(new RechargeBehaviourEatInAir());
		behaviours_full_air.setWalkBehaviour(new WalkBehaviourCharged());
		behaviours_full_air.setSwimBehaviour(new SwimBehaviourDuck());

		DuckBehaviours behaviours_empty_air = new SimpleDuckBehaviours();
		behaviours_empty_air.setFlyBehaviour(new FlyBehaviourNoCharge());
		behaviours_empty_air.setQuackBehaviour(new QuackBehaviourDefault());
		behaviours_empty_air.setRechargeBehaviour(new RechargeBehaviourEatInAir());
		behaviours_empty_air.setWalkBehaviour(new WalkBehaviourUncharged());
		behaviours_empty_air.setSwimBehaviour(new SwimBehaviourDuck());

		behaviours_full_ground.setMoveBehaviour(new MoveBehaviourWalk());
		behaviours_empty_ground.setMoveBehaviour(new MoveBehaviourNoCharge());
		behaviours_full_water.setMoveBehaviour(new MoveBehaviourSwimAsBirds());
		behaviours_empty_water.setMoveBehaviour(new MoveBehaviourNoCharge());
		behaviours_full_air.setMoveBehaviour(new MoveBehaviourFlyAsBirds());
		behaviours_empty_air.setMoveBehaviour(new MoveBehaviourNoCharge());

		Map<DuckStates, DuckBehaviours> map = new HashMap<DuckStates, DuckBehaviours>();
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.GROUND), behaviours_full_ground);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.GROUND), behaviours_empty_ground);
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.WATER), behaviours_full_water);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.WATER), behaviours_empty_water);
		map.put(new DuckStates(ChargeState.FULL, EnvironmentState.AIR), behaviours_full_air);
		map.put(new DuckStates(ChargeState.EMPTY, EnvironmentState.AIR), behaviours_empty_air);
		return map;
	}

	private StateOptions getOptions(final int maxChargeLevel, final int initialX, final int initialY) {
		return new StateOptions() {

			public DuckStates getInitialStates() {
				return new DuckStates(ChargeState.FULL, EnvironmentState.GROUND);
			}

			public DuckStateType getStateType() {
				ChargeStateType chargeStateType = new DefaultChargeStateType(maxChargeLevel);
				EnvironmentStateType environmentStateType = new DefaultEnvironmentStateType();
				PositionStateType positionStateType = new DefaultPositionStateType(new Position2D(initialX, initialY));
				return new DuckStateTypeDefault(chargeStateType, environmentStateType, positionStateType);
			}
		};
	}

}
