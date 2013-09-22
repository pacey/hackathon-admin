package org.hackers.app.idea;

import org.hackers.AbstractApplicationTest;
import org.hackers.app.converter.ConvertingContainer;
import org.hackers.domain.idea.Idea;
import org.hackers.web.converter.IdeaFormIdeaConverter;
import org.hackers.web.rest.idea.IdeaForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: jamesp
 * Date: 22/09/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class IdeaFacadeTest extends AbstractApplicationTest {

	@Autowired
	private RestFacade<Idea> ideaFacade;

	@Autowired
	private Converter<IdeaForm, Idea> ideaFormIdeaConverter;

	@Test
	public void put(){
		IdeaForm ideaForm = new IdeaForm();
		ideaForm.setDescription("Idea description");
		Idea idea = ideaFacade.put(new ConvertingContainer<>(ideaFormIdeaConverter, ideaForm));
		assertNotNull(idea);
		assertNotNull(idea.getId());
		assertEquals("Idea description", idea.getDescription());
	}
}
