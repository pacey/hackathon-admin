package org.hackers.domain.idea;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdeaDTOIdeaConverter implements Converter<IdeaDTO, Idea> {

	@Override
	public Idea convert(IdeaDTO source) {
		IdeaBuilder ideaBuilder = new IdeaBuilder();
		return ideaBuilder.setDescription(source.getDescription())
				.setTitle(source.getTitle())
				.setCreateDate(source.getCreateDate())
				.setUpdateDate(source.getUpdateDate())
				.build();
	}

}
