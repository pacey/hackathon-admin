package org.hackers.app.idea;

import org.hackers.app.converter.ConvertingContainer;
import org.hackers.domain.DAO;
import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaBuilder;
import org.hackers.domain.idea.IdeaDTO;
import org.hackers.test.AbstractApplicationTest;
import org.hackers.web.converter.IdeaFormIdeaDTOConverter;
import org.hackers.web.rest.idea.IdeaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.testng.Assert.*;


@Test
public class IdeaFacadeTest extends AbstractApplicationTest {

	@Autowired
	private RestFacade<IdeaDTO, Idea> ideaFacade;

	@Autowired
	private DAO<Idea> ideaDAO;

	@Autowired
	private IdeaFormIdeaDTOConverter ideaFormIdeaDTOConverter;

	public void delete(){
		Idea idea = createIdeaData();
		ideaFacade.delete(idea.getId());
		idea = ideaDAO.get(idea.getId());
		assertNull(idea);
	}

	public void getAll(){
		createIdeaData();
		Collection<Idea> ideaCollection = ideaFacade.get();
		assertTrue(ideaCollection.size() >= 1);
	}

	public void get(){
		Idea idea = createIdeaData();
		Idea otherIdea = ideaFacade.get(idea.getId());
		assertEquals(otherIdea.getId(), idea.getId());
		assertEquals(otherIdea.getDescription(), idea.getDescription());
	}

	public void put(){
		Idea idea = createIdeaData();
		IdeaForm ideaForm = new IdeaForm();
		ideaForm.setDescription("Put description");
		Idea updatedIdea = ideaFacade.put(idea.getId(), new ConvertingContainer<>(ideaFormIdeaDTOConverter, ideaForm));
		assertEquals(updatedIdea.getId(), idea.getId());
		assertEquals(updatedIdea.getDescription(), ideaForm.getDescription());
	}

	public void post(){
		IdeaForm ideaForm = new IdeaForm();
		ideaForm.setDescription("Post description");
		Idea idea = ideaFacade.post(new ConvertingContainer<>(ideaFormIdeaDTOConverter, ideaForm));
		assertNotNull(idea.getId());
		assertEquals(idea.getDescription(), ideaForm.getDescription());
	}

	private Idea createIdeaData(){
		IdeaBuilder ideaBuilder = new IdeaBuilder();
		Idea dummyIdea =  ideaBuilder.setDescription("Test description").build();
		ideaDAO.saveOrUpdate(dummyIdea);
		return dummyIdea;
	}
}
