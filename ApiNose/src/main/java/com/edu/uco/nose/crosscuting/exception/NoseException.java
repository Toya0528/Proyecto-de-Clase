package com.edu.uco.nose.crosscuting.exception;

import com.edu.uco.nose.crosscuting.helper.ObjectHelper;
import com.edu.uco.nose.crosscuting.helper.TextHelper;

public final class NoseException extends RuntimeException {

	private static final long serialVersionUID = 8309961622596784668L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	private NoseException(final Throwable rootException, final String userMessage, 
				final String technicalMessage) {
		
		setRootException(rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
	}
	
	public static NoseException create(final String UserMessage) {
		return new NoseException(new Exception(), UserMessage, UserMessage);
	}
	
	public static NoseException create(final String UserMessage, 
				final String technicalMessage) {
		return new NoseException(new Exception(), UserMessage, technicalMessage);
	}
	
	public static NoseException create(final Throwable rootException, 
				final String UserMessage, final String technicalMessage) {
		return new NoseException(rootException, UserMessage, technicalMessage);
	}
	
	public Throwable getRootException() {
		return rootException;
	}
	
	private void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
	}
	
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	
	private void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = technicalMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
