package com.mcexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tusuarios;
import com.mcexpress.repositories.TusuariosRepository;
import com.mcexpress.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private TusuariosRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Tusuarios user = repo.findByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(user.getCODUSUARIO(), user.getLogin(), user.getSENHAJAVA(), user.getPerfis());
	}

}
