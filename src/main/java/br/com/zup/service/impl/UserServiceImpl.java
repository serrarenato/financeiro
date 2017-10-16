package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.ApplicationUser;
import br.com.zup.repository.ApplicationUserRepository;
import br.com.zup.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ApplicationUserRepository userRepository;

	@Override
	public List<ApplicationUser> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void postUser(ApplicationUser user) {
		userRepository.save(user);

	}

	@Override
	public ApplicationUser getUserbyID(long id) {
		return userRepository.findOne(id);
	}

}
