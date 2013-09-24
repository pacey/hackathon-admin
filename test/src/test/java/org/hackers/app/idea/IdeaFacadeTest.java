package org.hackers.app.idea;

import org.hackers.test.AbstractApplicationTest;
import org.hackers.app.converter.ConvertingContainer;
import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaDTO;
import org.hackers.web.converter.IdeaFormIdeaDTOConverter;
import org.hackers.web.rest.idea.IdeaForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class IdeaFacadeTest extends AbstractApplicationTest {

	@Autowired
	private RestFacade<IdeaDTO, Idea> ideaFacade;

	@Autowired
	private IdeaFormIdeaDTOConverter ideaFormIdeaDTOConverter;

	@Test
	public void post(){
		IdeaForm ideaForm = new IdeaForm();
		ideaForm.setDescription("Idea description");
		Idea idea = ideaFacade.post(new ConvertingContainer<IdeaForm, IdeaDTO>(ideaFormIdeaDTOConverter, ideaForm));
		assertNotNull(idea);
		assertNotNull(idea.getId());
		assertEquals("Idea description", idea.getDescription());
	}
}
