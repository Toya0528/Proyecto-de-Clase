package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;

public class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {
	
	private static final EntityAssembler<CityEntity, CityDomain> instance = new CityEntityAssembler();
	private CityEntityAssembler() {
		
	}
	
	public static EntityAssembler<CityEntity, CityDomain> getCityEntityAssembler() {
		return instance;
	}

	@Override
	public CityEntity toEntity(CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		if (UUIDHelper.getUUIDHelper().isDefaultUUID(domainTmp.getId())) {
	        return null;
	    }
		var stateTmp = StateEntityAssembler.getStateEntityAssembler().toEntity(domainTmp.getState());
        return new CityEntity(domainTmp.getId(), domainTmp.getName(), stateTmp);
	}

	@Override
	public CityDomain toDomain(CityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CityEntity());
        var stateDomainTmp = StateEntityAssembler.getStateEntityAssembler().toDomain(entityTmp.getState());
        return new CityDomain(entityTmp.getId(), entityTmp.getName(), stateDomainTmp);
	}

}
