package by.epam.jamp.module15.web.soap.converter;

import org.springframework.stereotype.Component;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.web.soap.types.PersonDto;

@Component
public class PersonConverter {
  
  public PersonDto convert(Person person) {
    if (person == null) {
       return null;
    }
    PersonDto personDto = new PersonDto();
    personDto.setId(person.getId());
    personDto.setName(person.getName());
    personDto.setSurname(person.getSurname());
    personDto.setEmail(person.getEmail());
    return personDto;
  }
  
  public Person convert(PersonDto personDto) {
    if (personDto == null) {
      return null;
   }

    Person person = new Person();
    person.setId(personDto.getId());
    person.setName(personDto.getName());
    person.setSurname(personDto.getSurname());
    person.setEmail(personDto.getEmail());
    return person;
  }
}
