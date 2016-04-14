package by.epam.jamp.module15.persist.builder;

import static by.epam.jamp.module15.persist.service.response.DaoResponseStatus.CONFLICT;
import static by.epam.jamp.module15.persist.service.response.DaoResponseStatus.ERROR;
import static by.epam.jamp.module15.persist.service.response.DaoResponseStatus.NOT_FOUND;
import static by.epam.jamp.module15.persist.service.response.DaoResponseStatus.OK;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import by.epam.jamp.module15.persist.model.PersonTable;
import by.epam.jamp.module15.persist.service.response.CreatePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeleteAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeletePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.UpdatePersonDaoResponse;

@Component
public class ResponseBuilder {
  
  public CreatePersonDaoResponse buildCreatePersonDaoResponse(PersonTable savedEntity) {
    if (savedEntity != null) {
      return new CreatePersonDaoResponse(OK, savedEntity);
    }
    return new CreatePersonDaoResponse(ERROR, null);
  }
  
  public CreatePersonDaoResponse buildCreatePersonDaoConflictResponse() {
    return new CreatePersonDaoResponse(CONFLICT, null);
  }
  
  public GetPersonDaoResponse buildGetPersonDaoResponse(PersonTable findOne) {
    if (findOne != null) {
      return new GetPersonDaoResponse(OK, findOne);
    }
    return new GetPersonDaoResponse(NOT_FOUND, null);
  }
  
  public GetAllPersonDaoResponse buildGetAllPersonDaoResponse(Iterable<PersonTable> iterable) {
    List<PersonTable> persons = new ArrayList<>();
    iterable.forEach(persons::add);
    return new GetAllPersonDaoResponse(OK, persons);
  }
  
  public UpdatePersonDaoResponse buildUpdatePersonDaoErrorResponse() {
    return new UpdatePersonDaoResponse(ERROR, null);
  }
  
  public UpdatePersonDaoResponse buildUpdatePersonDaoConflictResponse() {
    return new UpdatePersonDaoResponse(CONFLICT, null);
  }
  
  public UpdatePersonDaoResponse buildUpdatePersonDaoNotFoundResponse() {
    return new UpdatePersonDaoResponse(NOT_FOUND, null);
  }
  
  public UpdatePersonDaoResponse buildUpdatePersonDaoResponse(PersonTable updatedPerson) {
    if (updatedPerson != null) {
      return new UpdatePersonDaoResponse(OK, updatedPerson);
    }
    return new UpdatePersonDaoResponse(ERROR, null);
  }
  
  public DeletePersonDaoResponse buildDeletePersonDaoNotFoundResponse() {
    return new DeletePersonDaoResponse(NOT_FOUND);
  }
  
  public DeletePersonDaoResponse buildDeletePersonDaoResponse() {
    return new DeletePersonDaoResponse(OK);
  }
  
  public DeleteAllPersonDaoResponse buildDeleteAllPersonDaoResponse() {
    return new DeleteAllPersonDaoResponse(OK, new ArrayList<Long>());
  }
  
}
