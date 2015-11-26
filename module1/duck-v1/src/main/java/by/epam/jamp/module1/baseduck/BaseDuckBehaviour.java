package by.epam.jamp.module1.baseduck;

public abstract class BaseDuckBehaviour implements IWalkable, ISwimable, IFlyable, IQuackable, IRenewable {

	private final BaseDuck duck;

	public BaseDuckBehaviour(BaseDuck duck) {
		this.duck = duck;
	}

	public BaseDuck getDuck() {
		return duck;
	}

}
