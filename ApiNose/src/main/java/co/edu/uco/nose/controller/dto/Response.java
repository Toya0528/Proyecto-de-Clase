package co.edu.uco.nose.controller.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public final class Response<T> {
	
	private List<String> messages;
	private List<T> data;
	private boolean responseSucceded;
	
	public Response(final boolean responseSucceded) {
		setResponseSucceded(responseSucceded);
		setMessages(new ArrayList<String>());
		setData(new ArrayList<T>());
	}
	
	public Response(final List<String> messages, final List<T> data, 
			final boolean responseSucceded) {
		setMessages(messages);
		setData(data);
		setResponseSucceded(responseSucceded);
	}
	
	public static <T> Response<T> createSuccededResponse() {
		return new Response<>(new ArrayList<String>(), new ArrayList<T>(), true);
	}
	
	public static <T> Response<T> createFailedResponse() {
		return new Response<>(new ArrayList<String>(), new ArrayList<T>(), false);
	}
	
	public static <T> Response<T> createFailedResponse(final List<T> data) {
		return new Response<>(new ArrayList<String>(), data, false);
	}
	
	public static <T> Response<T> createSuccededResponse(final List<T> data) {
		return new Response<>(new ArrayList<String>(), data, true);
	}
	
	public void addMessage(final String message) {
		if (!TextHelper.isEmptyWithTrim(message)) {
		getMessages().add(message);
		}
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public void setMessages(final List<String> messages) {
		this.messages = ObjectHelper.getDefault(messages, new ArrayList<String>());
	}

	public List<T> getData() {
		return data;
	}

	public void setData(final List<T> data) {
		this.data = ObjectHelper.getDefault(data, new ArrayList<T>());
	}

	public boolean isResponseSucceded() {
		return responseSucceded;
	}

	public void setResponseSucceded(final boolean responseSucceded) {
		this.responseSucceded = responseSucceded;
	}

}
