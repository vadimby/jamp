package by.epam.jamp.vvd.testapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.epam.jamp.vvd.testapp.Application;
import by.epam.jamp.vvd.testapp.dao.model.TestData;
import by.epam.jamp.vvd.testapp.dao.model.repositories.TestDataRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("dev")
public  class DaoTest {

	@Autowired
	private TestDataRepository repository;

	@Test
	public void testDataRespository() {
		String key = "test1";
		String expectedValue = "Hello1";
		
		TestData result = repository.findByKey(key);
		
		assertNotNull(result);
		assertEquals(expectedValue, result.getValue());
	}

}
