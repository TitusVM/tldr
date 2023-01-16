
package ch.hearc.jee.tldr.service.user;

import java.util.List;

import ch.hearc.jee.tldr.entity.User;

public interface UserService
	{

	public void saveUser(User user);

	public User findUserByEmail(String email);

	public List<User> findAllUsers();

	public User findById(Long userId);

	public void save(User user);
	}
