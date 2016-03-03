package by.epam.jamp.vvd.testapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import by.epam.jamp.vvd.testapp.dao.model.TestData;
import by.epam.jamp.vvd.testapp.dao.model.repositories.TestDataRepository;

@Component
@Profile("dev")
public class TestDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private TestDataRepository testDataRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		TestData data = new TestData("test1", "Hello1");
		testDataRepository.save(data);
	}
}