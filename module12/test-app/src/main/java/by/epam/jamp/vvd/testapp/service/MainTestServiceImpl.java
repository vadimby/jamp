package by.epam.jamp.vvd.testapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.jamp.vvd.testapp.dao.model.TestData;
import by.epam.jamp.vvd.testapp.dao.model.repositories.TestDataRepository;
import by.epam.jamp.vvd.testapp.model.ProceedRequest;
import by.epam.jamp.vvd.testapp.model.ProceedResponse;
import by.epam.jamp.vvd.testapp.service.builder.MainTestServiceResponseBuilder;
import by.epam.jamp.vvd.testapp.service.helper.MainTestServiceHelper;

@Service
public class MainTestServiceImpl implements MainTestService {

	@Autowired
	private MainTestServiceHelper helper;
	
	@Autowired
	private MainTestServiceResponseBuilder responseBuilder;
	
	@Autowired
	private TestDataRepository repository;
	
	@Override
	public ProceedResponse proceed(ProceedRequest request) {
		TestData testData = repository.findByKey(request.getMessage());
		if (testData == null) {
			testData = repository.save(helper.generateTestData(request.getMessage()));
		}
		return responseBuilder.build(testData.getValue());
	}

}
