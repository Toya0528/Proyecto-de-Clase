package co.edu.uco.nose.business.assembler.entity.impl;

import org.postgresql.shaded.com.ongres.scram.client.ScramClient.FinalBuildStage;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.assembler.dto.impl.CountryDTOAssembler;
import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.entity.CountryEntity;

public class CountryEntityAssembler implements EntityAssembler<CountryEntityAssembler, CountryDomain>{
	
	private static final EntityAssembler<CountryEntity, CountryDomain> instance = new CountryEntityAssembler();
	
	private CountryEntityAssembler() {
		
	}
	
	public static EntityAssembler<CountryEntity, CountryDomain> getCountryEntityAssembler() {
		return instance;
	}
	
	@Override
	public CountryEntityAssembler toDomain(final CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new CountryDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toEntity(CountryEntityAssembler entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CountryEntity());
		return new CountryDomain(entityTmp.getId(), entityTmp.getName());
	}

}
