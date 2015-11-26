package by.epam.jamp.module1.baseduck;

public class Context {

	private Environment env;
	private State state;

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
