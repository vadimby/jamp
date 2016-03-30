package by.epam.jampmodule15.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import by.epam.jampmodule15.domain.Person;
import by.epam.jampmodule15.service.request.CreatePersonRequest;
import by.epam.jampmodule15.service.request.DeleteAllPersonRequest;
import by.epam.jampmodule15.service.request.DeletePersonRequest;
import by.epam.jampmodule15.service.request.GetAllPersonRequest;
import by.epam.jampmodule15.service.request.GetPersonRequest;
import by.epam.jampmodule15.service.request.UpdatePersonRequest;
import by.epam.jampmodule15.service.response.CreatePersonResponse;
import by.epam.jampmodule15.service.response.DeleteAllPersonResponse;
import by.epam.jampmodule15.service.response.DeletePersonResponse;
import by.epam.jampmodule15.service.response.GetAllPersonResponse;
import by.epam.jampmodule15.service.response.GetPersonResponse;
import by.epam.jampmodule15.service.response.UpdatePersonResponse;

public class PersonServiceStaticImpl implements PersonService {
  
  private static Map<Long, Person> persons = new HashMap<Long, Person>();
  
  private static int id = 1;
  
  @Override
  public CreatePersonResponse create(CreatePersonRequest request) {
    Person person = new Person();
    Long personId = Long.valueOf(id++);
    person.setId(personId);
    person.setName(request.getName());
    person.setSurname(request.getSurname());
    
    persons.put(personId, person);
    
    CreatePersonResponse response = new CreatePersonResponse();
    response.setPerson(person);
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
    
    if (persons.containsKey(request.getId())) {
      Person person = persons.get(request.getId());
      person.setName(request.getName());
      person.setSurname(request.getSurname());
      response.setPerson(person);
    }
    return response;
  }
  
  @Override
  public DeletePersonResponse delete(DeletePersonRequest request) {
    DeletePersonResponse response = new DeletePersonResponse();
    if (persons.containsKey(request.getPersonId())) {
      persons.remove(request.getPersonId());
      response.setRemoved(true);
    }
    return response;
  }
  
  @Override
  public DeleteAllPersonResponse deleteAll(DeleteAllPersonRequest request) {
    List<Long> removedIds = new ArrayList<Long>();
    for (Iterator<Long> iterator = persons.keySet().iterator(); iterator.hasNext();) {
      Long key = iterator.next();
      persons.remove(key);
      removedIds.add(key);
    }
    DeleteAllPersonResponse response = new DeleteAllPersonResponse();
    response.setRemovedIds(removedIds);
    return response;
  }
  
}
