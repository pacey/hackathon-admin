package org.hackers.app.idea;

import org.hackers.domain.container.Container;
import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaService;
import org.hackers.domain.idea.IdeaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class IdeaFacade implements RestFacade<Idea> {

	@Autowired
	private IdeaService ideaService;

	@Override
	public Collection<Idea> get() {
		return ideaService.getAll();
	}

	@Override
	public Idea get(Long id) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Idea put(Container<Idea> ideaContainer) {
		Idea idea = ideaContainer.get();
		ideaService.put(idea);
		return idea;
	}

	@Override
	public void delete(Long id) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
