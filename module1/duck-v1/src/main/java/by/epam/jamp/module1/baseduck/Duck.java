package by.epam.jamp.module1.baseduck;

public abstract class Duck {

	// Интерфейс содержащий все возможные типы поведений, позволяет изменить
	// любое из поведений в любой момент.
	// Так же возможно сразу заменить весь банч поведений
	private DuckBehaviours currentBehaviours;

	// задает начальные поведения
	public Duck(DuckBehaviours currentBehaviours) {
		this.currentBehaviours = currentBehaviours;
	}

	public void walk() {
		currentBehaviours.getWalkBehaviour().walk();
	}

	public void swim() {
		currentBehaviours.getSwimBehaviour().swim();
	}

	public void fly() {
		currentBehaviours.getFlyBehaviour().fly();
	}

	public void move() {
		currentBehaviours.getMoveBehaviour().move();
	}

	public void quack() {
		currentBehaviours.getQuackBehaviour().quack();
	}

	public void recharge() {
		currentBehaviours.getRechargeBehaviour().recharge();
	}

	public DuckBehaviours getCurrentBehaviours() {
		return currentBehaviours;
	}

	public void setCurrentBehaviours(DuckBehaviours currentBehaviours) {
		this.currentBehaviours = currentBehaviours;
	}

}
