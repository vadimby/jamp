package by.epam.jamp.vvd.testapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "v0.1.0";
	}
	
	@RequestMapping("/echo/{message}")
	public String echo(@PathVariable("message") String message) {
		return message;
	}

}
