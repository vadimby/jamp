package by.epam.jamp.module15.web.rest.converter;

import java.util.ArrayList;
import java.util.List;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.web.rest.model.PersonDto;

public class PersonsListConverter {
  
  private PersonConverter personConverter;
  
  public List<PersonDto> convert(List<Person> persons) {
    List<PersonDto> personsDto = new ArrayList<PersonDto>();
    for (Person person : persons) {
      personsDto.add(personConverter.convert(person));
    }
    return personsDto;
  }
  
  public void setPersonConverter(PersonConverter personConverter) {
    this.personConverter = personConverter;
  }
  
}
