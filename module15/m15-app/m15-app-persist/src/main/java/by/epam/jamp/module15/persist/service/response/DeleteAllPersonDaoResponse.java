package by.epam.jamp.module15.persist.service.response;

import java.util.List;

public class DeleteAllPersonDaoResponse extends DaoResponse<List<Long>> {
  
  public DeleteAllPersonDaoResponse(DaoResponseStatus responseStatus, List<Long> responseBody) {
    super(responseStatus, responseBody);
  }
  
}
