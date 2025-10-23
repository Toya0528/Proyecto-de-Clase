package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDTO {
	
	private UUID id;
	private String name;
	private StateDTO state;
	
	public CityDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(StateDTO.getDefaultValue());
	}
	
	public CityDTO(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setState(StateDTO.getDefaultValue());
	}
	
	public CityDTO(final UUID id, final String name, final StateDTO state) {
		setId(id);
		setName(name);
		setState(state);
	}
	
	static CityDTO getDefaultValue() {
		return new CityDTO();
	}
	
	static CityDTO getDefaultValue(final CityDTO city) {
		return ObjectHelper.getDefault(city, getDefaultValue());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
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
