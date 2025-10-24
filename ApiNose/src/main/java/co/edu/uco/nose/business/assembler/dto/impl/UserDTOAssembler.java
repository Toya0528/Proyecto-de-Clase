package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain>{
	
	private static final DTOAssembler<UserDTO, UserDomain> instance = new UserDTOAssembler();
	
	private UserDTOAssembler() {
		
	}
	
	public static DTOAssembler<UserDTO, UserDomain> getUserDTOAssembler() {
		return instance;
	}
	
	@Override
	public UserDTO toDTO(final UserDomain domain) {
		 var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
	     var identificationTypeTmp = IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler()
	                .toDTO(domainTmp.getIdentificationType());
	     var cityTmp = CityDTOAssembler.getCityDTOAssembler().toDTO(domainTmp.getResidenceCity());

		return new UserDTO(domainTmp.getId(), identificationTypeTmp, domainTmp.getIdentificationNumber(), 
				domainTmp.getFirstName(), domainTmp.getMiddleName(), domainTmp.getLastName(), 
				domainTmp.getSecondLastName(), cityTmp, domainTmp.getEmail(), 
				domainTmp.getCellPhoneNumber(), domainTmp.isEmailConfirmed(), domainTmp.isCellPhoneNumberConfirmed());
	}

	@Override
	public UserDomain toDomain(final UserDTO dto) {
		if (dto == null) {
	        return new UserDomain(UUIDHelper.getUUIDHelper().getDefault());
	    }
		
		var identificationTypeDomainTmp = IdentificationTypeDTOAssembler
	            .getIdentificationTypeDTOAssembler()
	            .toDomain(dto.getIdentificationType());
	    var cityDomainTmp = CityDTOAssembler
	            .getCityDTOAssembler()
	            .toDomain(dto.getResidenceCity());

	    return new UserDomain(
	            dto.getId(),
	            identificationTypeDomainTmp,
	            dto.getIdentificationNumber(),
	            dto.getFirstName(),
	            dto.getMiddleName(),
	            dto.getLastName(),
	            dto.getSecondLastName(),
	            cityDomainTmp,
	            dto.getEmail(),
	            dto.getCellPhoneNumber(),
	            dto.isEmailConfirmed(),
	            dto.isCellPhoneNumberConfirmed()
	    );
	}

	@Override
	public List<UserDTO> toDTO(final List<UserDomain> domainList) {
		var userDtoList = new ArrayList<UserDTO>();
		
		for (var userDomain : domainList) {
			userDtoList.add(toDTO(userDomain));
		}
		
		return userDtoList;
	}

}
