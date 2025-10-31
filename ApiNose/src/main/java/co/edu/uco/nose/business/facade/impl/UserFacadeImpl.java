package co.edu.uco.nose.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade{
	
	@Override
	public void registerNewUserInformation(final UserDTO userDto) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			
			business.registerNewUserInformation(domain);
			
			daoFactory.commitTransaction();	
			
		} catch (NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
			
		} catch (Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER.getContent();
			
			throw NoseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformation(final UUID id) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			business.dropUserInformation(id);
			daoFactory.commitTransaction();
		} catch (final NoseException exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_DELETING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_DELETING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);	
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDTO userDto) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			business.updateUserInformation(	id, userDomain);
			daoFactory.commitTransaction();
			
		} catch (final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var userDomainList = business.findAllUsers();
			daoFactory.commitTransaction();
			return UserDTOAssembler.getUserDTOAssembler().toDTO(userDomainList);
			
		} catch (final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<UserDTO> findUsersByFilter(final UserDTO userFilters) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userFilters);
			return UserDTOAssembler.getUserDTOAssembler().toDTO(business.findUsersByFilter(userDomain));
		} catch (final NoseException exception) {
			throw exception;
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public UserDTO findUserById(final UUID id) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			var userDomain = business.findUserById(id);
			return UserDTOAssembler.getUserDTOAssembler().toDTO(userDomain);	
		} catch (final NoseException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void confirmMobileNumber(final UUID id, final int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(final UUID id, final int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}

}
