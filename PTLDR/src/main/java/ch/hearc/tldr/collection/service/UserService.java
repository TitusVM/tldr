
package ch.hearc.tldr.collection.service;

import java.util.List;
import java.util.Optional;

import ch.hearc.tldr.collection.models.TLDR;
import ch.hearc.tldr.collection.models.User;

public interface UserService
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public TLDR getUserById(Long id);

	public Optional<User> getUserByUsername(String username);

	public String getPasswordById(Long id);

	public void addUserToUser(User user);

	public List<TLDR> getAllUsersFromUser();

	public void deleteUser(Long id);

	public TLDR updateUser(User user);

	}
