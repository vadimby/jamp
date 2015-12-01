package by.epam.jamp.module1.baseduck.state;

// адаптер объектов измен€ющий состо€ние
public interface DuckStateType {

	public void toAir(StatefullDuck duck);

	public void toGround(StatefullDuck duck);

	public void toWater(StatefullDuck duck);

	public void recharge(StatefullDuck duck);

	public void moveWest(StatefullDuck duck);

	public void moveEast(StatefullDuck duck);

	public void moveNorth(StatefullDuck duck);

	public void moveSouth(StatefullDuck duck);

}
