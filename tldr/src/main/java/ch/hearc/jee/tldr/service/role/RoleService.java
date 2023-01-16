
package ch.hearc.jee.tldr.service.role;

import java.util.List;

import ch.hearc.jee.tldr.entity.Role;

public interface RoleService
	{

	public void saveRole(Role role);

	public void deleteRole(Role role);

	public Role findRoleByName(String name);

	public List<Role> findAllRoles();

	public Role findById(Long id);

	}
