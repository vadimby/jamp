package by.epam.jamp.module1.simpleduck;

import by.epam.jamp.module1.baseduck.BaseDuck;
import by.epam.jamp.module1.baseduck.BaseDuckBehaviour;

public class SimpleDuckBehaviourHangry extends BaseDuckBehaviour {

	public SimpleDuckBehaviourHangry(BaseDuck duck) {
		super(duck);
	}

	public void walk() {
		System.out.println("��������... �� ����� ����.");
	}

	public void swim() {
		System.out.println("��������... �� ����� �����.");
	}

	public void fly() {
		System.out.println("��������... �� ����� ������.");

	}

	public void quack() {
		System.out.println("��������... �� ����� ����.");

	}

	public void renew() {
		getDuck().recharge();
		System.out.println("����� ��� �� �����");
		getDuck().setDuckBehaviour(new SimpleDuckBehaviourNormal(getDuck()));
	}

}
