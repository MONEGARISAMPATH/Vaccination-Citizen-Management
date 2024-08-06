package com.project1.UserService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.UserService.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

	List<User> findByName(User user_name);

	//List<User> findByName(String user_name);

}
