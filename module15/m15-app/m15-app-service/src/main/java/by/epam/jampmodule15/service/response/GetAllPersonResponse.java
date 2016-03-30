package by.epam.jampmodule15.service.response;

import java.util.List;

import by.epam.jampmodule15.domain.Person;

public class GetAllPersonResponse {
  
  private List<Person> persons;
  
  public List<Person> getPersons() {
    return persons;
  }
  
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
  
}
