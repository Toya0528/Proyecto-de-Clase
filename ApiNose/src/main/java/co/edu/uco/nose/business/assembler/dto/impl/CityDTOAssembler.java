package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.dto.CityDTO;

public final class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {
	
	private static final DTOAssembler<CityDTO, CityDomain> instance = new CityDTOAssembler();
	private CityDTOAssembler() {
		
	}
	
	public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler() {
		return instance;
	}

	@Override
	public CityDTO toDTO(final CityDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain toDomain(final CityDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDTO> toDTO(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
