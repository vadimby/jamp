package by.epam.jamp.vvd.testapp.service.builder;

import by.epam.jamp.vvd.testapp.model.ProceedResponse;

public class MainTestServiceResponseBuilderImpl implements MainTestServiceResponseBuilder {

	@Override
	public ProceedResponse build(String result) {
		ProceedResponse response = new ProceedResponse();
		response.setResponseMessage(result);
		return response;
	}

}
