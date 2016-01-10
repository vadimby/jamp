package by.epam.jamp.module5.module;

import org.apache.log4j.Logger;

import by.epam.jamp.module5.main.IModule;

public class DemoModule2MainClass implements IModule {

	private static final Logger LOG = Logger.getLogger(DemoModule2MainClass.class);
	
	static {
		LOG.debug("DemoModule2MainClass has been loaded!");
	}
	
	public DemoModule2MainClass() {
		LOG.debug("new DemoModule2MainClass instance was created!");
	}
	
	public void doSmth() {
		System.out.println("DEMO2");
		LOG.debug("DemoModule2MainClass method doSmth was called!");

	}

	public String getInfo() {
		return "DemoModule2";
	}

}
