package org.hackers.domain.idea;

import org.hackers.domain.Merger;
import org.springframework.stereotype.Component;

@Component
public class IdeaMerger implements Merger<IdeaDTO, Idea> {

	@Override
	public Idea merge(IdeaDTO source, Idea target) {
		target.setDescription(source.getDescription());
		target.setTitle(source.getTitle());
		target.setCreateDate(source.getCreateDate());
		target.setUpdateDate(source.getUpdateDate());
		return  target;
	}

}
