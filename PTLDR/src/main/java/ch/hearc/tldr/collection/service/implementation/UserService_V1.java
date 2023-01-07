
package ch.hearc.tldr.collection.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.tldr.collection.models.TLDR;
import ch.hearc.tldr.collection.models.User;
import ch.hearc.tldr.collection.repository.UserRepository;
import ch.hearc.tldr.collection.service.UserService;

@Service
public class UserService_V1 implements UserService
	{

	@Autowired
	UserRepository userRepository;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void addUserToUser(User user)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void deleteUser(Long id)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public TLDR updateUser(User user)
		{
		// TODO Auto-generated method stub
		return null;
		}
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public Optional<User> getUserByUsername(String username)
		{
		return userRepository.findByUsername(username);
		}

	@Override
	public String getPasswordById(Long id)
		{
		return userRepository.findPasswordById(id);
		}

	@Override
	public TLDR getUserById(Long id)
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public List<TLDR> getAllUsersFromUser()
		{
		// TODO Auto-generated method stub
		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
