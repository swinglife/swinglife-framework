package com.lepu.system.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_system_menu")
public class SystemMenu extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String url;

	private String description;

	private Integer parentId;

	private String icon;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "systemMenu", fetch = FetchType.EAGER)
	List<SystemPermission> systemPermission;

	@Transient
	List<SystemMenu> subMenus;

	public List<SystemMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SystemMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SystemPermission> getSystemPermission() {
		return systemPermission;
	}

	public void setSystemPermission(List<SystemPermission> systemPermission) {
		this.systemPermission = systemPermission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
