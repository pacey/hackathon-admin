package org.hackers.domain.idea;

import org.hackers.domain.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private DAO<Idea> ideaDAO;

	@Override
	public void put(Idea idea){
		ideaDAO.saveOrUpdate(idea);
	}

	@Override
	public Collection<Idea> getAll(){
		return ideaDAO.getAll();
	}

}
