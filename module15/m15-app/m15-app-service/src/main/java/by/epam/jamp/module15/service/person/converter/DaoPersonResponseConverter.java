package by.epam.jamp.module15.service.person.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.module15.persist.service.response.CreatePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeleteAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeletePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.UpdatePersonDaoResponse;
import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;

@Component
public class DaoPersonResponseConverter {
  
  @Autowired
  private DaoPersonConverter personConverter;
  
  @Autowired
  private DaoPersonsListConverter personsListConverter;
  
  @Autowired
  private DaoStatusConverter statusConverter;
  
  public CreatePersonResponse convert(CreatePersonDaoResponse daoResponse) {
    CreatePersonResponse response = new CreatePersonResponse();
    response.setStatus(statusConverter.convert(daoResponse.getResponseStatus()));
    response.setPerson(personConverter.convert(daoResponse.getResponseBody()));
    return response;
  }
  
  public GetPersonResponse convert(GetPersonDaoResponse daoResponse) {
    GetPersonResponse response = new GetPersonResponse();
    response.setPerson(personConverter.convert(daoResponse.getResponseBody()));
    return response;
  }
  
  public GetAllPersonResponse convert(GetAllPersonDaoResponse daoResponse) {
    GetAllPersonResponse response = new GetAllPersonResponse();
    response.setPersons(personsListConverter.convert(daoResponse.getResponseBody()));
    return response;
  }
  
  public UpdatePersonResponse convert(UpdatePersonDaoResponse daoResponse) {
    UpdatePersonResponse response = new UpdatePersonResponse();
    response.setStatus(statusConverter.convert(daoResponse.getResponseStatus()));
    response.setPerson(personConverter.convert(daoResponse.getResponseBody()));
    return response;
  }
  
  public DeletePersonResponse convert(DeletePersonDaoResponse daoResponse) {
    DeletePersonResponse response = new DeletePersonResponse();
    response.setStatus(statusConverter.convert(daoResponse.getResponseStatus()));
    return response;
  }
  
  public DeleteAllPersonResponse convert(DeleteAllPersonDaoResponse daoResponse) {
    DeleteAllPersonResponse response = new DeleteAllPersonResponse();
    response.setRemovedIds(daoResponse.getResponseBody());
    return response;
  }
  
}
