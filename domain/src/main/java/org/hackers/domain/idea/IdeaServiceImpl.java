package org.hackers.domain.idea;

import org.hackers.domain.DAO;
import org.hackers.domain.Merger;
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

	@Autowired
	private Merger<IdeaDTO,Idea> ideaMerger;

	@Autowired
	private IdeaDTOIdeaConverter ideaDTOIdeaConverter;

	@Override
	public Idea put(Long id, IdeaDTO ideaDTO){
		Idea mergedIdea = ideaMerger.merge(ideaDTO, ideaDAO.get(id));
		ideaDAO.saveOrUpdate(mergedIdea);
		return mergedIdea;
	}

	@Override
	public Idea post(IdeaDTO ideaDTO) {
		Idea idea = ideaDTOIdeaConverter.convert(ideaDTO);
		ideaDAO.saveOrUpdate(idea);
		return idea;
	}

	@Override
	public Idea get(Long id) {
		return ideaDAO.get(id);
	}

	@Override
	public Collection<Idea> getAll(){
		return ideaDAO.getAll();
	}

	@Override
	public void delete(Long id) {
		ideaDAO.delete(id);
	}

}
