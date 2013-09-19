package org.hackers.domain.idea;

import org.hackers.AbstractApplicationTest;
import org.hackers.domain.DAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;

public class HibernateIdeaDAOTest extends AbstractApplicationTest {

	@Autowired
	private DAO<Idea> hibernateIdeaDAO;

	@Test
	public void save(){
		Date date = new Date();
		IdeaBuilder ideaBuilder = new IdeaBuilder();
		Idea idea = ideaBuilder.setCreateDate(date)
				.setUpdateDate(date)
				.setTitle("Test title")
				.setDescription("Test description")
				.build();
		hibernateIdeaDAO.saveOrUpdate(idea);
		assertNotNull(idea.getId());
	}
}
