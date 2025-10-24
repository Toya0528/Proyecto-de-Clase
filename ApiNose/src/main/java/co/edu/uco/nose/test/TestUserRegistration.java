package co.edu.uco.nose.test;

import java.util.UUID;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.IdentificationTypeDTO;
import co.edu.uco.nose.dto.UserDTO;

public class TestUserRegistration {
	
	public static void main(String[] args) {
		
		System.out.println("SI CORRO");
		
	try {
		var user = new UserDTO();
		
		//Colocar todos los parametros
		
		user.setIdentificationType(new IdentificationTypeDTO(UUID.fromString("44444444-4444-4444-4444-444444444444")));
        user.setIdentificationNumber("1036698451"); //1040 873 589                      
        user.setFirstName("Estefanía");
        user.setMiddleName("María");
        user.setLastName("Tobón");
        user.setSecondLastName("Tobón");
        user.setResidenceCity(new CityDTO(UUID.fromString("33333333-3333-3333-3333-333333333333")));
        user.setEmail("etobon06@gmail.com");
        user.setCellPhoneNumber("3052416497");
        user.setEmailConfirmed(false);
        user.setCellPhoneNumberConfirmed(false);
		
        System.out.println("🧠 UUID del tipo de identificación en DTO: " + user.getIdentificationType().getId());
        System.out.println("🏙️ UUID de la ciudad en DTO: " + user.getResidenceCity().getId());

        
		var facade = new UserFacadeImpl();
		
		facade.registerNewUserInformation(user);
		
		System.out.println("Gané el semestre");
		
		}catch(NoseException e) {
			System.out.println(e.getUserMessage());
			System.out.println(e.getTechnicalMessage());
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		
	}
		
	}

}