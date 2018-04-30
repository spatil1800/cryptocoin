package com.cryptocoin.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Users", catalog = "cryptocoin", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "User_id", unique = true, nullable = false)
	private Integer userId;
	
	@NotEmpty(message="Please Enter Email")
	@Column(name = "Email", unique = true, nullable = false, length = 60)
	private String email;
	
	@NotEmpty(message="Please Enter First Name")
	@Column(name = "First_Name", nullable = false, length = 45)
	private String firstName;
	
	@NotEmpty(message="Please Enter Last Name")
	@Column(name = "Last_Name", nullable = false, length = 45)
	private String lastName;
	
	@Size(max=20,min=5,message="Please Enter Password Between 5 to 20 charecters.")
	@Column(name = "Password", nullable = false, length = 45)
	private String password;
	
	@Column(name = "Pass_Hash", nullable = false, length = 45)
	private String passHash;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<UsersRoles> usersRoleses = new HashSet(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private List<FavoritesCoins> favoritesCoinses = new ArrayList();
	
	public Users() {
	}

	public Users(String email, String firstName, String lastName, String password, String passHash) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.passHash = passHash;
	}


	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassHash() {
		return this.passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public Set getUsersRoleses() {
		return this.usersRoleses;
	}

	public void setUsersRoleses(Set usersRoleses) {
		this.usersRoleses = usersRoleses;
	}

	
	
	public List<FavoritesCoins> getFavoritesCoinses() {
		return this.favoritesCoinses;
	}

	public void setFavoritesCoinses(List<FavoritesCoins> favoritesCoinses) {
		this.favoritesCoinses = favoritesCoinses;
	}
	
	public Users(Integer userId, String email, String firstName, String lastName, String password, String passHash,
			Set<UsersRoles> usersRoleses) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.passHash = passHash;
		this.usersRoleses = usersRoleses;
	}
	
	
	
}
