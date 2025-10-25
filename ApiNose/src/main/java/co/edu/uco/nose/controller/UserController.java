package co.edu.uco.nose.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/users") 
public class UserController {
	
	@GetMapping
	public ResponseEntity<Response<UserDTO>> findAllUsers() {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			responseObjectData.setData(facade.findAllUsers());
			responseObjectData.addMessage("All users filtered succesfully!");
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER.getContent();
			responseObjectData = Response.createFailedResponse();
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			responseObjectData.addMessage(userMessage);
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PostMapping
	public String registerNewUserInformation(@RequestBody UserDTO user) {
		return "POST: User registered!";
	}
	
	@PutMapping("/{id}")
	public String updateUserInformation(@PathVariable UUID id, @RequestBody UserDTO user) {
		return "UPDATE: User updated!";
	}
	
	@DeleteMapping("/{id}")
	public String dropUserInformation(@PathVariable UUID id) {
		return "DELETE: User deleted!";
	}

}
