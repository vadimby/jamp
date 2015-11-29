package by.epam.jamp.module1.baseduck;

public abstract class Duck {

	private DuckBehaviours currentBehaviours;
	
	public Duck(DuckBehaviours currentBehaviours){
		this.currentBehaviours = currentBehaviours;
	}

	public void walk() {
		getCurrentBehaviours().getWalkBehaviour().walk();
	}

	public void swim() {
		getCurrentBehaviours().getSwimBehaviour().swim();
	}

	public void fly() {
		getCurrentBehaviours().getFlyBehaviour().fly();
	}

	public void quack() {
		getCurrentBehaviours().getQuackBehaviour().quack();
	}

	public void recharge() {
		getCurrentBehaviours().getRechargeBehaviour().recharge();
	}

	public DuckBehaviours getCurrentBehaviours() {
		return currentBehaviours;
	}

	public void setCurrentBehaviours(DuckBehaviours currentBehaviours) {
		this.currentBehaviours = currentBehaviours;
	}

	
}
