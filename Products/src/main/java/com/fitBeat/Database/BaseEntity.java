package com.fitBeat.Database;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public class BaseEntity {

	@Field("create_ts")
	private Long createTs;

	@Field("update_ts")
	private Long updateTs;

	@Field("created_by")
	private String createdBy;

	@Field("updated_by")
	private String updatedBy;

	public Long getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Long createTs) {
		this.createTs = createTs;
	}

	public Long getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(Long updateTs) {
		this.updateTs = updateTs;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
}
