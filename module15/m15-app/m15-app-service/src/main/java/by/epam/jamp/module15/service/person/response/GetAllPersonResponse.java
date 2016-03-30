package by.epam.jamp.module15.service.person.response;

import java.util.List;

import by.epam.jamp.module15.domain.Person;

public class GetAllPersonResponse {
  
  private List<Person> persons;
  
  public List<Person> getPersons() {
    return persons;
  }
  
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
  
}
