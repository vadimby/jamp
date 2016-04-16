package by.epam.jamp.module15.service.person.response;

import by.epam.jamp.module15.domain.Person;
import by.epam.jamp.module15.service.response.ServiceResponse;

public class CreatePersonResponse extends ServiceResponse {
  
  private Person person;
  
  public Person getPerson() {
    return person;
  }
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
}
