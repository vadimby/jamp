package by.epam.jamp.vvd.testapp.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class RandomStringGeneratorImpl implements RandomStringGenerator {

	@Override
	public String nextString() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

}
