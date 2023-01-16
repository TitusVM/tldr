
package ch.hearc.jee.tldr.service.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.jee.tldr.entity.Role;
import ch.hearc.jee.tldr.repository.RoleRepository;
import ch.hearc.jee.tldr.service.role.RoleService;

@Service
public class RoleServiceImpl implements RoleService
	{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveRole(Role role)
		{
		roleRepository.save(role);
		}

	@Override
	public void deleteRole(Role role)
		{
		roleRepository.delete(role);
		}

	@Override
	public Role findRoleByName(String name)
		{
		return roleRepository.findByName(name);
		}

	@Override
	public List<Role> findAllRoles()
		{
		return roleRepository.findAll();
		}

	@Override
	public Role findById(Long id)
		{
		return roleRepository.findById(id).get();
		}
	}
