package com.edu.uco.nose.dto;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.ObjectHelper;
import com.edu.uco.nose.crosscuting.helper.TextHelper;
import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class StateDTO extends DTO {
	
	private String name;
	private CountryDTO country;
	
	public StateDTO() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryDTO.getDefaultValue());
	}
	
	public StateDTO(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(CountryDTO.getDefaultValue());
	}
	
	public StateDTO(final UUID id, final String name, final CountryDTO country) {
		super(id);
		this.name = name;
		this.country = country;
	}
	
	static StateDTO getDefaultValue() {
		return new StateDTO();
	}
	
	static StateDTO getDefaultValue(final StateDTO state) {
		return ObjectHelper.getDefault(state, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(final CountryDTO country) {
		this.country = ObjectHelper.getDefault(country, CountryDTO.getDefaultValue());
	}
	
}