package by.epam.jamp.module15.service.person.converter;

import org.springframework.stereotype.Component;

import by.epam.jamp.module15.persist.service.response.DaoResponseStatus;
import by.epam.jamp.module15.service.response.ResponseStatus;

@Component
public class DaoStatusConverter {
  
  public ResponseStatus convert(DaoResponseStatus responseStatus) {
    if (responseStatus == null) {
      return ResponseStatus.ERROR;
    }
    switch (responseStatus) {
      case OK:
        return ResponseStatus.OK;
      case CONFLICT:
        return ResponseStatus.CONFLICT;
      case NOT_FOUND:
      case ERROR:
      default:
        return ResponseStatus.ERROR;
    }
  }
  
}
