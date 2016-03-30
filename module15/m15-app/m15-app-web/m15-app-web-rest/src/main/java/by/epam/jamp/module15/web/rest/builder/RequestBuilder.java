package by.epam.jamp.module15.web.rest.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.epam.jamp.module15.service.person.request.CreatePersonRequest;
import by.epam.jamp.module15.service.person.request.DeleteAllPersonRequest;
import by.epam.jamp.module15.service.person.request.DeletePersonRequest;
import by.epam.jamp.module15.service.person.request.GetAllPersonRequest;
import by.epam.jamp.module15.service.person.request.GetPersonRequest;
import by.epam.jamp.module15.service.person.request.UpdatePersonRequest;
import by.epam.jamp.module15.web.rest.converter.PersonConverter;
import by.epam.jamp.module15.web.rest.model.PersonDto;

@Component
public class RequestBuilder {
	
	@Autowired
	private PersonConverter personConverter;
  
  public GetAllPersonRequest buildGetAllPersonsRequest() {
    return new GetAllPersonRequest();
  }
  
  public GetPersonRequest buildGetPersonRequest(Long id) {
    GetPersonRequest request = new GetPersonRequest();
    request.setPersonId(id);
    return request;
  }
  
  public CreatePersonRequest buildCreatePersonRequest(PersonDto person) {
    CreatePersonRequest request = new CreatePersonRequest();
    request.setName(person.getName());
    request.setSurname(person.getSurname());
    request.setEmail(person.getEmail());
    return request;
  }
  
  public UpdatePersonRequest buildUpdatePersonRequest(PersonDto person) {
    UpdatePersonRequest request = new UpdatePersonRequest();
    request.setPerson(personConverter.convert(person));
    return request;
  }
  
  public DeletePersonRequest buildDeletePersonRequest(Long personId) {
    DeletePersonRequest request = new DeletePersonRequest();
    request.setPersonId(personId);
    return request;
  }
  
  public DeleteAllPersonRequest buildDeleteAllPersonRequest() {
    DeleteAllPersonRequest request = new DeleteAllPersonRequest();
    return request;
  }
}
