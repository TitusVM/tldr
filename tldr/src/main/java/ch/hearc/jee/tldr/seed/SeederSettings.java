
package ch.hearc.jee.tldr.seed;

public enum SeederSettings
	{
ADMIN_FIRSTNAME
	{

	@Override
	public String toString()
		{
		return "Administrator";
		}
	},

ADMIN_LASTNAME
	{

	@Override
	public String toString()
		{
		return "Lastname";
		}
	},

ADMIN_PASSWORD
	{

	@Override
	public String toString()
		{
		return "admin";
		}
	},

ADMIN_EMAIL
	{

	@Override
	public String toString()
		{
		return "admin@tldr.com";
		}
	}
	}
