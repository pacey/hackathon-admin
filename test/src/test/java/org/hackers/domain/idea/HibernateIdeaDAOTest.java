package org.hackers.domain.idea;

import org.hackers.domain.DAO;
import org.hackers.test.AbstractApplicationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertNotNull;

@Test
public class HibernateIdeaDAOTest extends AbstractApplicationTest {

	@Autowired
	private DAO<Idea> hibernateIdeaDAO;

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
