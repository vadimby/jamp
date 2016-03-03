package by.epam.jamp.vvd.testapp.service;

import by.epam.jamp.vvd.testapp.model.ProceedRequest;
import by.epam.jamp.vvd.testapp.model.ProceedResponse;

public interface MainTestService {
	
	ProceedResponse proceed(ProceedRequest request);

}
