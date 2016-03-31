package by.epam.jamp.module15.web.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.epam.jamp.module15.service.person.PersonService;
import by.epam.jamp.module15.service.person.request.CreatePersonRequest;
import by.epam.jamp.module15.service.person.request.DeleteAllPersonRequest;
import by.epam.jamp.module15.service.person.request.DeletePersonRequest;
import by.epam.jamp.module15.service.person.request.GetAllPersonRequest;
import by.epam.jamp.module15.service.person.request.GetPersonRequest;
import by.epam.jamp.module15.service.person.request.UpdatePersonRequest;
import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;
import by.epam.jamp.module15.web.soap.converter.RequestConverter;
import by.epam.jamp.module15.web.soap.converter.ResponseConverter;
import by.epam.jamp.module15.web.soap.types.CreatePersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.CreatePersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.DeleteAllPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.DeleteAllPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.DeletePersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.DeletePersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.GetAllPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.GetAllPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.GetPersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.GetPersonSoapResponse;
import by.epam.jamp.module15.web.soap.types.UpdatePersonSoapRequest;
import by.epam.jamp.module15.web.soap.types.UpdatePersonSoapResponse;

@Endpoint
public class PersonEndpoint {

	private static final String NAMESPACE_URI = "urn:by:epam:jamp:module15:web:soap:types";

	@Autowired
	private PersonService personService;

	@Autowired
	private RequestConverter requestConverter;

	@Autowired
	private ResponseConverter responseConverter;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonSoapRequest")
	@ResponsePayload
	public GetPersonSoapResponse getPerson(@RequestPayload GetPersonSoapRequest soapRequest) {
		GetPersonRequest request = requestConverter.convert(soapRequest);

		GetPersonResponse response = personService.get(request);

		return responseConverter.convert(response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPersonSoapRequest")
	@ResponsePayload
	public GetAllPersonSoapResponse listAllPersons(@RequestPayload GetAllPersonSoapRequest soapRequest) {
		GetAllPersonRequest request = requestConverter.convert(soapRequest);

		GetAllPersonResponse response = personService.getAll(request);

		return responseConverter.convert(response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPersonSoapRequest")
	@ResponsePayload
	public CreatePersonSoapResponse createPerson(@RequestPayload CreatePersonSoapRequest soapRequest) {
		CreatePersonRequest request = requestConverter.convert(soapRequest);

		CreatePersonResponse response = personService.create(request);

		return responseConverter.convert(response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePersonSoapRequest")
	@ResponsePayload
	public UpdatePersonSoapResponse updatePerson(@RequestPayload UpdatePersonSoapRequest soapRequest) {
		UpdatePersonRequest request = requestConverter.convert(soapRequest);

		UpdatePersonResponse response = personService.update(request);

		return responseConverter.convert(response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePersonSoapRequest")
	@ResponsePayload
	public DeletePersonSoapResponse deletePerson(@RequestPayload DeletePersonSoapRequest soapRequest) {
		DeletePersonRequest request = requestConverter.convert(soapRequest);

		DeletePersonResponse response = personService.delete(request);

		return responseConverter.convert(response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAllPersonSoapRequest")
	@ResponsePayload
	public DeleteAllPersonSoapResponse deleteAllPersons(@RequestPayload DeleteAllPersonSoapRequest soapRequest) {
		DeleteAllPersonRequest request = requestConverter.convert(soapRequest);

		DeleteAllPersonResponse response = personService.deleteAll(request);

		return responseConverter.convert(response);
	}
}
