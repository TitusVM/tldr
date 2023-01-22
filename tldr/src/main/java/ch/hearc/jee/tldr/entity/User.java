
package ch.hearc.jee.tldr.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User
	{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "users_roles", //
			joinColumns = { //
					@JoinColumn( //
							name = "user_id", //
							referencedColumnName = "id") }, //
			inverseJoinColumns = { //
					@JoinColumn( //
							name = "role_id", //
							referencedColumnName = "id") })
	private List<Role> roles = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<TLDR> tldrs = new ArrayList<TLDR>();

	public void addRole(Role role)
		{
		if (this.roles == null)
			{
			this.roles = new ArrayList<>();
			}
		this.roles.add(role);
		}

	@Override
	public String toString()
		{
		return "User [id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", password=" + this.password + ", roles=" + this.rolesToString() + "]";
		}

	public String rolesToString()
		{
		return this.roles.stream().map(Role::getName).collect(Collectors.joining(", "));
		}

	}
