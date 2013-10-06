package org.hackers.app.idea;

import org.hackers.domain.container.Container;
import org.hackers.domain.idea.Idea;
import org.hackers.domain.idea.IdeaDTO;
import org.hackers.domain.idea.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

@Service
@Transactional
public class IdeaFacadeImpl implements RestFacade<IdeaDTO, Idea> {

	@Autowired
	private IdeaService ideaService;

	@Override
	public Collection<Idea> get() {
		return ideaService.getAll();
	}

	@Override
	public Idea get(Long id) {
		return ideaService.get(id);
	}

	@Override
	public Idea put(Long id, Container<IdeaDTO> ideaDTOContainer) {
		IdeaDTO ideaDTO = ideaDTOContainer.get();
		Date date = new Date();
		ideaDTO.setUpdateDate(date);
		return ideaService.put(id, ideaDTO);
	}

	@Override
	public Idea post(Container<IdeaDTO> ideaDTOContainer) {
		IdeaDTO ideaDTO = ideaDTOContainer.get();
		Date date = new Date();
		ideaDTO.setCreateDate(date);
		ideaDTO.setUpdateDate(date);
		return ideaService.post(ideaDTO);
	}

	@Override
	public void delete(Long id) {
		ideaService.delete(id);
	}
}
