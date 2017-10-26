package org.shub.archetypes.messenger.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documentations;
	
	public ErrorMessage(){
		
	}
	
	public ErrorMessage(String errorMessage,int errorCode,String documentations){
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentations = documentations;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentations() {
		return documentations;
	}
	public void setDocumentations(String documentations) {
		this.documentations = documentations;
	}
	
	
}
