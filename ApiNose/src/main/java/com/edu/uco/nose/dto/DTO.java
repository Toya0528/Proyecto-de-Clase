package com.edu.uco.nose.dto;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

class DTO {
	
	private UUID id;
	
	protected DTO(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
}
