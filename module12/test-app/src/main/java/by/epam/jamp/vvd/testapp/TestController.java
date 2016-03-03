package by.epam.jamp.vvd.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.epam.jamp.vvd.testapp.service.MainTestService;
import by.epam.jamp.vvd.testapp.web.builder.ProceedRequestBuilder;

@RestController
public class TestController {

	@Autowired
	private MainTestService service;
	
	@Autowired
	private ProceedRequestBuilder requestBuilder;

	@RequestMapping("/process/{message}")
	public String proceed(@PathVariable("message") String message) {
		return service.proceed(requestBuilder.build(message)).getResponseMessage();
	}

}
