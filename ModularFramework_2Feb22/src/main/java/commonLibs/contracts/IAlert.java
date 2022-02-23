package commonLibs.contracts;

public interface IAlert {
	
	public void acceptAlert() throws Exception;
	
	public void dismissRejectAlert() throws Exception;
	
	public String getMessageFromAlert() throws Exception;
	
	public boolean checkIfAlertIsPresent(int timeout) throws Exception;
	

}
