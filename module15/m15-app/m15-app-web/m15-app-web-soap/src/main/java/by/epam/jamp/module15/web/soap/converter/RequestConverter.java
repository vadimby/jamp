package by.epam.jamp.module15.web.soap.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.module15.service.person.request.CreatePersonRequest;
import by.epam.jamp.module15.service.person.request.DeleteAllPersonRequest;
import by.epam.jamp.module15.service.person.request.DeletePersonRequest;
import by.epam.jamp.module15.service.person.request.GetAllPersonRequest;
import by.epam.jamp.module15.service.person.request.GetPersonRequest;
import by.epam.jamp.module15.service.person.request.UpdatePersonRequest;
import by.epam.jamp.module15.web.soap.types.CreatePersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.DeleteAllPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.DeletePersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.GetAllPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.GetPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.UpdatePersonSoapRequest;

@Component
public class RequestConverter {

	@Autowired
	private PersonConverter personConverter;

	public GetPersonRequest convert(GetPersonSoapRequest soapRequest) {
		GetPersonRequest request = new GetPersonRequest();
		request.setPersonId(soapRequest.getPersonId());
		return request;
	}

	public GetAllPersonRequest convert(GetAllPersonSoapRequest soapRequest) {
		GetAllPersonRequest request = new GetAllPersonRequest();
		return request;
	}

	public CreatePersonRequest convert(CreatePersonSoapRequest soapRequest) {
		CreatePersonRequest request = new CreatePersonRequest();
		request.setName(soapRequest.getName());
		request.setSurname(soapRequest.getSurname());
		request.setEmail(soapRequest.getEmail());
		return request;
	}

	public UpdatePersonRequest convert(UpdatePersonSoapRequest soapRequest) {
		UpdatePersonRequest request = new UpdatePersonRequest();
		request.setPerson(personConverter.convert(soapRequest.getPerson()));
		return request;
	}

	public DeletePersonRequest convert(DeletePersonSoapRequest soapRequest) {
		DeletePersonRequest request = new DeletePersonRequest();
		request.setPersonId(soapRequest.getPersonId());
		return request;
	}

	public DeleteAllPersonRequest convert(DeleteAllPersonSoapRequest soapRequest) {
		DeleteAllPersonRequest request = new DeleteAllPersonRequest();
		return request;
	}

}
