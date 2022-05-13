package com.verinite.bookstore.serviceimpl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.verinite.bookstore.entity.Registration;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomUserDetails implements UserDetails{

	private Registration reg; 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		GrantedAuthority authority = new SimpleGrantedAuthority(reg.getUserRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return reg.getPassword();
	}

	@Override
	public String getUsername() {
		return  reg.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
