package com.cryptocoin.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Users_roles", catalog = "cryptocoin")
public class UsersRoles implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_role_id", unique = true, nullable = false)
	private Integer userRoleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_id", nullable = false)
	private Users users;
	
	@Column(name = "Role", nullable = false, length = 45)
	private String role;

	public UsersRoles() {
	}

	public UsersRoles(Users users, String role) {
		this.users = users;
		this.role = role;
	}

	
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
