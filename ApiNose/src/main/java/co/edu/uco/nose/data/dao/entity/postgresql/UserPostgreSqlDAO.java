package co.edu.uco.nose.data.dao.entity.postgresql;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;


public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO {
	
	
	protected UserPostgreSqlDAO(java.sql.Connection connection) {
		super(connection);
	}
	
	@Override
	public void create(UserEntity entity) {
 }
	
	@Override
	public List<UserEntity> findAll() {
		return null;
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		return null;
	}

	@Override
	public UserEntity findById(UUID id) {
		return null;
	}

	@Override
	public void update(UserEntity entity) {
		
	}

	@Override
	public void delete(UUID id) {
		
	}
}
