package by.epam.jamp.module5.module;

import org.apache.log4j.Logger;

public class SomeClass {
	
	private static final Logger LOG = Logger.getLogger(SomeClass.class);
	
	static {
		LOG.debug("SomeClass has been loaded!");
	}
	
	public SomeClass() {
		LOG.debug("SomeClass constructor was called!");
	}
	
	@Override
	public String toString() {
		return "SomeClass toString method was called";
	}

}
