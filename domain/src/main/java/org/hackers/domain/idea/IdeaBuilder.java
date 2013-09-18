package org.hackers.domain.idea;

import org.hackers.domain.Builder;

import java.util.Date;

public class IdeaBuilder implements Builder<Idea> {

	private Idea idea;

	public IdeaBuilder() {
		idea = new Idea();
	}

	public IdeaBuilder setCreateDate(Date createDate){
		idea.setCreateDate(createDate);
		return this;
	}

	public IdeaBuilder setUpdateDate(Date updateDate){
		idea.setUpdateDate(updateDate);
		return this;
	}

	public IdeaBuilder setTitle(String title){
		idea.setTitle(title);
		return this;
	}

	public IdeaBuilder setDescription(String description){
		idea.setDescription(description);
		return this;
	}

	@Override
	public Idea build() {
		return idea;
	}

	@Override
	public void clear() {
		idea = new Idea();
	}
}
