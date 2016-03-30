package by.epam.jamp.module15.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import by.epam.jamp.module15.web.rest.builder.RequestBuilder;
import by.epam.jamp.module15.web.rest.converter.ResponseConverter;
import by.epam.jamp.module15.web.rest.model.PersonDto;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private RequestBuilder requestBuilder;

	@Autowired
	private ResponseConverter responseConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonDto>> listAllPersons() {
		GetAllPersonRequest request = requestBuilder.buildGetAllPersonsRequest();

		GetAllPersonResponse response = personService.getAll(request);

		return responseConverter.convert(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDto> getPerson(@PathVariable("id") long id) {
		GetPersonRequest request = requestBuilder.buildGetPersonRequest(id);

		GetPersonResponse response = personService.get(request);

		return responseConverter.convert(response);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createPerson(@RequestBody PersonDto person) {
		CreatePersonRequest request = requestBuilder.buildCreatePersonRequest(person);

		CreatePersonResponse response = personService.create(request);

		return responseConverter.convert(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") long id, @RequestBody PersonDto person) {
		UpdatePersonRequest request = requestBuilder.buildUpdatePersonRequest(person);

		UpdatePersonResponse response = personService.update(request);

		return responseConverter.convert(response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PersonDto> deletePerson(@PathVariable("id") long id) {
		DeletePersonRequest request = requestBuilder.buildDeletePersonRequest(id);

		DeletePersonResponse response = personService.delete(request);

		return responseConverter.convert(response);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<List<Long>> deleteAllPersons() {
		DeleteAllPersonRequest request = requestBuilder.buildDeleteAllPersonRequest();

		DeleteAllPersonResponse response = personService.deleteAll(request);

		return responseConverter.convert(response);
	}

}
