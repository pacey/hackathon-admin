package org.hackers.domain.idea;

import org.hackers.AbstractApplicationTest;
import org.hackers.domain.DAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.Assert.assertNotNull;

public class HibernateIdeaDAOTest extends AbstractApplicationTest {

	@Autowired
	private DAO<Idea> hibernateIdeaDAO;

	@Test
	public void save(){
		Date date = new Date();
		Idea idea = new Idea();
		idea.setCreateDate(date);
		idea.setUpdateDate(date);
		idea.setTitle("Test title");
		idea.setDescription("Test description");
		hibernateIdeaDAO.saveOrUpdate(idea);
		assertNotNull(idea.getId());
	}
}
