package by.epam.jamp.vvd.testapp.web.builder;

import org.springframework.stereotype.Component;

import by.epam.jamp.vvd.testapp.model.ProceedRequest;

@Component
public class ProceedRequestBuilderImpl implements ProceedRequestBuilder {

	@Override
	public ProceedRequest build(String message) {
		if (message != null && !message.isEmpty()) {
			ProceedRequest request = new ProceedRequest();
			request.setMessage(message);
			return request;

		}
		return null;
	}

}
