package com.lepu.system.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_system_permission")
public class SystemPermission extends BaseModel {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	/** token **/
	String token;
	/** 资源url **/
	String url;
	/** 权限说明 **/
	String description;
	@Column(insertable = false, updatable = false)
	Integer menuId;
	/** 权限 **/
	String permission;
	String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menuId", referencedColumnName = "id")
	SystemMenu systemMenu;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SystemMenu getSystemMenu() {
		return systemMenu;
	}

	public void setSystemMenu(SystemMenu systemMenu) {
		this.systemMenu = systemMenu;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

}
