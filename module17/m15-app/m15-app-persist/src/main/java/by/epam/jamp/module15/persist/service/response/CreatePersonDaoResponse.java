package by.epam.jamp.module15.persist.service.response;

import by.epam.jamp.module15.persist.model.PersonTable;

public class CreatePersonDaoResponse extends DaoResponse<PersonTable> {
  
  public CreatePersonDaoResponse(DaoResponseStatus status, PersonTable personTable) {
    super(status, personTable);
  }
  
}