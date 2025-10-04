package com.edu.uco.nose.data.dao.entity.postgresql;

import java.util.List;
import java.util.UUID;
import java.sql.Connection;

import com.edu.uco.nose.data.dao.entity.CityDAO;
import com.edu.uco.nose.data.dao.entity.SqlConnection;
import com.edu.uco.nose.entity.CityEntity;

public final class CityPostgreSqlDAO extends SqlConnection implements CityDAO {
	
	

	protected CityPostgreSqlDAO(Connection connection) {
		super(connection);
	}


	@Override
	public List<CityEntity> findAll() {
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		return null;
	}

}
