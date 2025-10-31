package co.edu.uco.nose.controller;

import java.util.List;
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
			responseObjectData.addMessage("All users filtered succesfully!!");
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> registerNewUserInformation(@RequestBody UserDTO user) {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);
			responseObjectData.addMessage("User registered succesfully!!");
		} catch (final NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch( Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> updateUserInformation(@PathVariable UUID id, @RequestBody UserDTO user) {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			facade.updateUserInformation(id, user);
			responseObjectData.addMessage("User updated sucesfully!!");
		} catch (final NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch( Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}	
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> dropUserInformation(@PathVariable UUID id) {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.dropUserInformation(id);
		responseObjectData.addMessage("User deleted succesfully!!");
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
		}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> findUserById (@PathVariable UUID id) {

		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;

	try {
		var facade = new UserFacadeImpl();
		responseObjectData.setData(List.of(facade.findUserById(id)));
		responseObjectData.addMessage("User filtered by UUID succesfully!!");
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PostMapping("/{filter}")
	public ResponseEntity<Response<UserDTO>> findUserByFilter (@RequestBody UserDTO userFilters) {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		responseObjectData.setData(facade.findUsersByFilter(userFilters));
		responseObjectData.addMessage("Users filtered succesfully");
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
}
