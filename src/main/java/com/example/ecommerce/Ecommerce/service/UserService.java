
package com.example.ecommerce.Ecommerce.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Ecommerce.model.UserInfo;
import com.example.ecommerce.Ecommerce.repository.UserInfoRepository; 


@Service 
public class UserService implements UserDetailsService {

	@Autowired 
	private UserInfoRepository userRepository;

	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		UserInfo user = userRepository.findByUsername(username) .orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()); 
	}
	
	public void saveUser(UserInfo user) {
		userRepository.save(user);
	}

	
	public boolean isUserAlreadyPresent(UserInfo user) {
		Optional<UserInfo> obj = userRepository.findByUsername(user.getUsername()) ;
		if(obj.isPresent()) {
			return true;
		}
		return false;
	}
	
}

