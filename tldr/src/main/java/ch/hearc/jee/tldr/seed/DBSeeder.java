
package ch.hearc.jee.tldr.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.hearc.jee.tldr.entity.Role;
import ch.hearc.jee.tldr.entity.TLDR;
import ch.hearc.jee.tldr.entity.User;
import ch.hearc.jee.tldr.service.role.RoleService;
import ch.hearc.jee.tldr.service.tldr.TLDRService;
import ch.hearc.jee.tldr.service.user.UserService;

@Component
public class DBSeeder implements ApplicationRunner
	{

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private TLDRService tldrService;

	private User user;

	@Override
	public void run(ApplicationArguments args) throws Exception
		{
		System.out.println("------------------SEEDING------------------");
		seedRoleTable();
		seedUserTable();
		seedTLDRTable();
		System.out.println("------------------COMPLETE------------------");
		}

	private void seedRoleTable()
		{
		Role admin = new Role();
		admin.setName("ADMIN");
		roleService.saveRole(admin);
		}

	private void seedUserTable()
		{
		user = new User();
		user.setFirstName(SeederSettings.ADMIN_FIRSTNAME.toString());
		user.setLastName(SeederSettings.ADMIN_LASTNAME.toString());
		user.setPassword(SeederSettings.ADMIN_PASSWORD.toString());
		user.setEmail(SeederSettings.ADMIN_EMAIL.toString());

		List<Role> roles = roleService.findAllRoles();
		for(Role role:roles)
			{
			user.addRole(roleService.findById(role.getId()));
			System.out.println("ROLE : " + role.getName());
			}
		userService.save(user);
		System.out.println("Seeded admin user : " + userService.findUserByEmail(SeederSettings.ADMIN_EMAIL.toString()).toString());
		}

	private void seedTLDRTable()
		{
		for(SeederTLDRData tldrData:SeederTLDRData.values())
			{
			TLDR tldr = new TLDR();
			tldr.setName(tldrData.getName());
			tldr.setContent(tldrData.getContent());
			tldr.setUser(userService.findUserByEmail(SeederSettings.ADMIN_EMAIL.toString()));
			tldrService.saveSeeds(tldr);
			}
		}
	}
