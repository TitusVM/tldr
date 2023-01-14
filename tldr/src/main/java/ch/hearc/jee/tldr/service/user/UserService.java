
package ch.hearc.jee.tldr.service.user;

import java.util.List;

import ch.hearc.jee.tldr.dto.UserDto;
import ch.hearc.jee.tldr.entity.User;

public interface UserService
	{

	public void saveUser(UserDto userDto);

	public User findUserByEmail(String email);

	public List<UserDto> findAllUsers();

	public User findById(Long userId);
	}
