package com.edu.uco.nose.dto;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.ObjectHelper;
import com.edu.uco.nose.crosscuting.helper.TextHelper;
import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryDTO extends DTO {

	private String name;


	public CountryDTO() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}

	public CountryDTO(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}

	public CountryDTO(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	static CountryDTO getDefaultValue() {
		return new CountryDTO();
	}
	
	static CountryDTO getDefaultValue(final CountryDTO country) {
		return ObjectHelper.getDefault(country, getDefaultValue());
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
}