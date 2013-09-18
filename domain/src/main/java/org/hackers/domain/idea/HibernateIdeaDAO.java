package org.hackers.domain.idea;

import org.hackers.domain.AbstractHibernateDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateIdeaDAO extends AbstractHibernateDAO<Idea> {

	public HibernateIdeaDAO() {
		super(Idea.class);
	}
}
