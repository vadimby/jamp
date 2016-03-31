package by.epam.jamp.module15.persist.service.response;

import by.epam.jamp.module15.persist.model.PersonTable;

public class GetPersonDaoResponse extends DaoResponse<PersonTable> {
  
  public GetPersonDaoResponse(DaoResponseStatus responseStatus, PersonTable responseBody) {
    super(responseStatus, responseBody);
  }
  
}
