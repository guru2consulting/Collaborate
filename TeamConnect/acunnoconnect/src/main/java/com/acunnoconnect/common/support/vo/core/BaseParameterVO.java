package com.acunnoconnect.common.support.vo.core;

import java.io.Serializable;

public class BaseParameterVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169708170160532899L;
	
	private String responseMessage;
	private boolean reponseStatus;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public boolean isReponseStatus() {
		return reponseStatus;
	}
	public void setReponseStatus(boolean reponseStatus) {
		this.reponseStatus = reponseStatus;
	}
	

}
