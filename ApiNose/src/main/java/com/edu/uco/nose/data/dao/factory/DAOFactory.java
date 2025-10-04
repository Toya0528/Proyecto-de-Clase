package com.edu.uco.nose.data.dao.factory;

import java.sql.Connection;

import com.edu.uco.nose.data.dao.entity.CityDAO;
import com.edu.uco.nose.data.dao.entity.CountryDAO;
import com.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import com.edu.uco.nose.data.dao.entity.StateDAO;
import com.edu.uco.nose.data.dao.entity.UserDAO;

public abstract class DAOFactory {
	
	protected Connection connection;
	protected FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory() {
		return null;
	}
	
	public abstract CityDAO getCityDAO();
	public abstract CountryDAO getCountryDAO();
	public abstract IdentificationTypeDAO getIdTypeDAO();
	public abstract StateDAO getStateDAO();
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initTransaction() {
	
	}
	
	protected final void commitTransaction() {
		
	}
	
	protected final void rollbackTransaction() {
		
	}
	
	protected final void closeConnection() {
		
	}
	
}
