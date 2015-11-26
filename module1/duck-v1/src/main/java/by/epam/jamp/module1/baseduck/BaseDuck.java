package by.epam.jamp.module1.baseduck;

public abstract class BaseDuck implements IWalkable, ISwimable, IFlyable, IQuackable, IRenewable {

	private BaseDuckBehaviour duckBehaviour;
	private int chargeLevel;
	private final int maxChargeLevel;

	public BaseDuck(int maxChargeLevel) {
		this.maxChargeLevel = maxChargeLevel;
	}

	public int getChargeLevel() {
		return chargeLevel;
	}

	public void setChargeLevel(int chargeLevel) {
		this.chargeLevel = chargeLevel;
	}

	public BaseDuckBehaviour getDuckBehaviour() {
		return duckBehaviour;
	}

	public void setDuckBehaviour(BaseDuckBehaviour baseBehaviour) {
		this.duckBehaviour = baseBehaviour;
	}

	public void decreaseChargeLevel() {
		chargeLevel--;
		System.out.println("Осталось:" + chargeLevel);
	}

	public int getMaxChargeLevel() {
		return maxChargeLevel;
	}
	
	public void recharge() {
		chargeLevel = maxChargeLevel;
	}

}
