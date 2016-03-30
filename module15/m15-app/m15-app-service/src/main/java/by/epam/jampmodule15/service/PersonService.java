package by.epam.jampmodule15.service;

import java.util.List;

import by.epam.jampmodule15.domain.Person;
import by.epam.jampmodule15.service.request.CreatePersonRequest;
import by.epam.jampmodule15.service.request.DeleteAllPersonRequest;
import by.epam.jampmodule15.service.request.DeletePersonRequest;
import by.epam.jampmodule15.service.request.GetAllPersonRequest;
import by.epam.jampmodule15.service.request.GetPersonRequest;
import by.epam.jampmodule15.service.request.UpdatePersonRequest;
import by.epam.jampmodule15.service.response.CreatePersonResponse;
import by.epam.jampmodule15.service.response.DeleteAllPersonResponse;
import by.epam.jampmodule15.service.response.DeletePersonResponse;
import by.epam.jampmodule15.service.response.GetAllPersonResponse;
import by.epam.jampmodule15.service.response.GetPersonResponse;
import by.epam.jampmodule15.service.response.UpdatePersonResponse;

public interface PersonService {
  
  CreatePersonResponse create(CreatePersonRequest request);

  GetPersonResponse get(GetPersonRequest request);

  GetAllPersonResponse getAll(GetAllPersonRequest request);

  UpdatePersonResponse update(UpdatePersonRequest request);

  DeletePersonResponse delete(DeletePersonRequest request);

  DeleteAllPersonResponse deleteAll(DeleteAllPersonRequest request);

}
