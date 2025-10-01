package com.edu.uco.nose.business.domain;

import java.util.UUID;

import com.edu.uco.nose.crosscuting.helper.UUIDHelper;

class Domain {
	
	private UUID id;
	
	protected Domain(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
}
