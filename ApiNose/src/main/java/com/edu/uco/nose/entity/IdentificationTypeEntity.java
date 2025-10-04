package com.edu.uco.nose.entity;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.ObjectHelper;
import com.edu.uco.nose.crosscuting.helper.TextHelper;
import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class IdentificationTypeEntity extends Entity {
	
	private String name;
	
	public IdentificationTypeEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeEntity(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeEntity(final UUID id, final String name) {
		super(id);
		this.name = name;
	}
	
	static IdentificationTypeEntity getDefaultValue() {
		return new IdentificationTypeEntity();
	}
	
	static IdentificationTypeEntity getDefaultValue(final IdentificationTypeEntity identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
}