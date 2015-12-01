package by.epam.jamp.module1.baseduck;

import by.epam.jamp.module1.baseduck.behaviours.fly.FlyBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.move.MoveBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.quack.QuackBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.recharge.RechargeBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.swim.SwimBehaviour;
import by.epam.jamp.module1.baseduck.behaviours.walk.WalkBehaviour;

// базовый набор поведений необходимый для корректной работы. 
// все модули подключаются как инетерфесы и не зависят от рализаций
public interface DuckBehaviours {

	// утка может летать
	FlyBehaviour getFlyBehaviour();

	// утка может квакать
	QuackBehaviour getQuackBehaviour();

	// ... плавать
	SwimBehaviour getSwimBehaviour();

	// ... ходить
	WalkBehaviour getWalkBehaviour();

	// ... восполнять запас энергии = есть, пить, менять батарейки
	RechargeBehaviour getRechargeBehaviour();

	// "оказалось", утка долна подчинять командам движения
	MoveBehaviour getMoveBehaviour();

	void setFlyBehaviour(FlyBehaviour flyBehaviour);

	void setQuackBehaviour(QuackBehaviour quackBehaviour);

	void setSwimBehaviour(SwimBehaviour swimBehaviour);

	void setWalkBehaviour(WalkBehaviour walkBehaviour);

	void setRechargeBehaviour(RechargeBehaviour rechargeBehaviour);

	void setMoveBehaviour(MoveBehaviour moveBehaviour);

}
