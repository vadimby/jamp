package by.epam.jamp.module15.persist.service.response;

import java.util.List;

import by.epam.jamp.module15.persist.model.PersonTable;

public class GetAllPersonDaoResponse extends DaoResponse<List<PersonTable>> {
  
  public GetAllPersonDaoResponse(DaoResponseStatus responseStatus, List<PersonTable> responseBody) {
    super(responseStatus, responseBody);
  }
  
}
