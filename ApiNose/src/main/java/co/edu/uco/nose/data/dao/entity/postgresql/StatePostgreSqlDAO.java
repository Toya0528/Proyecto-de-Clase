package co.edu.uco.nose.data.dao.entity.postgresql;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;


public final class StatePostgreSqlDAO extends SqlConnection implements StateDAO {
	
	public StatePostgreSqlDAO(java.sql.Connection connection) {
		super(connection);
	}
	
	@Override
	public List<StateEntity> findAll() {
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		return null;
	}

	@Override
	public StateEntity findById(UUID id) {
		return null;
	}
}
