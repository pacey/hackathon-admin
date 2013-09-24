package org.hackers.domain.idea;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: jamesp
 * Date: 22/09/13
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
public interface IdeaService {
	Idea put(Long id, IdeaDTO idea);
	Idea get(Long id);
	Collection<Idea> getAll();
	void delete(Long id);
	Idea post(IdeaDTO ideaDTO);
}
