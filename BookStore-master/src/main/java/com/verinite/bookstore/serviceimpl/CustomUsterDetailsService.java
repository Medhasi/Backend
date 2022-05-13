package com.verinite.bookstore.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.repository.RegistrationRepository;

public class CustomUsterDetailsService implements UserDetailsService{
	
	@Autowired
	private RegistrationRepository regRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Registration reg=regRepo.findByUserName1(username);
		CustomUserDetails userDetails=null;
		if(reg!=null)
		{
			userDetails=new CustomUserDetails();
			userDetails.setReg(reg);
		}
		else
		{
			throw new UsernameNotFoundException("user not found");
		}
		return userDetails;
	}

}
