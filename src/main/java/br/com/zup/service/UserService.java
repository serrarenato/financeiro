package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.ApplicationUser;

public interface UserService {

	List<ApplicationUser> getUsers();

	void postUser(ApplicationUser user);

	public ApplicationUser getUserbyID(long id);

}
