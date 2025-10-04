package com.edu.uco.nose.dto;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.ObjectHelper;
import com.edu.uco.nose.crosscuting.helper.TextHelper;
import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class CityDTO extends DTO{
	
	private String name;
	private StateDTO state;
	
	public CityDTO() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(StateDTO.getDefaultValue());
	}
	
	public CityDTO(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setState(StateDTO.getDefaultValue());
	}
	
	public CityDTO(final UUID id, final String name, final StateDTO state) {
		super(id);
		this.name = name;
		this.state = state;
	}
	
	static CityDTO getDefaultValue() {
		return new CityDTO();
	}
	
	static CityDTO getDefaultValue(final CityDTO city) {
		return ObjectHelper.getDefault(city, getDefaultValue());
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public StateDTO getState() {
		return state;
	}
	
	public void setState(final StateDTO state) {
		this.state = ObjectHelper.getDefault(state, StateDTO.getDefaultValue());
	}

}
