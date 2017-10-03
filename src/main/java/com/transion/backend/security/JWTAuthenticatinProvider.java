package com.transion.backend.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.transion.backend.model.User;
import com.transion.backend.service.UserService;

import javassist.NotFoundException;

@Component
public class JWTAuthenticatinProvider implements AuthenticationProvider{
	
	private final BCryptPasswordEncoder encoder;

	@Autowired
	UserService userService;
	
	@Autowired
    public JWTAuthenticatinProvider(final BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        
        User user = userService.findByUsername(username);
        
        if(user == null)
			try {
				throw new NotFoundException("User not found.");
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        List<GrantedAuthority> authorities = user.getRoles().stream()
        		.map(authority -> new SimpleGrantedAuthority(authority.getRole()))
        		.collect(Collectors.toList());
        
      
        
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
