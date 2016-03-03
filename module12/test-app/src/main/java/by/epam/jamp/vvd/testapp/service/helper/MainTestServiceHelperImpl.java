package by.epam.jamp.vvd.testapp.service.helper;

import org.springframework.stereotype.Component;

@Component
public class MainTestServiceHelperImpl implements MainTestServiceHelper {

	@Override
	public String prepare(String message) {
		// TODO Auto-generated method stub
		return String.format(" == %s == ", message.toUpperCase());
	}
	

}
