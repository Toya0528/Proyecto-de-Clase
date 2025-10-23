package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;

public class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain>{
	
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
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());

	    var identificationTypeDomainTmp = IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler()
	            .toDomain(dtoTmp.getIdentificationType());
	    var cityDomainTmp = CityDTOAssembler.getCityDTOAssembler()
	            .toDomain(dtoTmp.getResidenceCity());

	    // 🧩 Debug: verificar que los UUID vengan desde el DTO
	    System.out.println("🎯 [DTOAssembler] TipoID desde DTO: " +
	            (dtoTmp.getIdentificationType() != null ? dtoTmp.getIdentificationType().getId() : "NULO"));
	    System.out.println("🎯 [DTOAssembler] Ciudad desde DTO: " +
	            (dtoTmp.getResidenceCity() != null ? dtoTmp.getResidenceCity().getId() : "NULO"));

	    return new UserDomain(
	            dtoTmp.getId(),
	            identificationTypeDomainTmp,
	            dtoTmp.getIdentificationNumber(),
	            dtoTmp.getFirstName(),
	            dtoTmp.getMiddleName(),
	            dtoTmp.getLastName(),
	            dtoTmp.getSecondLastName(),
	            cityDomainTmp,
	            dtoTmp.getEmail(),
	            dtoTmp.getCellPhoneNumber(),
	            dtoTmp.isEmailConfirmed(),
	            dtoTmp.isCellPhoneNumberConfirmed()
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
