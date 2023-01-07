
package ch.hearc.tldr.collection.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Long getId()
		{
		return this.id;
		}

	public String getUsername()
		{
		return this.username;
		}

	public String getPassword()
		{
		return this.password;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setId(Long id)
		{
		this.id = id;
		}

	public void setUsername(String username)
		{
		this.username = username;
		}

	public void setPassword(String password)
		{
		this.password = password;
		}

	@Override
	public int hashCode()
		{
		return Objects.hash(id, password, username);
		}

	@Override
	public boolean equals(Object obj)
		{
		if (this == obj)
			{ return true; }
		if (obj == null)
			{ return false; }
		if (getClass() != obj.getClass())
			{ return false; }
		User other = (User)obj;
		return Objects.equals(this.id, other.id) && Objects.equals(this.password, other.password) && Objects.equals(this.username, other.username);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	@Id //
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long id;

	private String username;
	private String password;

	}
