package by.epam.jamp.module8.task2.v2;

public class Status {

	private Status status;
	private boolean flag;
	
	public boolean getStatus(){
		if (status == null) {
			return flag;
		}
		return status.getStatus();
	}
}
