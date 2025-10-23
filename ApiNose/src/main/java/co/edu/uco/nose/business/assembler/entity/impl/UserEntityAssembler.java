package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain>{
	
	private static final EntityAssembler<UserEntity, UserDomain> instance = new UserEntityAssembler();
    private UserEntityAssembler() {

    }

    public static EntityAssembler <UserEntity,UserDomain> getUserEntityAssembler(){
        return instance;

    }

	@Override
	public UserEntity toEntity(UserDomain domain) {
		// ✅ No crear un nuevo UserDomain si ya viene uno válido
		if (domain == null) {
		    return new UserEntity();
		}

	    var identificationTypeTmp = IdentificationTypeEntityAssembler
	            .getIdentificationTypeEntityAssembler()
	            .toEntity(domain.getIdentificationType());

	    var cityTmp = CityEntityAssembler
	            .getCityEntityAssembler()
	            .toEntity(domain.getResidenceCity());

	    // 🧩 Debug: verificar IDs en cascada
	    System.out.println("🧩 [Assembler] ID recibido en el dominio: " + domain.getId());
	    System.out.println("🧾 [Assembler] ID del tipo de identificación: " +
	            (domain.getIdentificationType() != null ? domain.getIdentificationType().getId() : "NULO"));
	    System.out.println("🏙️ [Assembler] ID de la ciudad de residencia: " +
	            (domain.getResidenceCity() != null ? domain.getResidenceCity().getId() : "NULO"));

	    return new UserEntity(
	            domain.getId(),
	            identificationTypeTmp,
	            domain.getIdentificationNumber(),
	            domain.getFirstName(),
	            domain.getMiddleName(),
	            domain.getLastName(),
	            domain.getSecondLastName(),
	            cityTmp,
	            domain.getEmail(),
	            domain.getCellPhoneNumber(),
	            domain.isEmailConfirmed(),
	            domain.isCellPhoneNumberConfirmed()
	    );

	}

	@Override
	public UserDomain toDomain(UserEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new UserEntity());
		var identificationTypeDomainTmp = IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler().toDomain(entityTmp.getIdentificationType());
		var cityDomainTmp = CityEntityAssembler.getCityEntityAssembler().toDomain(entityTmp.getResidenceCity());
		return new UserDomain(entityTmp.getId(), identificationTypeDomainTmp, entityTmp.getIdentificationNumber(),
				entityTmp.getFirstName(), entityTmp.getMiddleName(), entityTmp.getLastName(),
				entityTmp.getSecondLastName(), cityDomainTmp, entityTmp.getEmail(), entityTmp.getCellPhoneNumber(),
				entityTmp.isEmailConfirmed(), entityTmp.isCellPhoneNumberConfirmed());
	}

}
