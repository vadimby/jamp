package by.epam.jamp.module15.persist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.jamp.module15.persist.builder.ResponseBuilder;
import by.epam.jamp.module15.persist.model.PersonTable;
import by.epam.jamp.module15.persist.repositories.PersonRepository;
import by.epam.jamp.module15.persist.service.request.CreatePersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.DeleteAllPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.DeletePersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.GetAllPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.GetPersonDaoRequest;
import by.epam.jamp.module15.persist.service.request.UpdatePersonDaoRequest;
import by.epam.jamp.module15.persist.service.response.CreatePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeleteAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.DeletePersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetAllPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.GetPersonDaoResponse;
import by.epam.jamp.module15.persist.service.response.UpdatePersonDaoResponse;

@Service
public class PersonDaoServiceImpl implements PersonDaoService {
  
  @Autowired
  private PersonRepository repository;
  
  @Autowired
  private ResponseBuilder responseBuilder;
  
  @Override
  public CreatePersonDaoResponse create(CreatePersonDaoRequest request) {
    List<PersonTable> findByEmail = repository.findByEmail(request.getEmail());
    if (findByEmail.size() > 0) {
      return responseBuilder.buildCreatePersonDaoConflictResponse();
    }
    
    PersonTable person = new PersonTable();
    person.setName(request.getName());
    person.setSurname(request.getSurname());
    person.setEmail(request.getEmail());
    PersonTable savedEntity = repository.save(person);
    
    return responseBuilder.buildCreatePersonDaoResponse(savedEntity);
  }
  
  @Override
  public GetPersonDaoResponse get(GetPersonDaoRequest request) {
    PersonTable person = repository.findOne(request.getPersonId());
    return responseBuilder.buildGetPersonDaoResponse(person);
  }
  
  @Override
  public GetAllPersonDaoResponse getAll(GetAllPersonDaoRequest request) {
    return responseBuilder.buildGetAllPersonDaoResponse(repository.findAll());
  }
  
  @Override
  public UpdatePersonDaoResponse update(UpdatePersonDaoRequest request) {
    PersonTable newPerson = request.getPerson();
    if (newPerson == null) {
      return responseBuilder.buildUpdatePersonDaoErrorResponse();
    }
    List<PersonTable> findByEmail = repository.findByEmail(newPerson.getEmail());
    if (findByEmail.size() > 0) {
      return responseBuilder.buildUpdatePersonDaoConflictResponse();
    }
    PersonTable originalPerson = repository.findOne(newPerson.getId());
    if (originalPerson == null) {
      return responseBuilder.buildUpdatePersonDaoNotFoundResponse();
    }
    originalPerson.setName(newPerson.getName());
    originalPerson.setSurname(newPerson.getSurname());
    originalPerson.setEmail(newPerson.getEmail());
    PersonTable updatedPerson = repository.save(originalPerson);
    
    return responseBuilder.buildUpdatePersonDaoResponse(updatedPerson);
  }
  
  @Override
  public DeletePersonDaoResponse delete(DeletePersonDaoRequest request) {
    PersonTable originalPerson = repository.findOne(request.getPersonId());
    if (originalPerson == null) {
      return responseBuilder.buildDeletePersonDaoNotFoundResponse();
    }
    repository.delete(request.getPersonId());
    
    return responseBuilder.buildDeletePersonDaoResponse();
  }
  
  @Override
  public DeleteAllPersonDaoResponse deleteAll(DeleteAllPersonDaoRequest request) {
    repository.deleteAll();
    return responseBuilder.buildDeleteAllPersonDaoResponse();
  }
  
}
