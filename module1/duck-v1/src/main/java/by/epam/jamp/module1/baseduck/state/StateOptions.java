package by.epam.jamp.module1.baseduck.state;

// ��������� ���������� �������� �������������� ����� ������ ���������. 
// (��������� ����������, ������������ ������� �������, ��������� �� ���������) 
public interface StateOptions {

	DuckStates getInitialStates();

	DuckStateType getStateType();

}
