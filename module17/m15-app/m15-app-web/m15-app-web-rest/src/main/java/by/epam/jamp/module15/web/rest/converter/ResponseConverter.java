package by.epam.jamp.module15.web.rest.converter;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;
import by.epam.jamp.module15.service.response.ResponseStatus;
import by.epam.jamp.module15.web.rest.model.PersonDto;

public class ResponseConverter {
  
  private PersonsListConverter personListConverter;
  
  private PersonConverter personConverter;
  
  public ResponseEntity<List<PersonDto>> convert(GetAllPersonResponse response) {
    List<Person> persons = response.getPersons();
    if (persons == null || persons.isEmpty()) {
      return new ResponseEntity<List<PersonDto>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<PersonDto>>(personListConverter.convert(persons), HttpStatus.OK);
  }
  
  public ResponseEntity<PersonDto> convert(GetPersonResponse response) {
    Person person = response.getPerson();
    if (person == null) {
      return new ResponseEntity<PersonDto>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<PersonDto>(personConverter.convert(person), HttpStatus.OK);
  }
  
  public ResponseEntity<Void> convert(CreatePersonResponse response) {
    Person person = response.getPerson();
    if (ResponseStatus.CONFLICT.equals(response.getStatus())) {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
    
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(UriComponentsBuilder.fromPath("/person/{id}").buildAndExpand(person.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  public ResponseEntity<PersonDto> convert(UpdatePersonResponse response) {
    Person person = response.getPerson();
    if (ResponseStatus.ERROR.equals(response.getStatus())) {
      return new ResponseEntity<PersonDto>(HttpStatus.NOT_FOUND);
    }
    if (ResponseStatus.CONFLICT.equals(response.getStatus())) {
      return new ResponseEntity<PersonDto>(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<PersonDto>(personConverter.convert(person), HttpStatus.OK);
    
  }
  
  public ResponseEntity<PersonDto> convert(DeletePersonResponse response) {
    if (ResponseStatus.ERROR.equals(response.getStatus())) {
      return new ResponseEntity<PersonDto>(HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<PersonDto>(HttpStatus.NO_CONTENT);
  }
  
  public ResponseEntity<List<Long>> convert(DeleteAllPersonResponse response) {
    return new ResponseEntity<List<Long>>(response.getRemovedIds(), HttpStatus.OK);
  }

  public void setPersonListConverter(PersonsListConverter personListConverter) {
    this.personListConverter = personListConverter;
  }

  public void setPersonConverter(PersonConverter personConverter) {
    this.personConverter = personConverter;
  }
  
  
}
