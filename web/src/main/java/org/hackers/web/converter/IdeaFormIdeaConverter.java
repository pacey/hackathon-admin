package org.hackers.web.converter;

import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaBuilder;
import org.hackers.web.rest.idea.IdeaForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: jamesp
 * Date: 20/09/13
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class IdeaFormIdeaConverter implements Converter<IdeaForm, Idea> {

	@Override
	public Idea convert(IdeaForm ideaForm) {
		IdeaBuilder ideaBuilder = new IdeaBuilder();
		return ideaBuilder.setDescription(ideaForm.getDescription()).build();
	}

}
