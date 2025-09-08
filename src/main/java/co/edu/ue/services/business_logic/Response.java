package co.edu.ue.services.business_logic;

public class Response {

	private Object response;
	private Integer status;
	
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Response buildResponse(Object message, int status ) {
		this.setResponse(message);
		this.setStatus(status);
		return this;		
	}
	
	
}
