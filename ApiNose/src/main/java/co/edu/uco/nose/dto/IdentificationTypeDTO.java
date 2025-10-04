package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class IdentificationTypeDTO extends DTO {
	
	private String name;
	
	public IdentificationTypeDTO() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDTO(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeDTO(final UUID id, final String name) {
		super(id);
		this.name = name;
	}
	
	static IdentificationTypeDTO getDefaultValue() {
		return new IdentificationTypeDTO();
	}
	
	static IdentificationTypeDTO getDefaultValue(final IdentificationTypeDTO identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
}