
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
		admin.setName("ROLE_ADMIN");
		roleService.saveRole(admin);

		Role user = new Role();
		user.setName("ROLE_USER");
		roleService.saveRole(user);
		}

	private void seedUserTable()
		{
		user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setPassword("admin");
		user.setEmail("admin@tldr.com");

		List<Role> roles = roleService.findAllRoles();
		for(Role role:roles)
			{
			user.addRole(roleService.findById(role.getId()));
			}
		userService.save(user);
		}

	private void seedTLDRTable()
		{
		TLDR tldr1 = new TLDR();
		tldr1.setName("Summary of Article 1");
		tldr1.setContent("In this article, the author discusses the impact of technology on society and how it is shaping the future." //
				+ " They argue that while technology has brought many benefits, it also poses certain challenges that need to be addressed.");
		tldr1.setUser(userService.findUserByEmail(this.user.getEmail()));

		TLDR tldr2 = new TLDR();
		tldr2.setName("Summary of Article 2");
		tldr2.setContent("The article explores the current state of renewable energy and the potential for it to become the primary source of power in the future."//
				+ " The author argues that with the right policies in place, renewable energy can play a significant role in addressing the global climate crisis.");
		tldr2.setUser(userService.findUserByEmail(this.user.getEmail()));

		tldrService.save(tldr1);
		tldrService.save(tldr2);
		}
	}
