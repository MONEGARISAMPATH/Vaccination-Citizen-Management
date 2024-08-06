package com.project1.UserService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.UserService.Entity.AddResponse;
import com.project1.UserService.Entity.User;
import com.project1.UserService.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRep;
	public ResponseEntity<List<User>> getAllUsers() {
		try {
		List<User> us= userRep.findAll();
		return new ResponseEntity<>(us,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	
	public ResponseEntity<List<User>> getUserByName(User user_name) {
		//we can create two ways case:1
		try {
		List<User> us1=userRep.findByName(user_name);
		return new ResponseEntity<>(us1,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
		//case:2
		/*
		 * try { List<User> name1=userRep.findAll(); 
		 * User username=null; 
		 * for(User u:name1) 
		 * if(u.getName().equalsIgnoreCase(name)) 
		 * username=u; 
		 * return new ResponseEntity<>(name1,HttpStatus.OK);
		 *  }catch(Exception e) {
		 * System.out.println(e.getMessage()); } 
		 * return new ResponseEntity<>(HttpStatus.CONFLICT); }
		 */
	
		public ResponseEntity<User> getbyId(int id) {
		try {
	User id1=userRep.findById(id).get();
	return new ResponseEntity<>(id1,HttpStatus.OK);
	}catch(Exception e) {
			e.printStackTrace();	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		
	public ResponseEntity<User> createUser(User user) {
		try {
		User user1= userRep.save(user);
		 return new ResponseEntity<>(user1,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<User> updateUser(User user) {
		try {
		User us1=userRep.save(user);	
		return new ResponseEntity<>(us1,HttpStatus.OK);
		}catch(Exception e) {
      e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}

	public ResponseEntity<AddResponse> deleteUser(int id) {
		try {
		userRep.deleteById(id);
		AddResponse ad=new AddResponse();
		ad.setId(id);
		ad.setMsg("user deleted");
		return new ResponseEntity<>(ad,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
}
