package com.server.service;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.server.entity.Customer;
import com.server.entity.User;

public interface UserService {

	void register(Customer customer) throws Exception;

	void register(User user) throws Exception;

	List<String> login(String email, String password);

	boolean isUserPresent(String email);
	
	Customer getCustomerById(int id);
	
	User findByResetToken(String resetToken);
	
	User getUserByEmailandPassword(String email, String password);
	
	void addOrUpdateUser(User user);
	
	User getUserByResetToken(String token);
	
	User getUserByEmail(String email);

	public static String getHashedString(String text) {
		try {
			text = Base64.getEncoder().encodeToString(text.getBytes());

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());

			byte[] digest = md.digest();
			text = DatatypeConverter.printHexBinary(digest).toUpperCase();

			return text;

		} catch (Exception e) {
			return Base64.getEncoder().encodeToString(text.getBytes());
		}
	}

}