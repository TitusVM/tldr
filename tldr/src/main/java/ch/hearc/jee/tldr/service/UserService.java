
package ch.hearc.jee.tldr.service;

import java.util.List;

import ch.hearc.jee.tldr.dto.UserDto;
import ch.hearc.jee.tldr.entity.User;

public interface UserService
	{

	void saveUser(UserDto userDto);

	User findUserByEmail(String email);

	List<UserDto> findAllUsers();
	}
