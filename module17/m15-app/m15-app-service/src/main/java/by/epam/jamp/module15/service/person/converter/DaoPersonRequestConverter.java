package by.epam.jamp.module15.service.person.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.module15.persist.service.request.CreatePersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.DeleteAllPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.DeletePersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.GetAllPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.GetPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.UpdatePersonDaoRequest;
import by.epam.jamp.module15.service.person.request.CreatePersonRequest;
import by.epam.jamp.module15.service.person.request.DeleteAllPersonRequest;
import by.epam.jamp.module15.service.person.request.DeletePersonRequest;
import by.epam.jamp.module15.service.person.request.GetAllPersonRequest;
import by.epam.jamp.module15.service.person.request.GetPersonRequest;
import by.epam.jamp.module15.service.person.request.UpdatePersonRequest;

public class DaoPersonRequestConverter {
  
  private DaoPersonConverter personConverter;
  
  public CreatePersonDaoRequest convert(CreatePersonRequest request) {
    CreatePersonDaoRequest daoRequest = new CreatePersonDaoRequest();
    daoRequest.setName(request.getName());
    daoRequest.setSurname(request.getSurname());
    daoRequest.setEmail(request.getEmail());
    return daoRequest;
  }
  
  public GetPersonDaoRequest convert(GetPersonRequest request) {
    GetPersonDaoRequest daoRequest = new GetPersonDaoRequest();
    daoRequest.setPersonId(request.getPersonId());
    return daoRequest;
  }
  
  public GetAllPersonDaoRequest convert(GetAllPersonRequest request) {
    GetAllPersonDaoRequest daoRequest = new GetAllPersonDaoRequest();
    return daoRequest;
  }
  
  public UpdatePersonDaoRequest convert(UpdatePersonRequest request) {
    UpdatePersonDaoRequest daoRequest = new UpdatePersonDaoRequest();
    daoRequest.setPerson(personConverter.convert(request.getPerson()));
    return daoRequest;
  }
  
  public DeletePersonDaoRequest convert(DeletePersonRequest request) {
    DeletePersonDaoRequest daoRequest = new DeletePersonDaoRequest();
    daoRequest.setPersonId(request.getPersonId());
    return daoRequest;
  }
  
  public DeleteAllPersonDaoRequest convert(DeleteAllPersonRequest request) {
    DeleteAllPersonDaoRequest daoRequest = new DeleteAllPersonDaoRequest();
    return daoRequest;
  }
  
}
