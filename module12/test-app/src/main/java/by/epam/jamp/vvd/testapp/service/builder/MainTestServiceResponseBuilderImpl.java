package by.epam.jamp.vvd.testapp.service.builder;

import org.springframework.stereotype.Component;

import by.epam.jamp.vvd.testapp.model.ProceedResponse;

@Component
public class MainTestServiceResponseBuilderImpl implements MainTestServiceResponseBuilder {

	@Override
	public ProceedResponse build(String result) {
		ProceedResponse response = new ProceedResponse();
		response.setResponseMessage(result);
		return response;
	}

}
