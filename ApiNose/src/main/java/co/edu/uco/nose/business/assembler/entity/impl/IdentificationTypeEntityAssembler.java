package co.edu.uco.nose.business.assembler.entity.impl;

import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public class IdentificationTypeEntityAssembler implements EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain>{
	
	private static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> instance = new IdentificationTypeEntityAssembler();
	
	private IdentificationTypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> getIdentificationTypeEntityAssembler() {
		return instance;
	}

	@Override
	public IdentificationTypeEntity toEntity(IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));

	    // ✅ Validamos que el ID no sea nulo ni el UUID por defecto
	    if (domainTmp.getId() == null || UUIDHelper.getUUIDHelper().isDefaultUUID(domainTmp.getId())) {
	        System.out.println("⚠️ [Assembler] UUID inválido para tipoIdentificación, usando el valor por defecto (4444...)");
	        return new IdentificationTypeEntity(
	            UUID.fromString("44444444-4444-4444-4444-444444444444"),
	            "Cédula de ciudadanía"
	        );
	    }

	    System.out.println("✅ [Assembler] TipoIdentificación que viaja al entity: " + domainTmp.getId());
	    return new IdentificationTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(IdentificationTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new IdentificationTypeEntity());
		return new IdentificationTypeDomain(entityTmp.getId(), entityTmp.getName());
	}

}
