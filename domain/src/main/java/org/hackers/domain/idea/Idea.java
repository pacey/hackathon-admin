package org.hackers.domain.idea;

import org.hackers.domain.Created;
import org.hackers.domain.Updated;

import java.util.Date;

public class Idea implements Created, Updated {

	private Date createDate;
	private Date updateDate;
	private String title;
	private String description;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
