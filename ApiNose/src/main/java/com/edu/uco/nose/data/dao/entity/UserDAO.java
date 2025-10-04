package com.edu.uco.nose.data.dao.entity;

import java.util.UUID;

import com.edu.uco.nose.data.dao.DeleteDAO;
import com.edu.uco.nose.data.dao.RetrieveDAO;
import com.edu.uco.nose.data.dao.UpdateDAO;
import com.edu.uco.nose.entity.UserEntity;
import com.edu.uco.nose.data.dao.CreateDAO;

public interface UserDAO 
		extends CreateDAO<UserEntity>, RetrieveDAO<UserEntity, UUID>, 
			UpdateDAO<UserEntity>, DeleteDAO<UUID> {

}
