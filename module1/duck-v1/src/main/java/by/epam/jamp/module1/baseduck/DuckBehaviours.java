package by.epam.jamp.module1.baseduck;

import by.epam.jamp.module1.baseduck.behaviours.fly.FlyBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.quack.QuackBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.recharge.RechargeBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.swim.SwimBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.walk.WalkBehaviour;

public interface DuckBehaviours {

	FlyBehaviour getFlyBehaviour();

	QuackBehaviour getQuackBehaviour();

	SwimBehaviour getSwimBehaviour();

	WalkBehaviour getWalkBehaviour();

	RechargeBehaviour getRechargeBehaviour();

	void setFlyBehaviour(FlyBehaviour flyBehaviour);

	void setQuackBehaviour(QuackBehaviour quackBehaviour);

	void setSwimBehaviour(SwimBehaviour swimBehaviour);

	void setWalkBehaviour(WalkBehaviour walkBehaviour);

	void setRechargeBehaviour(RechargeBehaviour rechargeBehaviour);

}
