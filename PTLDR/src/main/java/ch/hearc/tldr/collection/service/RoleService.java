
package ch.hearc.tldr.collection.service;

import java.util.List;

import ch.hearc.tldr.collection.models.Role;

public interface RoleService
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addRoleToCollection(Role role);

	public List<Role> getAllRolesFromCollection();

	public void deleteRole(Long id);

	public Role updateRole(Role role);

	public Role getRoleById(Long id);

	public Role getRoleByName(String string);

	}
