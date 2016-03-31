package by.epam.jamp.module15.service.person.converter;

import org.springframework.stereotype.Component;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.persist.model.PersonTable;

@Component
public class DaoPersonConverter {
  
  public PersonTable convert(Person person) {
    if (person == null) {
      return null;
    }
    PersonTable personTable = new PersonTable();
    personTable.setId(person.getId());
    personTable.setName(person.getName());
    personTable.setSurname(person.getSurname());
    personTable.setEmail(person.getEmail());
    return personTable;
  }
  
  public Person convert(PersonTable personTable) {
    if (personTable == null) {
      return null;
    }
    Person person = new Person();
    person.setId(personTable.getId());
    person.setName(personTable.getName());
    person.setSurname(personTable.getSurname());
    person.setEmail(personTable.getEmail());
    return person;
  }
  
}
