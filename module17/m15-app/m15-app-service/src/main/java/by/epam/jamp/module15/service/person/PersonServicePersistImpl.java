package by.epam.jamp.module15.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.jamp.module15.persist.service.PersonDaoService;
import by.epam.jamp.module15.service.person.converter.DaoPersonRequestConverter;
import by.epam.jamp.module15.service.person.converter.DaoPersonResponseConverter;
import by.epam.jamp.module15.service.person.request.CreatePersonRequest;
import by.epam.jamp.module15.service.person.request.DeleteAllPersonRequest;
import by.epam.jamp.module15.service.person.request.DeletePersonRequest;
import by.epam.jamp.module15.service.person.request.GetAllPersonRequest;
import by.epam.jamp.module15.service.person.request.GetPersonRequest;
import by.epam.jamp.module15.service.person.request.UpdatePersonRequest;
import by.epam.jamp.module15.service.person.response.CreatePersonResponse;
import by.epam.jamp.module15.service.person.response.DeleteAllPersonResponse;
import by.epam.jamp.module15.service.person.response.DeletePersonResponse;
import by.epam.jamp.module15.service.person.response.GetAllPersonResponse;
import by.epam.jamp.module15.service.person.response.GetPersonResponse;
import by.epam.jamp.module15.service.person.response.UpdatePersonResponse;

@Service
public class PersonServicePersistImpl implements PersonService {

  @Autowired
  private PersonDaoService personDaoService;
  
  @Autowired
  private DaoPersonRequestConverter requestConverter;
  
  @Autowired
  private DaoPersonResponseConverter responseConverter;  
  
  @Override
  public CreatePersonResponse create(CreatePersonRequest request) {
    return responseConverter.convert(personDaoService.create(requestConverter.convert(request)));
  }

  @Override
  public GetPersonResponse get(GetPersonRequest request) {
    return responseConverter.convert(personDaoService.get(requestConverter.convert(request)));
  }

  @Override
  public GetAllPersonResponse getAll(GetAllPersonRequest request) {
    return responseConverter.convert(personDaoService.getAll(requestConverter.convert(request)));
  }

  @Override
  public UpdatePersonResponse update(UpdatePersonRequest request) {
    return responseConverter.convert(personDaoService.update(requestConverter.convert(request)));
  }

  @Override
  public DeletePersonResponse delete(DeletePersonRequest request) {
    return responseConverter.convert(personDaoService.delete(requestConverter.convert(request)));
  }

  @Override
  public DeleteAllPersonResponse deleteAll(DeleteAllPersonRequest request) {
    return responseConverter.convert(personDaoService.deleteAll(requestConverter.convert(request)));
  }

}
