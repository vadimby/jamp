package by.epam.jamp.module15.persist.service.request;

import by.epam.jamp.module15.persist.model.PersonTable;

public class UpdatePersonDaoRequest {

  private PersonTable person;
  
  public PersonTable getPerson() {
    return person;
  }
  
  public void setPerson(PersonTable person) {
    this.person = person;
  }
  
}
