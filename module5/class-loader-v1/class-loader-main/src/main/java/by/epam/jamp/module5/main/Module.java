package by.epam.jamp.module5.main;

public class Module {

	private final int id;
	private final String name;
	private final IModule module;

	public Module(int id, String name, IModule module) {
		this.id = id;
		this.name = name;
		this.module = module;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IModule getModule() {
		return module;
	}

}
