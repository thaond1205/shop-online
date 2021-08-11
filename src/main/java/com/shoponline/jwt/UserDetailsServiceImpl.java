package com.shoponline.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoponline.reposiitories.AccountRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new User("admin","123", new ArrayList<>());
	}

}
