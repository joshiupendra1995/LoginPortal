package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.bean.User;
import com.login.dao.UserRepository;
import com.login.util.EmailUtil;
import com.login.util.EncryptionUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private EncryptionUtil encryptionUtil;

	/**
	 * Register user.
	 *
	 * @param user the user
	 * @return the user
	 * @throws Exception
	 */
	public User registerUser(User user) throws Exception {
		String encryptedPass = String.valueOf(encryptionUtil.encryptData(user.getPassword()));
		user.setPassword(encryptedPass);
		return userRepository.save(user);
	}

	/**
	 * Find all users.
	 *
	 * @return the list
	 */
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User verifyUser(String username, String password) throws Exception {

		Optional<User> user = userRepository.findByEmailId(username);
		if (user.isPresent()) {
			String otp = emailUtil.triggerMail(username, password);
			user.get().setOtp(otp);
			userRepository.save(user.get());
			return user.get();

		} else {
			throw new Exception("User not found");
		}

	}

	public boolean validateUser(String username, String password, String otp) throws Exception {

		Optional<User> user = userRepository.findByEmailIdAndPassword(username, password);
		if (user.isPresent()) {
			if (user.get().getOtp().equalsIgnoreCase(otp)) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} else {
			throw new Exception("Invalid otp");
		}
	}

	/**
	 * Delete user.
	 *
	 * @param emailId the email id
	 */
	public void deleteUser(String emailId) {
		userRepository.deleteById(emailId);
	}

}
