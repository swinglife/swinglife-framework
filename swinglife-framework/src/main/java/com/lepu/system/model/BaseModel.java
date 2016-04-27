package com.lepu.system.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date createTime;
	private Date updateTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
