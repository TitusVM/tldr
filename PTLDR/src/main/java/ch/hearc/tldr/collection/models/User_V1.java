
package ch.hearc.tldr.collection.models;

import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import ch.hearc.tldr.collection.service.RoleService;

@Entity
public class User_V1 extends User
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public User_V1(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
		{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
		}

	public User_V1(String username, String password, Role role)
		{
		this(username, password, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null);
		this.role = role;
		}

	public User_V1(String username, String password)
		{
		this(username, password, roleService.getRoleByName("DEFAULT"));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	@Autowired
	private static RoleService roleService;
	private Role role;

	}
