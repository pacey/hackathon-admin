package org.hackers.domain.idea;

import org.hackers.domain.Created;
import org.hackers.domain.Updated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "IDEA")
public class Idea implements Created, Updated {

	private Long id;
	private Date createDate;
	private Date updateDate;
	private String title;
	private String description;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Idea idea = (Idea) o;

		if (createDate != null ? !createDate.equals(idea.createDate) : idea.createDate != null) {
			return false;
		}
		if (description != null ? !description.equals(idea.description) : idea.description != null) {
			return false;
		}
		if (id != null ? !id.equals(idea.id) : idea.id != null) {
			return false;
		}
		if (title != null ? !title.equals(idea.title) : idea.title != null) {
			return false;
		}
		if (updateDate != null ? !updateDate.equals(idea.updateDate) : idea.updateDate != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
		result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		return result;
	}
}
