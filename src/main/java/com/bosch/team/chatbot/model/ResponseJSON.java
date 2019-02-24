package com.bosch.team.chatbot.model;

public class ResponseJSON {
	
	private String  ententy;
	private String  response;
	
	public String getEntenty() {
		return ententy;
	}
	public void setEntenty(String ententy) {
		this.ententy = ententy;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
	    // TODO Auto-generated method stub
	    if(obj instanceof ResponseJSON)
	    {
	        ResponseJSON temp = (ResponseJSON) obj;
	        if(this.ententy.equals(temp.ententy) && this.response.equals(temp.response))
	            return true;
	    }
	    return false;

	}
	@Override
	public int hashCode() {
	    // TODO Auto-generated method stub

	    return (this.ententy.hashCode() + this.response.hashCode());        
	}

}
