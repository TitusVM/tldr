
package ch.hearc.tldr.collection.models.implementation;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TLDR
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int hashCode()
		{
		return Objects.hash(id);
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
		TLDR other = (TLDR)obj;
		return Objects.equals(this.id, other.id);
		}

	public Long getId()
		{
		return this.id;
		}

	public void setId(Long id)
		{
		this.id = id;
		}

	public String getName()
		{
		return this.name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public String getContent()
		{
		return this.content;
		}

	public void setContent(String content)
		{
		this.content = content;
		}

	public Long getVote()
		{
		return this.vote;
		}

	public void setVote(Long vote)
		{
		this.vote = vote;
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

	private String name;
	private String content;
	private Long vote;

	}
