package by.epam.jamp.module15.web.soap.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;
import by.epam.jamp.module15.web.soap.types.CreatePersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.DeleteAllPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.DeletePersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.GetAllPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.GetPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.UpdatePersonSoapResponse;

@Component
public class ResponseConverter {

	@Autowired
	private PersonConverter personConverter;

	@Autowired
	private PersonsListConverter personsListConverter;

	public GetPersonSoapResponse convert(GetPersonResponse response) {
		GetPersonSoapResponse soapResponse = new GetPersonSoapResponse();
		soapResponse.setPerson(personConverter.convert(response.getPerson()));
		return soapResponse;
	}

	public GetAllPersonSoapResponse convert(GetAllPersonResponse response) {
		GetAllPersonSoapResponse soapResponse = new GetAllPersonSoapResponse();
		soapResponse.getPerson().addAll(personsListConverter.convert(response.getPersons()));
		return soapResponse;
	}

	public CreatePersonSoapResponse convert(CreatePersonResponse response) {
		CreatePersonSoapResponse soapResponse = new CreatePersonSoapResponse();
		soapResponse.setPerson(personConverter.convert(response.getPerson()));
		return soapResponse;
	}

	public UpdatePersonSoapResponse convert(UpdatePersonResponse response) {
		UpdatePersonSoapResponse soapResponse = new UpdatePersonSoapResponse();
		soapResponse.setPerson(personConverter.convert(response.getPerson()));
		return soapResponse;
	}

	public DeletePersonSoapResponse convert(DeletePersonResponse response) {
		DeletePersonSoapResponse soapResponse = new DeletePersonSoapResponse();
		return soapResponse;
	}

	public DeleteAllPersonSoapResponse convert(DeleteAllPersonResponse response) {
		DeleteAllPersonSoapResponse soapResponse = new DeleteAllPersonSoapResponse();
		soapResponse.getId().addAll(response.getRemovedIds());
		return soapResponse;
	}

}
