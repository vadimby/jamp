package by.epam.jamp.module15.persist.service.response;

public abstract class DaoResponse<Body> {
  
  private final DaoResponseStatus responseStatus;
  private final Body responseBody;
  
  public DaoResponse(final DaoResponseStatus responseStatus, final Body responseBody) {
    this.responseStatus = responseStatus;
    this.responseBody = responseBody;
  }
  
  public DaoResponseStatus getResponseStatus() {
    return responseStatus;
  }
  
  public Body getResponseBody() {
    return responseBody;
  }
  
}
