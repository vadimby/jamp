package by.epam.jamp.module15.persist.service.response;

import by.epam.jamp.module15.persist.model.PersonTable;

public class UpdatePersonDaoResponse extends DaoResponse<PersonTable> {
  
  public UpdatePersonDaoResponse(DaoResponseStatus responseStatus, PersonTable responseBody) {
    super(responseStatus, responseBody);
  }
  
}
