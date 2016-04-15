package by.epam.jamp.module15.service.person.converter;

import java.util.ArrayList;
import java.util.List;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.persist.model.PersonTable;

public class DaoPersonsListConverter {
  
  private DaoPersonConverter personConverter;
  
  public List<Person> convert(List<PersonTable> responseBody) {
    if (responseBody == null) {
      return null;
    }
    List<Person> persons = new ArrayList<Person>();
    for (PersonTable personTable : responseBody) {
      persons.add(personConverter.convert(personTable));
    }
    return persons;
  }
  
}
