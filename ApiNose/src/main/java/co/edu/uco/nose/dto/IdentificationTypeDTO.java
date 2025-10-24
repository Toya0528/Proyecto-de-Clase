package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class IdentificationTypeDTO {
	
	private UUID id;
	private String name;
	
	public IdentificationTypeDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDTO(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	public static IdentificationTypeDTO getDefaultValue() {
		return new IdentificationTypeDTO();
	}
	
	public static IdentificationTypeDTO getDefaultValue(final IdentificationTypeDTO identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = (id == null) ? UUIDHelper.getUUIDHelper().getDefault() : id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
}