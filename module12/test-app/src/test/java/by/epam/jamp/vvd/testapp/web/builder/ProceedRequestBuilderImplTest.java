package by.epam.jamp.vvd.testapp.web.builder;

import static org.hamcrest.core.IsNull.nullValue;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.epam.jamp.vvd.testapp.model.ProceedRequest;

public class ProceedRequestBuilderImplTest {

	private ProceedRequestBuilderImpl builderImpl;
	
	@BeforeTest
	public void testInit() {
		builderImpl = new ProceedRequestBuilderImpl();
	}
	
	@Test
	public void buildShouldReturnNullIfMessageIsNull() {
		
		ProceedRequest build = builderImpl.build(null);

		MatcherAssert.assertThat(build, Matchers.is(nullValue()));

	}
	
	@Test
	public void buildShouldReturnNullIfMessageIsEmpty() {
		ProceedRequest build = builderImpl.build("");

		MatcherAssert.assertThat(build, Matchers.is(nullValue()));

	}
	
	@Test
	public void buildShouldReturnNullIfMessageIsBalnk() {
		ProceedRequest build = builderImpl.build("  ");

		MatcherAssert.assertThat(build, Matchers.is(nullValue()));

	}

}
