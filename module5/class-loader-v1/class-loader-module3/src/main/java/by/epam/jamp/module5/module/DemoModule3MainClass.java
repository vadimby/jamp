package by.epam.jamp.module5.module;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.IModule;

public class DemoModule3MainClass implements IModule {

	private static final Logger LOG = Logger.getLogger(DemoModule3MainClass.class);

	static {
		LOG.debug("DemoModule3MainClass has been loaded!");
	}

	public DemoModule3MainClass() {
		LOG.debug("new DemoModule3MainClass instance was created!");
	}

	public void doSmth() {
		LOG.debug("DemoModule3MainClass method doSmth was called!");
	}

	public String getInfo() {
		return "DemoModule3";
	}

}
