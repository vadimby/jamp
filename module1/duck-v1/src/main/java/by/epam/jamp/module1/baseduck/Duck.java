package by.epam.jamp.module1.baseduck;

public abstract class Duck {

	private DuckBehaviours currentBehaviours;
	
	public Duck(DuckBehaviours currentBehaviours){
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
