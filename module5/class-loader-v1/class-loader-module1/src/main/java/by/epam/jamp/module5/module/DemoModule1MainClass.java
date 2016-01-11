package by.epam.jamp.module5.module;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.IModule;

public class DemoModule1MainClass implements IModule {

	private static final Logger LOG = Logger.getLogger(DemoModule1MainClass.class);

	static {
		LOG.debug("DemoModule1MainClass has been loaded!");
	}

	public DemoModule1MainClass() {
		LOG.debug("new DemoModule1MainClass instance was created!");
	}

	public void doSmth() {
		LOG.debug("DemoModule1MainClass method doSmth was called!");
	}

	public String getInfo() {
		return "DemoModule1";
	}

}
