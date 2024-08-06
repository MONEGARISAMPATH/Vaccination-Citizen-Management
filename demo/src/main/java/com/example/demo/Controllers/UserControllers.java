package com.example.demo.Controllers;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Beans.UserDeatilasRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserControllers {
	@GetMapping
public String getuser() {
		return "hasyyjass";
	}
	@PostMapping("/create")
	public  ResponseEntity<Map<String, String>> postUsers( @Valid @RequestBody UserDeatilasRequest request,
			BindingResult bindingResult)  {
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);	
        }
		UserDeatilasRequest  returnvalue=new UserDeatilasRequest();

		returnvalue.setFirstname(request.getFirstname());
		returnvalue.setUserName(request.getUserName());
		returnvalue.setPasword(request.getPasword());
		returnvalue.setEmail(request.getEmail());
		 return returnvalue ;
		
	}

}
