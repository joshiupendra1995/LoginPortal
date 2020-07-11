package com.login.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	Optional<User> findByEmailIdAndPassword(String username, String password);

	Optional<User> findByEmailId(String username);

}
