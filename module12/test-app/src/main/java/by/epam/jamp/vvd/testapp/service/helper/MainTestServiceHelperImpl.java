package by.epam.jamp.vvd.testapp.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.vvd.testapp.dao.model.TestData;
import by.epam.jamp.vvd.testapp.utils.RandomStringGenerator;

@Component
public class MainTestServiceHelperImpl implements MainTestServiceHelper {

	@Autowired
	private RandomStringGenerator stringGenerator;
	
	@Override
	public TestData generateTestData(String message) {
		return new TestData(message, stringGenerator.nextString());
	}

}
