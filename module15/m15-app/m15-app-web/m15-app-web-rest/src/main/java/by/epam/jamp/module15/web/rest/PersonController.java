package by.epam.jamp.module15.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.service.person.PersonService;
import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;
import by.epam.jamp.module15.service.response.ResponseStatus;
import by.epam.jamp.module15.web.rest.builder.RequestBuilder;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
  
  @Autowired
  private PersonService personService;
  
  @Autowired
  private RequestBuilder requestBuilder;
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Person>> listAllPersons() {
    GetAllPersonResponse response = personService.getAll(requestBuilder.buildGetAllPersonsRequest());
    if (response.getPersons() == null || response.getPersons().isEmpty()) {
      return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Person>>(response.getPersons(), HttpStatus.OK);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
    System.out.println("Fetching Person with id " + id);
    GetPersonResponse respose = personService.get(requestBuilder.buildGetPersonRequest(id));
    if (respose.getPerson() == null) {
      System.out.println("Person with id " + id + " not found");
      return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Person>(respose.getPerson(), HttpStatus.OK);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
    System.out.println("Creating Person " + person.getName());
    
    CreatePersonResponse response = personService.create(requestBuilder.buildCreatePersonRequest(person));
    
    if (ResponseStatus.CONFLICT.equals(response.getStatus())) {
      System.out.println("A Person with such email " + person.getName() + " already exist");
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
    System.out.println("Updating Person " + id);
    
    UpdatePersonResponse response = personService.update(requestBuilder.buildUpdatePersonRequest(person));
    
    if (ResponseStatus.ERROR.equals(response.getStatus())) {
      System.out.println("Person with id " + id + " not found");
      return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
    
    if (ResponseStatus.CONFLICT.equals(response.getStatus())) {
      System.out.println("A Person with such email " + person.getName() + " already exist");
      return new ResponseEntity<Person>(HttpStatus.CONFLICT);
    }
    
    return new ResponseEntity<Person>(response.getPerson(), HttpStatus.OK);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Person> deletePerson(@PathVariable("id") long id) {
    System.out.println("Fetching & Deleting Person with id " + id);
    
    DeletePersonResponse response = personService.delete(requestBuilder.buildDeletePersonReqeust(id));
    if (ResponseStatus.ERROR.equals(response.getStatus())) {
      System.out.println("Unable to delete. Person with id " + id + " not found");
      return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public ResponseEntity<List<Long>> deleteAllPersons() {
    System.out.println("Deleting All Persons");
    
    DeleteAllPersonResponse response = personService.deleteAll(requestBuilder.buildDeleteAllPersonRequest());
    return new ResponseEntity<List<Long>>(response.getRemovedIds(), HttpStatus.OK);
  }
  
}
