package by.epam.jamp.vvd.testapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public ProceedResponse proceed(ProceedRequest request) {
		// TODO Auto-generated method stub
		return responseBuilder.build(helper.prepare(request.getMessage()));
	}

}
