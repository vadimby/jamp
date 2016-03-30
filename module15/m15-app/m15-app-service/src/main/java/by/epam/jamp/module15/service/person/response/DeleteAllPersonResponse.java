package by.epam.jamp.module15.service.person.response;

import java.util.List;

public class DeleteAllPersonResponse {
  
  private List<Long> removedIds;
  
  public List<Long> getRemovedIds() {
    return removedIds;
  }
  
  public void setRemovedIds(List<Long> removedIds) {
    this.removedIds = removedIds;
  }
  
}
