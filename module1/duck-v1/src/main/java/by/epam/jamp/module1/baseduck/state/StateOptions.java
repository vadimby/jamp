package by.epam.jamp.module1.baseduck.state;

// настройка параметров поведний осуществляется через данный интерфейс. 
// (начальные координаты, максимальный уровень энергии, поведение по умолчанию) 
public interface StateOptions {

	DuckStates getInitialStates();

	DuckStateType getStateType();

}
