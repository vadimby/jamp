package by.epam.jamp.module15.service.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import by.epam.jamp.module15.domain.Person;
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
import by.epam.jamp.module15.service.response.ResponseStatus;

public class PersonServiceStaticImpl implements PersonService {

	private static Map<Long, Person> persons = new HashMap<Long, Person>();
	private static Map<String, Person> personsEmailIndex = new HashMap<String, Person>();
	private static int id = 1;

	@Override
	public CreatePersonResponse create(CreatePersonRequest request) {
		CreatePersonResponse response = new CreatePersonResponse();
		String email = request.getEmail();
		if (personsEmailIndex.containsKey(email)) {
			response.setStatus(ResponseStatus.CONFLICT);
		} else {
			Person person = new Person();
			Long personId = Long.valueOf(id++);
			person.setId(personId);
			person.setName(request.getName());
			person.setSurname(request.getSurname());
			person.setEmail(request.getEmail());

			persons.put(personId, person);
			personsEmailIndex.put(email, person);

			response.setStatus(ResponseStatus.OK);
			response.setPerson(person);
		}
		return response;
	}

	@Override
	public GetPersonResponse get(GetPersonRequest request) {
		GetPersonResponse response = new GetPersonResponse();
		response.setPerson(persons.get(request.getPersonId()));
		return response;
	}

	@Override
	public GetAllPersonResponse getAll(GetAllPersonRequest request) {
		GetAllPersonResponse response = new GetAllPersonResponse();
		response.setPersons(new ArrayList<Person>(persons.values()));
		return response;
	}

	@Override
	public UpdatePersonResponse update(UpdatePersonRequest request) {
		UpdatePersonResponse response = new UpdatePersonResponse();
		Person originalPerson = request.getPerson();
		String email = originalPerson.getEmail();
		if (personsEmailIndex.containsKey(email)) {
			response.setStatus(ResponseStatus.CONFLICT);
		} else if (persons.containsKey(originalPerson.getId())) {
			Person updatedPerson = persons.get(originalPerson.getId());
			updatedPerson.setName(originalPerson.getName());
			updatedPerson.setSurname(originalPerson.getSurname());
			updatedPerson.setEmail(originalPerson.getEmail());
			response.setStatus(ResponseStatus.OK);
			response.setPerson(updatedPerson);
		} else {
			response.setStatus(ResponseStatus.ERROR);
		}
		return response;
	}

	@Override
	public DeletePersonResponse delete(DeletePersonRequest request) {
		DeletePersonResponse response = new DeletePersonResponse();
		if (persons.containsKey(request.getPersonId())) {
			Person person = persons.remove(request.getPersonId());
			personsEmailIndex.remove(person.getEmail());
			response.setStatus(ResponseStatus.OK);
		} else {
			response.setStatus(ResponseStatus.ERROR);
		}
		return response;
	}

	@Override
	public DeleteAllPersonResponse deleteAll(DeleteAllPersonRequest request) {
		List<Long> removedIds = new ArrayList<Long>();
		for (Iterator<Long> iterator = persons.keySet().iterator(); iterator.hasNext();) {
			Long key = iterator.next();
			Person person = persons.remove(key);
			personsEmailIndex.remove(person.getEmail());
			removedIds.add(key);
		}
		DeleteAllPersonResponse response = new DeleteAllPersonResponse();
		response.setRemovedIds(removedIds);
		return response;
	}

}
