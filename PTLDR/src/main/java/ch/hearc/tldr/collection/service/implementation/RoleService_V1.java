
package ch.hearc.tldr.collection.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ch.hearc.tldr.collection.models.Role;
import ch.hearc.tldr.collection.repository.RoleRepository;
import ch.hearc.tldr.collection.service.RoleService;

public class RoleService_V1 implements RoleService
	{

	/*------------------------------------------------------------------*\
	|*							 Annotations							*|
	\*------------------------------------------------------------------*/

	@Autowired
	RoleRepository roleRepository;

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void addRoleToCollection(Role role)
		{

		}

	@Override
	public List<Role> getAllRolesFromCollection()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public void deleteRole(Long id)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public Role updateRole(Role role)
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public Role getRoleById(Long id)
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public Role getRoleByName(String string)
		{
		// TODO Auto-generated method stub
		return null;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
