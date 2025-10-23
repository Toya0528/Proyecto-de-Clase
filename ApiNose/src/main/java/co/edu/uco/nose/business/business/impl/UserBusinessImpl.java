package co.edu.uco.nose.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.entity.UserEntity;

public final class UserBusinessImpl implements UserBusiness{
	
	private DAOFactory daoFactory;

	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
		
		//1. Validar que la informacion sea consistente a nivel de tipo de dato, longitud, oblatoriedad
		//2. Validar que no exista otro usuario con el mismo tipo y número de documento
		//3. Validar que no exista previamente un usuario con el mismo email
		//4. Validar que no exista previamente un usuario con el mismo número de teléfono celular
		//5. Generar un identificador para el nuevo usuario, asegurando de que no exista previamente
		
		
		// 🟦 Paso 1: inicio del proceso
	    System.out.println("=== [Paso 1] Iniciando registro de usuario ===");

	    // 🟦 Validación de datos básicos
	    System.out.println("=== [Paso 2] Validando datos básicos ===");
		validateUserData(userDomain);
		// 🟦 Validación de duplicados
	    System.out.println("=== [Paso 3] Validando duplicados ===");
		validateDuplicatedUser(userDomain);
		
		// 🟦 Generando ID único
	    System.out.println("=== [Paso 4] Generando nuevo UUID ===");
		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		userDomain.setId(id);
		System.out.println("🧠 ID asignado al dominio antes de ensamblar: " + userDomain.getId());
		
		// Validar una sola vez por seguridad (sin while)
		System.out.println("=== [Paso 4.1] Verificando si el UUID ya existe ===");
		var existingUser = daoFactory.getUserDAO().findById(id);
		
		if (!UUIDHelper.getUUIDHelper().isDefaultUUID(existingUser.getId())) {
		    System.out.println("UUID duplicado detectado. Generando otro...");
		    id = UUIDHelper.getUUIDHelper().generateNewUUID();
		}

		System.out.println("=== [Paso 4.2] UUID confirmado como único: " + id + " ===");
		
		// 🟦 Ensamblando entidad
	    System.out.println("=== [Paso 5] Ensamblando entidad de usuario ===");
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		// 🟦 Verifica por consola
		System.out.println("🧩 ID que viaja a BD: " + userEntity.getId());
		
		// 🟦 Creando usuario en BD
	    System.out.println("=== [Paso 6] Ejecutando inserción en BD ===");
		userEntity.setId(id);
		
		daoFactory.getUserDAO().create(userEntity);
		
		// 🟦 Fin del proceso
	    System.out.println("=== [Paso 7] Usuario registrado exitosamente ===");
		
	}
	
	private void validateUserData (final UserDomain userDomain) {
		if(ObjectHelper.isNull(userDomain)) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_USER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(ObjectHelper.isNull(userDomain.getIdentificationType())) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_IDENTIFICATION_TYPE.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if(ObjectHelper.isNull(userDomain.getResidenceCity())) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_NULL_CITY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_NULL_CITY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getIdentificationNumber()) || 
				userDomain.getIdentificationNumber().length() > 25) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_IDENTIFICATION_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getFirstName()) || 
				userDomain.getFirstName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_FIRST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getMiddleName()) || 
				userDomain.getMiddleName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_MIDDLE_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getLastName()) || 
				userDomain.getLastName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_LAST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_lAST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (TextHelper.isEmptyWithTrim(userDomain.getSecondLastName()) || 
				userDomain.getSecondLastName().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_LAST_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_SECOND_lAST_NAME.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (!TextHelper.isValidEmail(userDomain.getEmail()) || 
				userDomain.getEmail().length() > 250) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		if (!TextHelper.isValidPhoneNumber(userDomain.getCellPhoneNumber()) || 
				userDomain.getCellPhoneNumber().length() > 20) {
			var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_INVALID_CELL_PHONE_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		
	}
	
	private void validateDuplicatedUser(UserDomain userDomain) {

	    var userEntityFilter = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);


	    var userDAO = daoFactory.getUserDAO();

	    var filterByIdentification = new UserEntity();
	    filterByIdentification.setIdentificationType(userEntityFilter.getIdentificationType());
	    filterByIdentification.setIdentificationNumber(userEntityFilter.getIdentificationNumber());

	    var existingById = userDAO.findByFilter(filterByIdentification);
	    if (!existingById.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_IDENTIFICATION.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByEmail = new UserEntity();
	    filterByEmail.setEmail(userEntityFilter.getEmail());

	    var existingByEmail = userDAO.findByFilter(filterByEmail);
	    if (!existingByEmail.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }

	    var filterByPhone = new UserEntity();
	    filterByPhone.setCellPhoneNumber(userEntityFilter.getCellPhoneNumber());

	    var existingByPhone = userDAO.findByFilter(filterByPhone);
	    if (!existingByPhone.isEmpty()) {
	    	var userMessage = MessagesEnum.USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_CELL_PHONE_NUMBER.getContent();
			throw NoseException.create(userMessage, technicalMessage);
	    }
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDomain userDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDomain> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDomain> findUsersByFilter(UserDomain userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDomain findSpecificUser(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmMobileNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
