package by.epam.jamp.module15.persist.service;

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

public interface PersonDaoService {

  CreatePersonDaoResponse create(CreatePersonDaoRequest request);
  
  GetPersonDaoResponse get(GetPersonDaoRequest request);
  
  GetAllPersonDaoResponse getAll(GetAllPersonDaoRequest request);
  
  UpdatePersonDaoResponse update(UpdatePersonDaoRequest request);
  
  DeletePersonDaoResponse delete(DeletePersonDaoRequest request);
  
  DeleteAllPersonDaoResponse deleteAll(DeleteAllPersonDaoRequest request);
  
}
